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
public class AbbaTest {
    Abba abba = new Abba();
    
    public AbbaTest() {
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
     * Test of abba method, of class Abba.
     */
    @Test
    public void testAbba1() {
        String a = "a";
        String b = "b";
        String expectedResults = "abba";
        
        assertEquals(expectedResults, abba.abba(a, b));
    }
    @Test
    public void testAbba2() {
        String b = "b";
        String a = "a";
        String expectedResults = "baab";
        
        assertEquals(expectedResults, abba.abba(b, a));
    }
}
