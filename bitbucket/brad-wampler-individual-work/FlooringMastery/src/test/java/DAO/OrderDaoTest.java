/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DAO.OrderDao;
import DAO.OrderDaoFileImpl;
import DTO.Order;
import Service.OrderServiceImpl;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author j1bdw02
 */
public class OrderDaoTest {
    
    private OrderDao orderDao;
    //HashMap<Integer, Order> orderMap = new HashMap<>();
    List<Order> testList;
    String stringDate = "2013-06-01";
    LocalDate date = LocalDate.parse(stringDate);
    
    public OrderDaoTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        orderDao = ctx.getBean("OrderDao", OrderDaoFileImpl.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp()throws Exception {
        testList = orderDao.listOrders(date);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listOrders method, of class OrderDaoFileImpl.
     */
    @Test
    public void testListOrders() throws Exception {
        List <Order> orderList = orderDao.listOrders(date);
        Order newOrder = orderList.get(0);
        assertEquals(4,orderList.size());
        assertEquals("test1", newOrder.getCustomerName());
    }

    
    @Test
    public void testFindOrder() throws Exception {
        Order order1 = orderDao.findOrder(date, 1);
        assertEquals(1, order1.getOrderNumber());
        
        Order order2 = orderDao.findOrder(date, 2);
        assertEquals(2, order2.getOrderNumber());
        
        Order order3 = orderDao.findOrder(date, 3);
        assertEquals(3, order3.getOrderNumber());
        
        Order order4 = orderDao.findOrder(date, 4);
        assertEquals(4, order4.getOrderNumber());
    }
 
    /**
     * Test of addToList method, of class OrderDaoFileImpl.
     */
    @Test
    public void testAddToListAndRemove() throws Exception {
        Order newOrder = new Order();
        newOrder.setArea(BigDecimal.ONE);
        newOrder.setCostPerFoot(BigDecimal.ZERO);
        newOrder.setCustomerName("newtest");
        newOrder.setLaborCost(BigDecimal.ZERO);
        newOrder.setLaborPerFoot(BigDecimal.ZERO);
        newOrder.setMaterialCost(BigDecimal.ZERO);
        newOrder.setOrderNumber(testList.size()+1);
        newOrder.setProduct("testprodcut");
        newOrder.setState("KS");
        newOrder.setTax(BigDecimal.ZERO);
        newOrder.setTaxRate(BigDecimal.ZERO);
        newOrder.setTotal(BigDecimal.ZERO);       
        
        testList = orderDao.addToList(newOrder, date);
        assertEquals(5, testList.size());
        Order testOrder = testList.get(4);
        assertEquals("newtest", testOrder.getCustomerName());
        
        testList = orderDao.removeOrder(testOrder, date);
        assertEquals(4,testList.size());
    }    
}
