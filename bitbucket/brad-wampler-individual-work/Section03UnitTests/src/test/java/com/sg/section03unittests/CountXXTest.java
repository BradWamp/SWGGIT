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
public class CountXXTest {
    CountXX xx = new CountXX();
    
    public CountXXTest() {
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
     * Test of countXX method, of class CountXX.
     */
    @Test
    public void testXX2() {
        assertEquals(2,xx.countXX("xxx"));
    }
     @Test
    public void testXX3() {
        assertEquals(3,xx.countXX("xxxxa"));
    }
     @Test
    public void testXX1() {
        assertEquals(1,xx.countXX("xxax"));
    }
     @Test
    public void testXX0() {
        assertEquals(0,xx.countXX("xaxax"));
    }
     @Test
    public void testOneLetter() {
        assertEquals(0,xx.countXX("x"));
    }
    
}
