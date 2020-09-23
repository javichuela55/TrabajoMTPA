package Modelo;

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

public class PartidaTest {
    
    public PartidaTest() {
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
     * Test of getIdPartida method, of class Partida.
     */
    @Test
    public void testGetIdPartida() {
        System.out.println("getIdPartida");
        Partida instance = null;
        int expResult = 0;
        int result = instance.getIdPartida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJ1 method, of class Partida.
     */
    @Test
    public void testGetJ1() {
        System.out.println("getJ1");
        Partida instance = null;
        Jugador expResult = null;
        Jugador result = instance.getJ1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJ2 method, of class Partida.
     */
    @Test
    public void testGetJ2() {
        System.out.println("getJ2");
        Partida instance = null;
        Jugador expResult = null;
        Jugador result = instance.getJ2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJugada1 method, of class Partida.
     */
    @Test
    public void testGetJugada1() {
        System.out.println("getJugada1");
        Partida instance = null;
        TipoJugada expResult = null;
        TipoJugada result = instance.getJugada1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJugada2 method, of class Partida.
     */
    @Test
    public void testGetJugada2() {
        System.out.println("getJugada2");
        Partida instance = null;
        TipoJugada expResult = null;
        TipoJugada result = instance.getJugada2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGanador method, of class Partida.
     */
    @Test
    public void testGetGanador() {
        System.out.println("getGanador");
        Partida instance = null;
        Jugador expResult = null;
        Jugador result = instance.getGanador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTandas method, of class Partida.
     */
    @Test
    public void testGetTandas() {
        System.out.println("getTandas");
        Partida instance = null;
        int expResult = 0;
        int result = instance.getRondas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTandasGanadasJ1 method, of class Partida.
     */
    @Test
    public void testGetTandasGanadasJ1() {
        System.out.println("getTandasGanadasJ1");
        Partida instance = null;
        int expResult = 0;
        int result = instance.getRondasGanadasJ1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTandasGanadasJ2 method, of class Partida.
     */
    @Test
    public void testGetTandasGanadasJ2() {
        System.out.println("getTandasGanadasJ2");
        Partida instance = null;
        int expResult = 0;
        int result = instance.getRondasGanadasJ2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJugada1 method, of class Partida.
     */
    @Test
    public void testSetJugada1() {
        System.out.println("setJugada1");
        TipoJugada jugada1 = null;
        Partida instance = null;
        boolean expResult = false;
        boolean result = instance.setJugada1(jugada1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Partida.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Partida instance = null;
        EstadoPartida expResult = null;
        EstadoPartida result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdPartida method, of class Partida.
     */
    @Test
    public void testSetIdPartida() {
        System.out.println("setIdPartida");
        int idPartida = 0;
        Partida instance = null;
        instance.setIdPartida(idPartida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJugada2 method, of class Partida.
     */
    @Test
    public void testSetJugada2() {
        System.out.println("setJugada2");
        TipoJugada jugada2 = null;
        Partida instance = null;
        boolean expResult = false;
        boolean result = instance.setJugada2(jugada2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTandasGanadasJ1 method, of class Partida.
     */
    @Test
    public void testSetTandasGanadasJ1() {
        System.out.println("setTandasGanadasJ1");
        int tandasGanadasJ1 = 0;
        Partida instance = null;
        instance.setRondasGanadasJ1(tandasGanadasJ1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTandasGanadasJ2 method, of class Partida.
     */
    @Test
    public void testSetTandasGanadasJ2() {
        System.out.println("setTandasGanadasJ2");
        int tandasGanadasJ2 = 0;
        Partida instance = null;
        instance.setRondasGanadasJ2(tandasGanadasJ2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Partida.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoPartida estado = null;
        Partida instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of puntoJ1 method, of class Partida.
     */
    @Test
    public void testPuntoJ1() {
        System.out.println("puntoJ1");
        Partida instance = null;
        instance.puntoJ1();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of puntoJ2 method, of class Partida.
     */
    @Test
    public void testPuntoJ2() {
        System.out.println("puntoJ2");
        Partida instance = null;
        instance.puntoJ2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTandasRestantes method, of class Partida.
     */
    @Test
    public void testGetTandasRestantes() {
        System.out.println("getTandasRestantes");
        Partida instance = null;
        int expResult = 0;
        int result = instance.getRondasRestantes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resolverJugada method, of class Partida.
     */
    @Test
    public void testResolverJugada() {
        System.out.println("resolverJugada");
        Partida instance = null;
        boolean expResult = false;
        boolean result = instance.resolverJugada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Partida.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Partida instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
