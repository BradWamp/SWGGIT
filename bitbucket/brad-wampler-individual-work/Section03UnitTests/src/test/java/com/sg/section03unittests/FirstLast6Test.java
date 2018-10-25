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
public class FirstLast6Test {
    FirstLast6 firstLast = new FirstLast6();
    
    public FirstLast6Test() {
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
     * Test of firstLast6 method, of class FirstLast6.
     */
    @Test
    public void test6first() {
        int[] intArray = {6,2,3};
        assertTrue(firstLast.firstLast6(intArray));
    }
    @Test
    public void test6last() {
        int[] intArray = {1,2,6};
        assertTrue(firstLast.firstLast6(intArray));
    }
    @Test
    public void testno6() {
        int[] intArray = {1,6,3,4};
        assertFalse(firstLast.firstLast6(intArray));
    }
}
