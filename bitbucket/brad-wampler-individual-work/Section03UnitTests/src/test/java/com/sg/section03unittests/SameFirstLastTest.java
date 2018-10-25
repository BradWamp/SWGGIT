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
public class SameFirstLastTest {
    SameFirstLast firstLast = new SameFirstLast();
    
    public SameFirstLastTest() {
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
     * Test of sameFirstLast method, of class SameFirstLast.
     */
    @Test
    public void testnotsame1() {
        int[] intArray = {1,2,3};
        assertFalse(firstLast.sameFirstLast(intArray));
    }
    @Test
    public void testsame1() {
        int[] intArray = {1,2,1};
        assertTrue(firstLast.sameFirstLast(intArray));
    }
    @Test
    public void testnotsame2() {
        int[] intArray = {1,2,1,2};
        assertFalse(firstLast.sameFirstLast(intArray));
    }
    @Test
    public void testsame2() {
        int[] intArray = {1,2,3,1};
        assertTrue(firstLast.sameFirstLast(intArray));
    }    
}
