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
public class ParrotTroubleTest {
    ParrotTrouble parrotTrouble = new ParrotTrouble();
    
    public ParrotTroubleTest() {
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
     * Test of parrotTrouble method, of class ParrotTrouble.
     */
    @Test
    public void testTalking8() {
        assertFalse(parrotTrouble.parrotTrouble(true, 8));
    }
    @Test
    public void testNotTalking8() {
        assertFalse(parrotTrouble.parrotTrouble(false, 8));
    }
    @Test
    public void testNotTalking7() {
        assertFalse(parrotTrouble.parrotTrouble(false, 7));
    }
    @Test
    public void testNotTalking6() {
        assertFalse(parrotTrouble.parrotTrouble(false, 6));
    }
    @Test
    public void testNotTalking20() {
        assertFalse(parrotTrouble.parrotTrouble(false, 20));
    }
    @Test
    public void testNotTalking21() {
        assertFalse(parrotTrouble.parrotTrouble(false, 21));
    }
    @Test
    public void testTalking7() {
        assertFalse(parrotTrouble.parrotTrouble(true, 7));
    }
    @Test
    public void testTalking6() {
        assertTrue(parrotTrouble.parrotTrouble(true, 6));
    }
    @Test
    public void testTalking20() {
        assertFalse(parrotTrouble.parrotTrouble(true, 20));
    }
    @Test
    public void testTalking21() {
        assertTrue(parrotTrouble.parrotTrouble(true, 21));
    }    
}
