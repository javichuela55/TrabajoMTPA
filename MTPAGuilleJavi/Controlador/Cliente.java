package Controlador;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.logging.*;
import javax.swing.DefaultListModel;

import Modelo.DatosPartida;
import Modelo.Envio;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.TipoEnvio;
import Modelo.TipoJugada;
import Vista.InterfazGraficaCliente;
import Vista.MenuPrincipal;
/**
 * Esta clase es el cliente, en el declaramos los sockets y hace uso de las interfaces(actualizar y generar)
 * @author Guill
 *
 */
public class Cliente extends Thread {
    private Socket socket1;
    private Socket socket2;
    private Jugador jugador;
    private Envio m;
    private boolean conectado;
    public static ArrayList<InterfazGraficaCliente> interfaces;
    public static ArrayList<Partida> partidas;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
   
    
    @Override
    public void run() {
        try {
            socket1 = new Socket(DatosPartida.ipServer, DatosPartida.puertoServidor); 
            oos = new ObjectOutputStream(socket1.getOutputStream());
            ois = new ObjectInputStream(socket1.getInputStream());
            interfaces = new ArrayList<>();
            boolean datosCorrectos = false;
            conectado=true;
            while(!datosCorrectos && conectado){
            	 Scanner teclado = new Scanner(System.in);
                 String nombre, contrasena;
                 
                 System.out.println("Dime tu nombre de usuario: ");
                 nombre = teclado.nextLine();
                 System.out.println("Dime tu contrasena: ");
                 contrasena = teclado.nextLine();
                 
                 this.jugador = new Jugador(nombre,contrasena);
                m = new Envio(TipoEnvio.JUGADOR);
                m.addJugador(jugador);
                oos.writeObject(m); 
                
                m = (Envio)ois.readObject();
                if (m.getTipo()==TipoEnvio.LOGINOK || m.getTipo()==TipoEnvio.LOGINNUEVO){
                    String respuesta = m.getMensaje(0);
                    datosCorrectos = true;
                }
                if(m.getTipo()==TipoEnvio.LOGINYACONECTADO){
                    conectado=false;
                }
            }
            System.out.println(m.getMensaje(0));
            
       // dependiendo de la opcion se ejecuta un metodo u otro del menu     
            MenuPrincipal menu = new MenuPrincipal(socket1,jugador,this);            
            menu.setVisible(true);
            while(this.conectado){
                Envio nuevo = (Envio)ois.readObject();
                if(nuevo.getTipo()==TipoEnvio.ACTIVOS){
                    System.out.println("Recibiendo jugadores activos");
                    menu.actualizarJugadoresConectados(nuevo.getJugadores());
                }
                if(nuevo.getTipo()==TipoEnvio.RANKING){
                    System.out.println("Recibiendo ranking jugadores");
                    menu.actualizarRankingJugadores(nuevo.getJugadores());
                }
                if(nuevo.getTipo()==TipoEnvio.PARTACTIVAS){
                    System.out.println("Recibiendo partidas activas");
                    menu.actualizarPartidasActivas(nuevo.getPartidas());
                }
                if(nuevo.getTipo()==TipoEnvio.PARTFINALIZADAS){
                    System.out.println("Recibiendo partidas finalizadas");
                    menu.actualizarPartidasFinalizadas(nuevo.getPartidas());
                }
                if(nuevo.getTipo()==TipoEnvio.JUGADA){
                    System.out.println("Recibiendo jugada");
                    Partida p = nuevo.getPartida(0);
                    for(InterfazGraficaCliente inte : interfaces){
                        if(inte.getPartida().getIdPartida()==p.getIdPartida()){
                            inte.setPartida(p);
                            inte.actualizarInterfaz();
                        }
                    }                    
                }
             
                if(nuevo.getTipo()==TipoEnvio.LANZARETO){
                    System.out.println("Recibiendo reto");
                    Jugador retador = nuevo.getJugador(0);
                    int respuesta = menu.lanzarReto(retador); 
                    System.out.println("Has respondido al reto: "+respuesta);
                    Envio res =null;
                    switch(respuesta){
                        case 0: 
                            iniciarPartida(nuevo.getNumero(0),nuevo.getJugador(0));
                           
                            break;
                        case 1: 
                          
                            break;
                    }
                    res.addJugador(retador);
                    oos.writeObject(res);                    
                }
                if(nuevo.getTipo()==TipoEnvio.INICIARPARTIDA){
                    Partida partida = nuevo.getPartida(0);
                    Jugador oponente = nuevo.getJugador(1);

                    InterfazGraficaCliente inter= new InterfazGraficaCliente(partida,this);
                    inter.setVisible(true);
                    partidas.add(partida);
                    interfaces.add(inter);
                }
            }
            
        }catch (IOException ex) {
        	 Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ClassNotFoundException ex) {
        	 Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            }   
    
    public static void main(String[] args) {   
        new Cliente().start();        
    }

    public Socket getSocket1() {
        return socket1;
    }

    public Jugador getJugador() {
        return jugador;
    }
    
    public void retar(String nombre){
        try {
            Envio men = new Envio(TipoEnvio.LANZARETO);
            men.addMensaje(nombre);
            men.addJugador(jugador);
            oos.writeObject(men);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public void iniciarPartida(int idPartida, Jugador retador){
        try {
            System.out.println("Arranca la partida "+idPartida);
            Partida partida = new Partida(idPartida,retador,jugador);
            
            Envio men = new Envio(TipoEnvio.INICIARPARTIDA);
            men.addJugador(retador);
            men.addJugador(jugador);
            men.addPartida(partida);
            oos.writeObject(men);
            
            
            InterfazGraficaCliente inter= new InterfazGraficaCliente(partida,this);
            inter.setVisible(true);
            partidas.add(partida);
            interfaces.add(inter);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void jugadaRealizada(TipoJugada jugada,Partida partida){
        try {
            m=new Envio(TipoEnvio.JUGADA);
            m.addMensaje(jugada.toString());
            System.out.println("Has pulsado "+jugada);
            m.addPartida(partida);
            m.addJugador(jugador);
            oos.writeObject(m);
            System.out.println("Se ha enviado la jugada al hilo servidor");
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
 
    }
    public void desconectar(){
        try {
            ois.close();
            oos.close();
            socket1.close();
            this.conectado=false;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}