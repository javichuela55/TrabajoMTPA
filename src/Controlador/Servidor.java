package Controlador;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.*;

import Modelo.DatosPartida;
import Modelo.HiloServidor;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.TipoJugada;
/**
 * Servidor por medio del que se comunican los jugadores
 * @author Guill
 *
 */
public class Servidor {
    private static ArrayList<Jugador> rankingJugadores; 
    private static ArrayList<Partida> partidasEnJuego; 
    private static ArrayList<Partida> partidasFinalizadas; 
    private static ArrayList<Jugador> jugadoresConectados; 
    private static HashMap<Socket,Jugador> clientes; 
    private static ArrayList<HiloServidor> hilosServidor;
    public static int contadorPartidas=0;
    private static boolean parado;
   
    
    public Servidor(){       
        this.rankingJugadores = new ArrayList<>();
        this.partidasEnJuego = new ArrayList<>();
        this.partidasFinalizadas = new ArrayList<>();
        this.jugadoresConectados = new ArrayList<>();
        this.hilosServidor = new ArrayList<>();
        this.clientes  = new HashMap<>();
        parado = false; 
        
        inicializarFichero(); 
        cargarJugadores(); 
    }

    public static ArrayList<Jugador> getRankingJugadores() {
        return rankingJugadores;
    }

    public static ArrayList<Partida> getPartidasEnJuego() {
        return partidasEnJuego;
    }

    public static ArrayList<Partida> getPartidasFinalizadas() {
        return partidasFinalizadas;
    }

    public static ArrayList<Jugador> getJugadoresConectados() {
        return jugadoresConectados;
    }

    public static HashMap<Socket,Jugador> getClientes() {
        return clientes;
    }
    
    public static Socket getCliente(Jugador j) {  
        for(Socket s: clientes.keySet()){
            Jugador jugador = clientes.get(s); 
            if(jugador.getNombre().equals(j.getNombre())){
                return s;
            }
        }
        return null;
    }
    
    public static Partida getPartida(int idPartida){
        for(Partida p: partidasEnJuego){
            if(p.getIdPartida()==idPartida){
                return p;
            }
        }
        return null;
    }

    public static boolean isParado() {
        return parado;
    }

    public static void setParado(boolean parado) {
        Servidor.parado = parado;
    }
    
    
    
    public static void anadirJugadorConectado(Jugador j){
        jugadoresConectados.add(j);
    }
    
    public static void anadirJugadorFichero(Jugador j){
        rankingJugadores.add(j);
        escribirJugadoresFichero();
    }
    
    public static void anadirCliente(Socket s, Jugador j){
        clientes.put(s,j);
    }
    
    public static void anadirPartida(Partida p){
        partidasEnJuego.add(p);
        System.out.println("Iniciada partida "+p.getIdPartida());
    }
    public void inicializarFichero(){
        File regJugadores = new File(DatosPartida.nombreFichero);
        if(!regJugadores.exists()){ 
            try{
                regJugadores.createNewFile();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        } 
    }
       
    public void cargarJugadores(){
        ObjectInputStream ois = null;
        rankingJugadores = new ArrayList<>();
        try {
            ois = new ObjectInputStream(new FileInputStream(DatosPartida.nombreFichero));
            
            Object aux = ois.readObject();
            while(aux!=null){                
                Jugador j = (Jugador)aux;                
                rankingJugadores.add(j);
                aux = ois.readObject();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {    
        } catch (ClassNotFoundException ex) {
        } finally {
            try {
                ois.close();
            } catch (Exception ex) {
               
            }
        }        
    }
   
    public static void escribirJugadoresFichero(){
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream(DatosPartida.nombreFichero)); 
            try{
                for(Jugador j: rankingJugadores){
                    oos.writeObject(j);
                } 
            }catch(IOException e){
                System.out.println(e.toString());
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
 
    
    
    
    public static String retar(String retado, Jugador retador){
        String respuesta = "";
        for(HiloServidor hs:hilosServidor){  
                if(hs.getJugador().getNombre().equals(retado)){
                    System.out.println("Doy orden de retar a "+retado);
                    hs.lanzaReto(retador);
                }
       
        }
        return respuesta;
    }
    
    public static void iniciarPartida(Jugador retador,Jugador retado, Partida partida){
        contadorPartidas++;       
        
        partida.setIdPartida(contadorPartidas);
        for(HiloServidor hs:hilosServidor){  
                if(hs.getJugador().getNombre().equals(retador.getNombre())){
                    
                    hs.cargarPantallaPartida(retador, retado, partida);
                }
        }
    }
    public static void desconectarHS(HiloServidor hiloSElim){       
        hilosServidor.remove(hiloSElim);
    }
    
    public static HiloServidor obtenerHiloServidor(Socket s){
        for(HiloServidor hiloS: hilosServidor){
            if(hiloS.getSocket().equals(s)){
                return hiloS;                
            }
        }
        return null;
    }
    public static void actualizarListaConectados(){        
        for(HiloServidor hiloS:hilosServidor){  
                System.out.println("Mando actualizar al hilo servidor de "+hiloS.getJugador().getNombre());
                hiloS.enviarAUnoJugadoresConectados(jugadoresConectados);
          
        }
    }
    public static void realizarJugada(TipoJugada jugada, Partida partida, Jugador j){
        boolean completada = false;
        if(partida.getJ1().getNombre().equals(j.getNombre())){
            completada = partida.setJugada1(jugada);
        }else{
            completada = partida.setJugada2(jugada);
        }
     
        for(HiloServidor hiloS:hilosServidor){  
            if(hiloS!=null && hiloS.getJugador()!= null && hiloS.getJugador().getNombre()!= null && 
                    (hiloS.getJugador().getNombre().equals(partida.getJ1().getNombre())
                    || hiloS.getJugador().getNombre().equals(partida.getJ2().getNombre()))){
                System.out.println("Mando jugada al hilo servidor de "+hiloS.getJugador().getNombre());
                partida.resolverJugada();
                hiloS.actualizarDatosPartida(partida);
            }
        }

    }
   
   
    public static void desconectarJugador(Socket s){ 
        Set<Socket> sockets = clientes.keySet();
        for(Socket s1 : sockets){
            if(s1.equals(s)){
                Jugador j = clientes.get(s1);
                for(Jugador j1: jugadoresConectados){
                    if(j1.getNombre().equals(j.getNombre())){
                        jugadoresConectados.remove(j1);
                        System.out.print("Se ha desconectado el jugador "+j1);
                        break;
                    }
                }
                clientes.remove(s1);
                System.out.println(" - Cliente: "+s1);
                break;
            }
        } 
        HiloServidor hiloS = obtenerHiloServidor(s);
        hilosServidor.remove(hiloS);
    }
    
    
    public static void main(String args[]) throws IOException {
        ServerSocket ss;
        System.out.print("Espere mientras iniciamos el servidor");
        try {
            new Servidor();
            ss = new ServerSocket(DatosPartida.puertoServidor);
            System.out.println("\t Preparado");
            
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Conexion aceptada de "+socket);
                HiloServidor hiloS = new HiloServidor(socket);    
                hilosServidor.add(hiloS);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}