package Controlador;

import java.net.Socket;
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

public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of run method, of class Cliente.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Cliente instance = new Cliente();
        instance.run();
        fail("The test case is a prototype.");
    }

    /**
     * Test of desconectar method, of class Cliente.
     */
    @Test
    public void testDesconectar() {
        System.out.println("desconectar");
        Cliente instance = new Cliente();
        instance.desconectar();
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of main method, of class Cliente.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Cliente.main(args);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSk method, of class Cliente.
     */
    @Test
    public void testGetSk() {
        System.out.println("getSk");
        Cliente instance = new Cliente();
        Socket expResult = null;
        Socket result = instance.getSocket1();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJugador method, of class Cliente.
     */
    @Test
    public void testGetJugador() {
        System.out.println("getJugador");
        Cliente instance = new Cliente();
        Modelo.Jugador expResult = null;
        Modelo.Jugador result = instance.getJugador();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of retarA method, of class Cliente.
     */
    @Test
    public void testRetarA() {
        System.out.println("retarA");
        String hashtag = "";
        Cliente instance = new Cliente();
        instance.retar(hashtag);
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarPartida method, of class Cliente.
     */
    @Test
    public void testIniciarPartida() {
        System.out.println("iniciarPartida");
        int idPartida = 0;
        Modelo.Jugador retador = null;
        Cliente instance = new Cliente();
        instance.iniciarPartida(idPartida, retador);
        fail("The test case is a prototype.");
    }

    /**
     * Test of jugadaRealizada method, of class Cliente.
     */
    @Test
    public void testJugadaRealizada() {
        System.out.println("jugadaRealizada");
        Modelo.TipoJugada jugada = null;
        Modelo.Partida p = null;
        Cliente instance = new Cliente();
        instance.jugadaRealizada(jugada, p);
        fail("The test case is a prototype.");
    }
    
}
