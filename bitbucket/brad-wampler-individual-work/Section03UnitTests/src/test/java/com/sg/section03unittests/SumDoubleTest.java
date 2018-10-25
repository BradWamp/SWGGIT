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
public class SumDoubleTest {
    SumDouble sumdouble = new SumDouble();
    
    public SumDoubleTest() {
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
    public void test1and1() {
        assertEquals(4,sumdouble.sumDouble(1, 1));
    }
    @Test
    public void test1and2() {
        assertEquals(3,sumdouble.sumDouble(1, 2));
    }
    @Test
    public void test3and2() {
        assertEquals(5,sumdouble.sumDouble(3, 2));
    }
    @Test
    public void test2and2() {
        assertEquals(8,sumdouble.sumDouble(2, 2));
    }
    
    
}
