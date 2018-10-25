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
public class MakePiTest {
    MakePi pi = new MakePi();
    
    public MakePiTest() {
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
     * Test of makePi method, of class MakePi.
     */
    @Test
    public void testMakePi3() {
        int[] intArray = pi.makePi(1);
        assertEquals(3,intArray[0]);
        assertEquals(1,intArray.length);
    }
     public void testMakePi1() {
        int[] intArray = pi.makePi(2);
        assertEquals(1,intArray[0]);
        assertEquals(2,intArray.length);
    }
      public void testMakePi4() {
        int[] intArray = pi.makePi(3);
        assertEquals(4,intArray[0]);
        assertEquals(3,intArray.length);
    }
    
}
