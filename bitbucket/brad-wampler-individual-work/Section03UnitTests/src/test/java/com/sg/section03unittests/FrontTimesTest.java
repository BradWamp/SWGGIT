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
public class FrontTimesTest {
    FrontTimes times = new FrontTimes();
    
    public FrontTimesTest() {
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

    @Test
    public void testChocolate2() {
        assertEquals("ChoCho", times.frontTimes("Chocolate", 2));
    }
    @Test
    public void testChocolate3() {
        assertEquals("ChoChoCho", times.frontTimes("Chocolate", 3));
    }
    @Test
    public void testAbc3() {
        assertEquals("AbcAbcAbc", times.frontTimes("Abc", 3));
    }
    @Test
    public void testNegative() {
        assertEquals("try again", times.frontTimes("Chocolate", -2));
    }
    @Test
    public void test0() {
        assertEquals("", times.frontTimes("Chocolate", 0));
    }
}
