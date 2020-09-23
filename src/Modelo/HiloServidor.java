package Modelo;
/**
 * Hilo del servidor
 * @author Guill
 *
 */
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.*;

import Controlador.Servidor;

public class HiloServidor extends Thread {
	private ObjectOutputStream oos;
    private ObjectInputStream ois;
	private Socket socket;
    private Jugador jugador;
    private ArrayList<Jugador> oponentes;
    private boolean activo; 
    private Envio m;
    
    
    public HiloServidor(Socket socket) {
        this.socket = socket;
        this.oponentes = new ArrayList<>();
      
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());       
            activo = true;
            start();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconectar() {
        try {
            Servidor.desconectarHS(this);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isActivo() {
        return activo;
    }
    
    
    @Override
    public void run() {
        int correcto = -1;
        try {
            while(correcto == -1){      
                m=(Envio)ois.readObject(); 
                if (m.getTipo()==TipoEnvio.JUGADOR){
                    jugador = m.getJugador(0);
                    correcto = comprobarUsuario(jugador); 
                    String paraEnviar = "";
                    Envio m2=null;
                    switch(correcto){
                        case 0: 
                            paraEnviar = "Validacion completada";
                            Servidor.anadirJugadorConectado(jugador);
                            Servidor.anadirCliente(socket, jugador);
                            m2 = new Envio(TipoEnvio.LOGINOK);
                            break;
                        case 1: 
                            paraEnviar = "Nuevo jugador. Bienvenido";
                            Servidor.anadirJugadorConectado(jugador);
                            Servidor.anadirJugadorFichero(jugador);
                            Servidor.anadirCliente(socket, jugador);
                            m2 = new Envio(TipoEnvio.LOGINNUEVO);
                            break;
                        case -1: 
                            paraEnviar = "El usuario y contrasena no coinciden";
                            m2 = new Envio(TipoEnvio.LOGINERROR);
                            break;
                        case 2:
                            paraEnviar = "Ya estas logueado";
                            m2 = new Envio(TipoEnvio.LOGINYACONECTADO);
                            activo = false;
                            break;
                    }                    
                    m2.addMensaje(paraEnviar);
                    oos.writeObject(m2);   
                }
            }
            Servidor.actualizarListaConectados();
            actualizarListaRanking();
            actualizarListaFinalizadas();
            while (this.activo){
            	Envio nuevo = (Envio)ois.readObject();
                if(nuevo.getTipo()==TipoEnvio.LANZARETO){
                    String retado = nuevo.getMensaje(0);
                    Jugador retador = nuevo.getJugador(0);
                    Servidor.retar(retado, retador);
                }
                if(nuevo.getTipo()==TipoEnvio.INICIARPARTIDA){
                    Jugador retador = nuevo.getJugador(0);
                    Servidor.iniciarPartida(retador,jugador,nuevo.getPartida(0));
                } 
                if(nuevo.getTipo()==TipoEnvio.JUGADA){
                    Servidor.realizarJugada(TipoJugada.valueOf(nuevo.getMensaje(0)), nuevo.getPartida(0), nuevo.getJugador(0));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int comprobarUsuario(Jugador j){
        ArrayList<Jugador> rankingJugadores = Servidor.getRankingJugadores();
        int resultado = 1; 
        for(Jugador ju : rankingJugadores){
            if(j.getNombre().equals(ju.getNombre())){
                if(j.getContrasena().equals(ju.getContrasena())){
                    resultado = 0; 
                    for(Jugador jug : Servidor.getJugadoresConectados()){
                        if(j.getNombre().equals(jug.getNombre())){
                            resultado = 2; 
                        }
                        break;
                    }
                    break;
                }else{
                    resultado = -1; 
                }
            }
        }
        return resultado;
    }
    
    
    public void cargarPantallaPartida(Jugador retador,Jugador retado, Partida p){
        try {
        	Envio mensa = new Envio(TipoEnvio.INICIARPARTIDA);
            mensa.addJugador(retador);
            mensa.addJugador(retado);
            mensa.addPartida(p);
            oos.writeObject(mensa);
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lanzaReto(Jugador retador){
        try {
        	Envio en = new Envio(TipoEnvio.LANZARETO);
            en.addJugador(retador);
            en.addNumero(Servidor.contadorPartidas);
            oos.writeObject(en);
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizarDatosPartida(Partida p){
        try {
        	Envio mensa = new Envio(TipoEnvio.RECARGAR);
            mensa.addPartida(p);
            oos.writeObject(mensa);
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizarListaRanking(){
        try {
            Envio mRanking = new Envio(TipoEnvio.RANKING);
            mRanking.setJugadores(Servidor.getRankingJugadores());
            oos.writeObject(mRanking);
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
    public void actualizarListaFinalizadas(){
        try {
            Envio mFinalizadas= new Envio(TipoEnvio.PARTFINALIZADAS);
            mFinalizadas.setPartidas(Servidor.getPartidasFinalizadas());
            oos.writeObject(mFinalizadas);
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarAUnoJugadoresConectados(ArrayList<Jugador> conectados){        
        try {
           Envio mActivos = new Envio(TipoEnvio.ACTIVOS);
            mActivos.setJugadores(conectados);
            oos.writeObject(mActivos);
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}