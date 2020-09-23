package Modelo;

import java.io.Serializable;
import java.net.Socket;
/**
 * Clase que define la partida
 * @author Guill
 *
 */

public class Partida implements Serializable{
    private int idPartida;
    private Jugador ganador;
    private int rondas;
    private int rondasGanadasJ1;
    private int rondasGanadasJ2;
    private EstadoPartida estado;
    private Jugador j1;
    private Jugador j2;
    private TipoJugada jugada1;
    private TipoJugada jugada2;
    
    public Partida(int idPartida, Jugador j1, Jugador j2,  int rondas) {
        this.idPartida = idPartida;
        this.j1 = j1;
        this.j2 = j2;
        this.jugada1 = null;
        this.jugada2 = null;
        this.rondas = rondas;
        
        this.ganador = new Jugador();
        rondasGanadasJ1=0;
        rondasGanadasJ2=0;
        estado = EstadoPartida.pendiente;        
    }    
    
    public Partida(int idPartida, Jugador j1, Jugador j2) {
        this.idPartida = idPartida;
        this.j1 = j1;
        this.j2 = j2;
        this.jugada1 = null;
        this.jugada2 = null;
        this.rondas = DatosPartida.rondas;
        
        this.ganador = new Jugador();
        rondasGanadasJ1=0;
        rondasGanadasJ2=0;
        estado = EstadoPartida.pendiente;         
    } 
    
    public Partida(Jugador j1, Jugador j2) {
        this.j1 = j1;
        this.j2 = j2;
        this.jugada1 = null;
        this.jugada2 = null;
        this.rondas = DatosPartida.rondas;
        
        this.ganador = new Jugador();
        rondasGanadasJ1=0;
        rondasGanadasJ2=0;
        estado = EstadoPartida.encurso;         
    }  

    public int getIdPartida() {
        return idPartida;
    }

    public Jugador getJ1() {
        return j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public TipoJugada getJugada1() {
        return jugada1;
    }

    public TipoJugada getJugada2() {
        return jugada2;
    }
   
    public Jugador getGanador() {
        return ganador;
    }

    public int getRondas() {
        return rondas;
    }

    public int getRondasGanadasJ1() {
        return rondasGanadasJ1;
    }

    public int getRondasGanadasJ2() {
        return rondasGanadasJ2;
    }
    
    public boolean setJugada1(TipoJugada jugada1) {
        this.jugada1 = jugada1;
        return resolverJugada();
    }

    public EstadoPartida getEstado() {
        return estado;
    }

//Setters:    
    public void setIdPartida(int idPartida) {    
        this.idPartida = idPartida;
    }

    public boolean setJugada2(TipoJugada jugada2) {
        this.jugada2 = jugada2;
        return resolverJugada();
    }

    public void setRondasGanadasJ1(int rondasGanadasJ1) {
        this.rondasGanadasJ1 = rondasGanadasJ1;
    }

    public void setRondasGanadasJ2(int rondasGanadasJ2) {
        this.rondasGanadasJ2 = rondasGanadasJ2;
    }

    public void setEstado(EstadoPartida estado) {
        this.estado = estado;
    }
    
    public void puntoJ1() {
        this.rondasGanadasJ1++;
    }

    public void puntoJ2() {
        this.rondasGanadasJ2++;
    }
    


    public int getRondasRestantes() {
        return (rondas - (this.rondasGanadasJ1+this.rondasGanadasJ2));
    }
    
    public boolean resolverJugada(){
        boolean completada = false;
        if(jugada1 != null && jugada2 != null){ 

            if(j1.getGanador()){
                puntoJ2();
            }else{
                if(j2.getGanador()){
                    puntoJ1();
                }else{   
                    if(jugada1 == TipoJugada.PIEDRA){
                        if(jugada2 == TipoJugada.PIEDRA){
                            puntoJ1();
                            puntoJ2();
                        }
                        if(jugada2 == TipoJugada.PAPEL){
                            puntoJ2();
                        }
                        if(jugada2 == TipoJugada.TIJERA){
                            puntoJ1();
                        }
                    }
                    if(jugada1 == TipoJugada.PAPEL){
                        if(jugada2 == TipoJugada.PAPEL){
                            puntoJ1();
                            puntoJ2();
                        }
                        if(jugada2 == TipoJugada.PIEDRA){
                            puntoJ1();
                        }
                        if(jugada2 == TipoJugada.TIJERA){
                            puntoJ2();
                        }
                    }
                    if(jugada1 == TipoJugada.TIJERA){
                        if(jugada2 == TipoJugada.TIJERA){
                            puntoJ1();
                            puntoJ2();
                        }
                        if(jugada2 == TipoJugada.PAPEL){
                            puntoJ1();
                        }
                        if(jugada2 == TipoJugada.PIEDRA){
                            puntoJ2();
                        }
                    }
                }                   
            }
            
            if(getRondasRestantes()>0){
                jugada1 = null;
                jugada2 = null;
            }else{
                if(this.getRondasGanadasJ1()>this.getRondasGanadasJ2()){
                    this.ganador = j1;
                }else{
                    this.ganador = j2;
                }
                estado=EstadoPartida.terminada;
            }
            completada = true;
        }
        return completada;
    }

    @Override
    public String toString() {
        return "Partida{" + "idPartida=" + idPartida + ", j1=" + j1 + ", j2=" + 
                j2 + ",  ganador=" + ganador + ", rondas=" + rondas +
                ", rondasGanadasJ1=" + rondasGanadasJ1 + ", rondasGanadasJ2=" + rondasGanadasJ2 + 
                ", estado=" + estado + '}';
                
    }
    
    
    
}