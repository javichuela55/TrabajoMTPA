package Modelo;

import java.net.Socket;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HiloServidorTest {
    
    public HiloServidorTest() {
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
     * Test of desconectar method, of class HiloServidor.
     */
    @Test
    public void testDesconectar() {
        System.out.println("desconectar");
        HiloServidor instance = null;
        instance.desconectar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJugador method, of class HiloServidor.
     */
    @Test
    public void testGetJugador() {
        System.out.println("getJugador");
        HiloServidor instance = null;
        Jugador expResult = null;
        Jugador result = instance.getJugador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSocket method, of class HiloServidor.
     */
    @Test
    public void testGetSocket() {
        System.out.println("getSocket");
        HiloServidor instance = null;
        Socket expResult = null;
        Socket result = instance.getSocket();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActivo method, of class HiloServidor.
     */
    @Test
    public void testIsActivo() {
        System.out.println("isActivo");
        HiloServidor instance = null;
        boolean expResult = false;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class HiloServidor.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        HiloServidor instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarDatosPartida method, of class HiloServidor.
     */
    @Test
    public void testActualizarDatosPartida() {
        System.out.println("actualizarDatosPartida");
        Partida p = null;
        HiloServidor instance = null;
        instance.actualizarDatosPartida(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarPantallaPartida method, of class HiloServidor.
     */
    @Test
    public void testCargarPantallaPartida() {
        System.out.println("cargarPantallaPartida");
        Jugador retador = null;
        Jugador retado = null;
        Partida p = null;
        HiloServidor instance = null;
        instance.cargarPantallaPartida(retador, retado, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lanzaReto method, of class HiloServidor.
     */
    @Test
    public void testLanzaReto() {
        System.out.println("lanzaReto");
        Jugador retador = null;
        HiloServidor instance = null;
        instance.lanzaReto(retador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarListaRanking method, of class HiloServidor.
     */
    @Test
    public void testActualizarListaRanking() {
        System.out.println("actualizarListaRanking");
        HiloServidor instance = null;
        instance.actualizarListaRanking();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
   

    /**
     * Test of actualizarListaFinalizadas method, of class HiloServidor.
     */
    @Test
    public void testActualizarListaFinalizadas() {
        System.out.println("actualizarListaFinalizadas");
        HiloServidor instance = null;
        instance.actualizarListaFinalizadas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enviarAUnoJugadoresConectados method, of class HiloServidor.
     */
    @Test
    public void testEnviarAUnoJugadoresConectados() {
        System.out.println("enviarAUnoJugadoresConectados");
        ArrayList<Jugador> conectados = null;
        HiloServidor instance = null;
        instance.enviarAUnoJugadoresConectados(conectados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarUsuario method, of class HiloServidor.
     */
    @Test
    public void testComprobarUsuario() {
        System.out.println("comprobarUsuario");
        Jugador j = null;
        HiloServidor instance = null;
        int expResult = 0;
        int result = instance.comprobarUsuario(j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
