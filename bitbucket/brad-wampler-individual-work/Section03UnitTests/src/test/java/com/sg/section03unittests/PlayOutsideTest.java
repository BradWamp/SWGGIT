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
public class PlayOutsideTest {
    PlayOutside play = new PlayOutside();
    
    public PlayOutsideTest() {
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
    public void test100Summer() {
        assertTrue(play.playOutside(100, true));
    }
    @Test
    public void test100NotSummer() {
        assertFalse(play.playOutside(100, false));
    }
    @Test
    public void test91Summer() {
        assertTrue(play.playOutside(91, true));
    }
    @Test
    public void test91NotSummer() {
        assertFalse(play.playOutside(91, false));
    }
    @Test
    public void test90Summer() {
        assertTrue(play.playOutside(90, true));
    }
    @Test
    public void test90NotSummer() {
        assertTrue(play.playOutside(90, false));
    }
    @Test
    public void test60Summer() {
        assertTrue(play.playOutside(60, true));
    }
    @Test
    public void test60NotSummer() {
        assertTrue(play.playOutside(60, false));
    }
    @Test
    public void test59Summer() {
        assertFalse(play.playOutside(59, true));
    }
    @Test
    public void test59SNotummer() {
        assertFalse(play.playOutside(59, false));
    }
    
}
