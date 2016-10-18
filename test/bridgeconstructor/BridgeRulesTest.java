/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgeconstructor;

import expertsystem.RulesBase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Florian
 */
public class BridgeRulesTest {
    
    public BridgeRulesTest() {
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
     * Test of initFromXML method, of class BridgeRules.
     */
    @Test
    public void testInitFromXML() {
        System.out.println("Test initFromXML to implement");
        String filename = "";
        BridgeRules.initFromXML(filename);
    }

    /**
     * Test of initRulesBase method, of class BridgeRules.
     */
    @Test
    public void testInitRulesBase() {
        System.out.println("initRulesBase");
        String filename = "";
        RulesBase result = BridgeRules.initRulesBase(filename);
        assertNotNull(result);
    }
    
}
