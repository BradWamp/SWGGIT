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
public class MakeTagsTest {
    MakeTags tag = new MakeTags();
    
    public MakeTagsTest() {
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
     * Test of makeTags method, of class MakeTags.
     */
    @Test
    public void testITest() {
        assertEquals("<i>test</i>",tag.makeTags("i", "test"));
    }
    @Test
    public void testIHi() {
        assertEquals("<i>hi</i>",tag.makeTags("i", "hi"));
    }
    @Test
    public void testCiteTest() {
        assertEquals("<cite>test</cite>",tag.makeTags("cite", "test"));
    }
    
}
