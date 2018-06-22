/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modtrains;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author washo
 */
public class ComputeTest {

    public ComputeTest() {
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
     * Test of initLand method, of class Compute.
     */
    @Test
    public void testInitLand() {
        System.out.println("initLand");
        String name = "KiwiLand";
        List<String> _lstStr = Arrays.asList("AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7");
        Compute instance = new Compute();
        instance.initLand(name, _lstStr);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of getDistanceOfRoute method, of class Compute.
     */
    @Test
    public void testGetDistanceOfRoute() {
        System.out.println("getDistanceOfRoute");
        
        String name = "KiwiLand";
        List<String> _lstStr = Arrays.asList("AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7");
        Compute instance = new Compute();
        instance.initLand(name, _lstStr);
        String _strRoute = "A-B-C";
        int expResult = 9;        
        int result = instance.getDistanceOfRoute(_strRoute);
        assertEquals(expResult, result);
        _strRoute = "A-D";
        expResult = 5;
        result = instance.getDistanceOfRoute(_strRoute);
        assertEquals(expResult, result);
        _strRoute = "A-D-C";
        expResult = 13;
        result = instance.getDistanceOfRoute(_strRoute);
        assertEquals(expResult, result);
        _strRoute = "A-E-B-C-D";
        expResult = 22;
        result = instance.getDistanceOfRoute(_strRoute);
        assertEquals(expResult, result);
        _strRoute = "A-E-D";
        expResult = -1;
        result = instance.getDistanceOfRoute(_strRoute);
        assertEquals(expResult, result);
        

    }

    /**
     * Test of getLengthShortestRoute method, of class Compute.
     */
    @Test
    public void testGetLengthShortestRoute() {
        System.out.println("getLengthShortestRoute");
        String _strRoute = "";
        String name = "KiwiLand";
        List<String> _lstStr = Arrays.asList("AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7");
        Compute instance = new Compute();
        instance.initLand(name, _lstStr);
        int expResult = 0;
        int result = instance.getLengthShortestRoute(_strRoute);
        assertEquals(expResult, result);

    
    }


}
