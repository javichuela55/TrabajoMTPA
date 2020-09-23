package Modelo;

import java.io.Serializable;
/**
 * Clase que define jugador
 * @author Guill
 *
 */

public class Jugador implements Serializable, Comparable<Jugador>{
    private String nombre;
    private boolean ganador;
    private String contrasena;
    private int rondasGanadas;
    private int partidasGanadas; 
    
       
    public Jugador() {
        nombre = "";
        contrasena = "";
        rondasGanadas=0;
        partidasGanadas=0;
        ganador = false;
    }

    public Jugador(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        rondasGanadas=0;
        partidasGanadas=0;
        ganador = false;
    }

    public Jugador(String nombre, String contrasena, int t, int p) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rondasGanadas = t;
        this.partidasGanadas= p;
        ganador = false;	 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public void setRondasGanadas(int rondasGanadas) {
        this.rondasGanadas = rondasGanadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public boolean getGanador() {
        return ganador;
    }

    public void setGanador(boolean winner) {
        this.ganador = winner;
    }

    public void incrementarPartidasGanadas(){
        this.partidasGanadas++;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "Usuario=" + nombre + ", Contrasena=" + contrasena + 
                ", rondasGanadas=" + rondasGanadas + ", rondasGanadas=" + partidasGanadas + '}';
    }

    @Override
    public int compareTo(Jugador j2) {
        if(this.partidasGanadas > j2.partidasGanadas)
            return -1;
        if(this.partidasGanadas < j2.partidasGanadas)
            return 1;
        return 0;
    } 
}
