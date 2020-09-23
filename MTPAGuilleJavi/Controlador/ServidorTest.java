package Controlador;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * 
 * @author Guill
 *
 */

public class ServidorTest {
    
    public ServidorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRankingJugadores method, of class Servidor.
     */
    @Test
    public void testGetRankingJugadores() {
        System.out.println("getRankingJugadores");
        ArrayList< Modelo.Jugador> expResult = null;
        ArrayList< Modelo.Jugador> result = Servidor.getRankingJugadores();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPartidasEnJuego method, of class Servidor.
     */
    @Test
    public void testGetPartidasEnJuego() {
        System.out.println("getPartidasEnJuego");
        ArrayList< Modelo.Partida> expResult = null;
        ArrayList< Modelo.Partida> result = Servidor.getPartidasEnJuego();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPartidasFinalizadas method, of class Servidor.
     */
    @Test
    public void testGetPartidasFinalizadas() {
        System.out.println("getPartidasFinalizadas");
        ArrayList< Modelo.Partida> expResult = null;
        ArrayList< Modelo.Partida> result = Servidor.getPartidasFinalizadas();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJugadoresConectados method, of class Servidor.
     */
    @Test
    public void testGetJugadoresConectados() {
        System.out.println("getJugadoresConectados");
        ArrayList< Modelo.Jugador> expResult = null;
        ArrayList< Modelo.Jugador> result = Servidor.getJugadoresConectados();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientes method, of class Servidor.
     */
    @Test
    public void testGetClientes() {
        System.out.println("getClientes");
        HashMap<Socket,  Modelo.Jugador> expResult = null;
        HashMap<Socket,  Modelo.Jugador> result = Servidor.getClientes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class Servidor.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        Modelo.Jugador j = null;
        Socket expResult = null;
        Socket result = Servidor.getCliente(j);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPartida method, of class Servidor.
     */
    @Test
    public void testGetPartida() {
        System.out.println("getPartida");
        int idPartida = 0;
        Modelo.Partida expResult = null;
        Modelo.Partida result = Servidor.getPartida(idPartida);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of isParado method, of class Servidor.
     */
    @Test
    public void testIsParado() {
        System.out.println("isParado");
        boolean expResult = false;
        boolean result = Servidor.isParado();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParado method, of class Servidor.
     */
    @Test
    public void testSetParado() {
        System.out.println("setParado");
        boolean parado = false;
        Servidor.setParado(parado);
        fail("The test case is a prototype.");
    }

    /**
     * Test of inicializarFichero method, of class Servidor.
     */
    @Test
    public void testInicializarFichero() {
        System.out.println("inicializarFichero");
        Servidor instance = new Servidor();
        instance.inicializarFichero();
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarJugadores method, of class Servidor.
     */
    @Test
    public void testCargarJugadores() {
        System.out.println("cargarJugadores");
        Servidor instance = new Servidor();
        instance.cargarJugadores();
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirJugadorConectado method, of class Servidor.
     */
    @Test
    public void testAnadirJugadorConectado() {
        System.out.println("anadirJugadorConectado");
        Modelo.Jugador j = null;
        Servidor.anadirJugadorConectado(j);
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirJugadorFichero method, of class Servidor.
     */
    @Test
    public void testAnadirJugadorFichero() {
        System.out.println("anadirJugadorFichero");
        Modelo.Jugador j = null;
        Servidor.anadirJugadorFichero(j);
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirCliente method, of class Servidor.
     */
    @Test
    public void testAnadirCliente() {
        System.out.println("anadirCliente");
        Socket s = null;
        Modelo.Jugador j = null;
        Servidor.anadirCliente(s, j);
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirPartida method, of class Servidor.
     */
    @Test
    public void testAnadirPartida() {
        System.out.println("anadirPartida");
        Modelo.Partida p = null;
        Servidor.anadirPartida(p);
        fail("The test case is a prototype.");
    }

    /**
     * Test of desconectarJugador method, of class Servidor.
     */
    @Test
    public void testDesconectarJugador() {
        System.out.println("desconectarJugador");
        Socket s = null;
        Servidor.desconectarJugador(s);
        fail("The test case is a prototype.");
    }

    /**
     * Test of desconectarHS method, of class Servidor.
     */
    @Test
    public void testDesconectarHS() {
        System.out.println("desconectarHS");
        Modelo.HiloServidor hsAEliminar = null;
        Servidor.desconectarHS(hsAEliminar);
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerHiloServidor method, of class Servidor.
     */
    @Test
    public void testObtenerHiloServidor() {
        System.out.println("obtenerHiloServidor");
        Socket s = null;
        Modelo.HiloServidor expResult = null;
        Modelo.HiloServidor result = Servidor.obtenerHiloServidor(s);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of escribirJugadoresFichero method, of class Servidor.
     */
    @Test
    public void testEscribirJugadoresFichero() {
        System.out.println("escribirJugadoresFichero");
        Servidor.escribirJugadoresFichero();
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizarJugada method, of class Servidor.
     */
    @Test
    public void testRealizarJugada() {
        System.out.println("realizarJugada");
        Modelo.TipoJugada jugada = null;
        Modelo.Partida p = null;
        Modelo.Jugador j = null;
        Servidor.realizarJugada(jugada, p, j);
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarListaConectados method, of class Servidor.
     */
    @Test
    public void testActualizarListaConectados() {
        System.out.println("actualizarListaConectados");
        Servidor.actualizarListaConectados();
        
        fail("The test case is a prototype.");
    }

    /**
     * Test of retarA method, of class Servidor.
     */
    @Test
    public void testRetarA() {
        System.out.println("retarA");
        String retado = "";
        Modelo.Jugador retador = null;
        String expResult = "";
        String result = Servidor.retar(retado, retador);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarPartida method, of class Servidor.
     */
    @Test
    public void testIniciarPartida() {
        System.out.println("iniciarPartida");
        Modelo.Jugador retador = null;
        Modelo.Jugador retado = null;
        Modelo. Partida p = null;
        Servidor.iniciarPartida(retador, retado, p);
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Servidor.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Servidor.main(args);
        fail("The test case is a prototype.");
    }
    
}
