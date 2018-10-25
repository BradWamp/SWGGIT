/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bwamp
 */
public class MischeviousChildrenTest {
    MischeviousChildren children = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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
     * Test of areWeInTrouble method, of class MischeviousChildren.
     */
    @Test
    public void testTrueTrue() {
        /*System.out.println("areWeInTrouble");
        boolean aSmile = false;
        boolean bSmile = false;
        MischeviousChildren instance = new MischeviousChildren();
        boolean expResult = false;
        boolean result = instance.areWeInTrouble(aSmile, bSmile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
        assertTrue(children.areWeInTrouble(true, true));
    }
     @Test
    public void testTrueFalse() {
        assertFalse(children.areWeInTrouble(true, false));
    }
    @Test
    public void testFalseFalse() {
        assertTrue(children.areWeInTrouble(false, false));
    }
    @Test
    public void testFalseTrue() {
        assertFalse(children.areWeInTrouble(false, true));
    }
}
