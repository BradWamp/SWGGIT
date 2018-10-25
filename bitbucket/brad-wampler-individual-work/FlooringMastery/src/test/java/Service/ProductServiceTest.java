/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ProductDao;
import DAO.ProductDaoStubImpl;
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
public class ProductServiceTest {
    private ProductService service;
    List <Product> orderList;
    
    public ProductServiceTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("ProductService", ProductServiceImpl.class);
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
     * Test of getProductRatesService method, of class ProductService.
     */
    @Test
    public void testGetProductRatesService() throws Exception {
        Product newProduct = service.getProductRatesService("test1");
        assertEquals(new BigDecimal("1"), newProduct.getLaborCostPerFoot());
        assertEquals(new BigDecimal("1"), newProduct.getMaterialCostPerFoot());
    }

    /**
     * Test of listProducts method, of class ProductService.
     */
    @Test
    public void testListProducts() throws Exception {
        List <Product> productList = service.listProducts();
        assertEquals(2,productList.size());
    }    
}
