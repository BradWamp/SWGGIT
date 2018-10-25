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
public class Diff21Test {
    Diff21 diff21 = new Diff21();
    
    public Diff21Test() {
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
    public void test0() {
        assertEquals(21,diff21.diff21(0));
    }
    @Test
    public void test21() {
        assertEquals(0,diff21.diff21(21));
    }
    @Test
    public void testnegative21() {
        assertEquals(42,diff21.diff21(-21));
    }
    @Test
    public void test22() {
        assertEquals(2,diff21.diff21(22));
    }
    @Test
    public void testnegative22() {
        assertEquals(43,diff21.diff21(-22));
    }
    
}
