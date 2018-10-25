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
public class CanHazTableTest {
    CanHazTable table = new CanHazTable();
    
    public CanHazTableTest() {
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
     * Test of canHazTable method, of class CanHazTable.
     */
    @Test
    public void test8and5() {
       assertEquals(2,table.canHazTable(8, 5));
    }
    @Test
    public void test5and8() {
       assertEquals(2,table.canHazTable(5, 8));
    }
    @Test
    public void test5and5() {
       assertEquals(1,table.canHazTable(5, 5));
    }
    @Test
    public void test2and5() {
       assertEquals(0,table.canHazTable(2, 5));
    }
    @Test
    public void test5and2() {
       assertEquals(0,table.canHazTable(5, 2));
    }
    @Test
    public void test9and5() {
       assertEquals(2,table.canHazTable(9, 5));
    }
    @Test
    public void test5and9() {
       assertEquals(2,table.canHazTable(5, 9));
    }
    @Test
    public void test2and2() {
       assertEquals(0,table.canHazTable(2, 2));
    }
    @Test
    public void test2and8() {
       assertEquals(0,table.canHazTable(2, 8));
    }
    @Test
    public void test8and2() {
       assertEquals(0,table.canHazTable(8, 2));
    }
    
}
