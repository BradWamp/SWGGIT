/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DAO.ProductDao;
import DAO.ProductDaoFileImpl;
import DTO.Product;
import java.math.BigDecimal;
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
public class ProductDaoTest{
    ProductDao productTest;
    Product product1;
    Product product2;
    
    public ProductDaoTest() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        productTest = ctx.getBean("ProductDao", DAO.ProductDaoFileImpl.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        //productTest.emptyMap();
        
        Product product1 = new Product();
        product1.setLaborCostPerFoot(BigDecimal.ONE);
        product1.setMaterialCostPerFoot(BigDecimal.ONE);
        product1.setProduct("test1");
        this.product1 = product1;
        
        Product product2 = new Product();
        product1.setLaborCostPerFoot(BigDecimal.TEN);
        product1.setMaterialCostPerFoot(BigDecimal.TEN);
        product1.setProduct("test2");
        this.product2 = product2;
        
        productTest.addProduct(product1.getProduct(), product1);
        productTest.addProduct(product2.getProduct(), product2);        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProductRates method, of class ProductDao.
     */
    @Test
    public void testGetProductRates() throws Exception {
        assertEquals(productTest.getProductRates(product1.getProduct()), product1);
        assertEquals(productTest.getProductRates(product2.getProduct()), product2);
    }

    /**
     * Test of listProducts method, of class ProductDao.
     */
    @Test
    public void testListProducts() throws Exception {
        List <Product> productList = productTest.listProducts();
        
        assertEquals(6, productList.size());
    }
   
}
