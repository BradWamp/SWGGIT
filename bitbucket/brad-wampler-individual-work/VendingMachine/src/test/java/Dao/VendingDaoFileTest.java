/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author J1BDW02
 */
public class VendingDaoFileTest {
    
    //VendingDaoFile testDao = new VendingDaoFileImpl();
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    VendingDaoFile testDao = ctx.getBean("myDao", VendingDaoFileImpl.class);
    
    public VendingDaoFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        VendingDaoFile resetDao = new VendingDaoFileImpl();
        Item item = new Item();
        item.setItem("banana");
        item.setItemNumber(1);
        item.setAmount(1);
        item.setPrice(new BigDecimal("2.75"));
        resetDao.updateInventory(item);
        
        Item item2 = new Item();
        item2.setItem("apple");
        item2.setItemNumber(2);
        item2.setAmount(10);
        item2.setPrice(new BigDecimal("2.55"));
        resetDao.updateInventory(item2);
        
        Item item3 = new Item();
        item3.setItem("granola bar");
        item3.setItemNumber(3);
        item3.setAmount(10);
        item3.setPrice(new BigDecimal("1.00"));
        resetDao.updateInventory(item3);
        
        Item item4 = new Item();
        item4.setItem("snickers");
        item4.setItemNumber(4);
        item4.setAmount(9);
        item4.setPrice(new BigDecimal("3.00"));
        resetDao.updateInventory(item4);
    }
    
    @Before
    public void setUp() throws Exception {
        Item item = new Item();
        item.setItem("cupcake");
        item.setItemNumber(1);
        item.setAmount(10);
        item.setPrice(BigDecimal.ONE);
        
        testDao.updateInventory(item);
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of displayItems method, of class VendingDaoFile.
     */
    @Test
    public void testDisplayItems() throws Exception {
        Item item2 = new Item();
        item2.setItem("test");
        item2.setItemNumber(2);
        item2.setAmount(10);
        item2.setPrice(BigDecimal.ONE);
        
        testDao.updateInventory(item2);
        assertEquals(2,testDao.displayItems().size());
    }

    /**
     * Test of getItem method, of class VendingDaoFile.
     */
    @Test
    public void testGetItem() throws Exception {
        Item item = testDao.getItem(1);
        assertEquals("cupcake", item.getItem());
        
        Item item2 = new Item();
        item2.setItem("test");
        item2.setItemNumber(2);
        item2.setAmount(10);
        item2.setPrice(BigDecimal.ONE);
        testDao.updateInventory(item2);
        
        assertEquals("test", item2.getItem());
    }

    /**
     * Test of updateInventory method, of class VendingDaoFile.
     */
    @Test
    public void testUpdateInventory() throws Exception {
    //tested in previous two tests and in the teardownclass.
    }
}
