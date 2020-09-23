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

public class JugadorTest {
    
    public JugadorTest() {
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
     * Test of getHashtag method, of class Jugador.
     */
    @Test
    public void testGetHashtag() {
        System.out.println("getHashtag");
        Jugador instance = new Jugador();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHashtag method, of class Jugador.
     */
    @Test
    public void testSetHashtag() {
        System.out.println("setHashtag");
        String Hashtag = "";
        Jugador instance = new Jugador();
        instance.setNombre(Hashtag);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Jugador.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Jugador instance = new Jugador();
        String expResult = "";
        String result = instance.getContrasena();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Jugador.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String Password = "";
        Jugador instance = new Jugador();
        instance.setContrasena(Password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTandasGanadas method, of class Jugador.
     */
    @Test
    public void testGetTandasGanadas() {
        System.out.println("getTandasGanadas");
        Jugador instance = new Jugador();
        int expResult = 0;
        int result = instance.getRondasGanadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTandasGanadas method, of class Jugador.
     */
    @Test
    public void testSetTandasGanadas() {
        System.out.println("setTandasGanadas");
        int tandasGanadas = 0;
        Jugador instance = new Jugador();
        instance.setRondasGanadas(tandasGanadas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPartidasGanadas method, of class Jugador.
     */
    @Test
    public void testGetPartidasGanadas() {
        System.out.println("getPartidasGanadas");
        Jugador instance = new Jugador();
        int expResult = 0;
        int result = instance.getPartidasGanadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPartidasGanadas method, of class Jugador.
     */
    @Test
    public void testSetPartidasGanadas() {
        System.out.println("setPartidasGanadas");
        int partidasGanadas = 0;
        Jugador instance = new Jugador();
        instance.setPartidasGanadas(partidasGanadas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVirus method, of class Jugador.
     */
    @Test
    public void testGetVirus() {
        System.out.println("getVirus");
        Jugador instance = new Jugador();
        boolean expResult = false;
        boolean result = instance.getGanador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVirus method, of class Jugador.
     */
    @Test
    public void testSetVirus() {
        System.out.println("setVirus");
        boolean virus = false;
        Jugador instance = new Jugador();
        instance.setGanador(virus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementarPartidasGanadas method, of class Jugador.
     */
    @Test
    public void testIncrementarPartidasGanadas() {
        System.out.println("incrementarPartidasGanadas");
        Jugador instance = new Jugador();
        instance.incrementarPartidasGanadas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Jugador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Jugador instance = new Jugador();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Jugador.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Jugador j2 = null;
        Jugador instance = new Jugador();
        int expResult = 0;
        int result = instance.compareTo(j2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}