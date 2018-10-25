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
public class SleepingInTest {
    SleepingIn sleeping = new SleepingIn();
    
    public SleepingInTest() {
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
    public void testWeekdayVacation() {
        assertTrue(sleeping.canSleepIn(true, true));
    }
    @Test
    public void testNotWeekdayVacation() {
        assertTrue(sleeping.canSleepIn(false, true));
    }
    @Test
    public void testNotWeekdayNotVacation() {
        assertTrue(sleeping.canSleepIn(false, false));
    }
    @Test
    public void testWeekdayNotVacation() {
        assertFalse(sleeping.canSleepIn(true, false));
    }
    
}
