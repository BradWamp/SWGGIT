/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.Order;
import DTO.Product;
import DTO.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
 * @author j1bdw02
 */
public class OrderServiceTest {
    private OrderService service;
    List <Order> orderList;
    
    public OrderServiceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("OrderService", OrderServiceImpl.class);
    }
        
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        List <Order> orderList = service.listOrdersService(LocalDate.MAX);
        this.orderList = orderList;
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of calculateTotals method, of class OrderService.
     */
    @Test
    public void testCalculateTotals()throws Exception{
        Product newProduct = new Product();
        Tax newTax = new Tax();
        Order newOrder = new Order();
        newOrder.setArea(new BigDecimal("1"));
        
        newProduct.setLaborCostPerFoot(new BigDecimal("1"));
        newProduct.setMaterialCostPerFoot(new BigDecimal("1"));
        newProduct.setProduct("test1");
        
        newTax.setState("test1");
        newTax.setTaxRate(new BigDecimal("0"));
        
        newOrder = service.calculateTotals(newOrder, newTax, newProduct);
        assertEquals(new BigDecimal("2.00"), newOrder.getTotal());
    }

    /**
     * Test of generateOrderNumber method, of class OrderService.
     */
    @Test
    public void testGenerateOrderNumber() throws Exception{
        Order newOrder = new Order();
        newOrder = service.generateOrderNumber(newOrder);
        assertEquals(3, newOrder.getOrderNumber());
    }

    /**
     * Test of findOrderEdit method, of class OrderService.
     */
    @Test
    public void testFindOrderEdit() throws Exception {
        Order newOrder = service.findOrderEdit(0, LocalDate.now());
        assertEquals("Customer1", newOrder.getCustomerName());
    }

    /**
     * Test of compileOrderEdit method, of class OrderService.
     */
   /* @Test
    public void testCompileOrderEdit() {
        Order newOrder = new Order();
        service.compileOrderEdit("Name", "State", "Product", BigDecimal.ONE, newOrder);
        assertEquals("Name", newOrder.getCustomerName());
        assertEquals("State", newOrder.getState());
        assertEquals("Product", newOrder.getProduct());
        assertEquals(BigDecimal.ONE, newOrder.getArea());
    }*/

    /**
     * Test of removeOrderService method, of class OrderService.
     */
    @Test
    public void testRemoveOrderService() throws Exception {
        Order newOrder = new Order();
        newOrder.setOrderNumber(8);
        service.submitOrder(LocalDate.MAX, "y", newOrder, "remove");
        service.removeOrderService("y", newOrder, LocalDate.MAX);
        assertEquals(2,orderList.size());
        
    }
   
}
