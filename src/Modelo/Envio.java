package Modelo;

import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import Controlador.Cliente;
/**
 * Mensajes que se van a enviar por medio del servidor
 * @author Guill
 *
 */

public class Envio implements Serializable{
    private TipoEnvio tipo;
    private ArrayList<Cliente> clientes;
    private ArrayList<Socket> sockets;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Partida> partidas;
    private ArrayList<String> mensajes;
    private ArrayList<Integer> numeros;
    private ArrayList<TipoJugada> jugadas;
    
    public Envio(TipoEnvio tipo) {
        this.tipo = tipo;
        this.clientes = new ArrayList<>();
        this.sockets = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.partidas = new ArrayList<>();
        this.mensajes = new ArrayList<>();
        this.numeros = new ArrayList<>();
        this.jugadas = new ArrayList<>();
    }
    public TipoEnvio getTipo() {
        return tipo;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Socket> getSockets() {
        return sockets;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public ArrayList<String> getMensajes() {
        return mensajes;
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public ArrayList<TipoJugada> getJugadas() {
        return jugadas;
    }
    
    public Cliente getCliente(int i) {
        return clientes.get(i);
    }

    public Socket getSocket(int i) {
        return sockets.get(i);
    }

    public Jugador getJugador(int i) {
        return jugadores.get(i);
    }

    public Partida getPartida(int i) {
        return partidas.get(i);
    }

    public String getMensaje(int i) {
        return mensajes.get(i);
    }

    public Integer getNumero(int i) {
        return numeros.get(i);
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setSockets(ArrayList<Socket> sockets) {
        this.sockets = sockets;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    public void setMensajes(ArrayList<String> mensajes) {
        this.mensajes = mensajes;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    public void setJugadas(ArrayList<TipoJugada> jugadas) {
        this.jugadas = jugadas;
    }
    
    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void addSocket(Socket socket) {
        this.sockets.add(socket);
    }

    public void addJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void addPartida(Partida partida) {
        this.partidas.add(partida);
    }
    
    public void addMensaje(String mensaje) {
        this.mensajes.add(mensaje);
    }

    public void addNumero(Integer numero) {
        this.numeros.add(numero);
    }
    
    public void addJugada(TipoJugada jugada) {
        this.jugadas.add(jugada);
    }
}
