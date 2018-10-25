/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.dao.VendingMachineInMemDao;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bwamp
 */
public class VendingMachineServiceTest {
    
//    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        VendingMachineService service = ctx.getBean("VendingMachineService", VendingMachineServiceImpl.class);
    VendingMachineDao dao= new VendingMachineInMemDao();
    VendingMachineService service = new VendingMachineServiceImpl(dao);
    
    Map<Integer, Item> newMap = new HashMap<>();
    
    public VendingMachineServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         Item item = new Item();
        item.setItemNumber(1);
        item.setItem("Snickers");
        item.setPrice(new BigDecimal("1.50"));
        item.setAmount(10);
        newMap.put(item.getItemNumber(), item);
        
        item = new Item();
        item.setItemNumber(2);
        item.setItem("M&M's");
        item.setPrice(new BigDecimal("1.25"));
        item.setAmount(8);
        newMap.put(item.getItemNumber(), item);

        item = new Item();
        item.setItemNumber(3);
        item.setItem("Apple");
        item.setPrice(new BigDecimal("1.25"));
        item.setAmount(11);
        newMap.put(item.getItemNumber(), item);

        item = new Item();
        item.setItemNumber(4);
        item.setItem("Skittles");
        item.setPrice(new BigDecimal("1.65"));
        item.setAmount(3);
        newMap.put(item.getItemNumber(), item);

        item = new Item();
        item.setItemNumber(5);
        item.setItem("Payday");
        item.setPrice(new BigDecimal("1.75"));
        item.setAmount(2);
        newMap.put(item.getItemNumber(), item);

        item = new Item();
        item.setItemNumber(6);
        item.setItem("Oreo");
        item.setPrice(new BigDecimal("1.50"));
        item.setAmount(5);
        newMap.put(item.getItemNumber(), item);

        item = new Item();
        item.setItemNumber(7);
        item.setItem("Crackers");
        item.setPrice(new BigDecimal("2.35"));
        item.setAmount(4);
        newMap.put(item.getItemNumber(), item);

        item = new Item();
        item.setItemNumber(8);
        item.setItem("Cheese");
        item.setPrice(new BigDecimal("2.00"));
        item.setAmount(6);
        newMap.put(item.getItemNumber(), item);

        item = new Item();
        item.setItemNumber(9);
        item.setItem("Banana");
        item.setPrice(new BigDecimal("1.95"));
        item.setAmount(7);
        newMap.put(item.getItemNumber(), item);        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUserMoney method, of class VendingMachineService.
     */
    @Test
    public void testAddGetUserMoney() {
        service.addUserMoney("33");
        String money = service.getUserMoney();
        assertEquals(money, "33");
        
    }

    /**
     * Test of calculateChange method, of class VendingMachineService.
     */
    @Test
    public void testCalculateReturnChange() {
        service.addUserMoney("2");
        service.calculateChange(BigDecimal.ONE);
        String change = service.returnChange();
        assertEquals(change, "Quarters:4 Dimes:0 Nickles:0 Pennies:0"); 
    }

    /**
     * Test of clearVariables method, of class VendingMachineService.
     */
    @Test
    public void testClearVariables() {
        service.clearVariables();
        String test = service.getUserMoney();
        assertEquals(test, "0");
    }

    /**
     * Test of createItem method, of class VendingMachineService.
     */
    @Test
    public void testCreateItem() {
        Item testItem = new Item();
        testItem.setAmount(2);
        testItem.setItem("test");
        testItem.setItemNumber(10);
        testItem.setPrice(BigDecimal.ONE);
        
        service.createItem(testItem);
        Item item = service.returnItem();
        assertEquals(item.getItemNumber(), 10);
    }

    /**
     * Test of vendItem method, of class VendingMachineService.
     */
    @Test
    public void testVendItem() throws Exception {
        Item testItem = new Item();
        testItem.setAmount(2);
        testItem.setItem("test");
        testItem.setItemNumber(10);
        testItem.setPrice(BigDecimal.ONE);
        service.addUserMoney("1");
        
        service.vendItem(testItem);
        Item newItem = service.getItemById(testItem.getItemNumber());
        assertEquals(newItem.getItemNumber(), 10);
        service.clearVariables();
    }

    /**
     * Test of createMessage method, of class VendingMachineService.
     */
    @Test
    public void testCreateMessage() {
        service.createMessage("testing");
        String testMessage = service.displayMessage();
        assertEquals(testMessage, "testing");
        service.clearMessages();
        String testMessages2 = service.displayMessage();
        assertEquals(testMessages2, "");
    }

    /**
     * Test of displayMessage method, of class VendingMachineService.
     */
    @Test
    public void testDisplayMessage() {
    }

    /**
     * Test of clearMessages method, of class VendingMachineService.
     */
    @Test
    public void testClearMessages() {
    }

}
