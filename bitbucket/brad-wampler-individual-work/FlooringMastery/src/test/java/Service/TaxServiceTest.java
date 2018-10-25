/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.TaxDao;
import DAO.TaxDaoStubImpl;
import DTO.Tax;
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
public class TaxServiceTest {
    private TaxService service;
    List <Tax> orderList;
    
    public TaxServiceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("TaxService", TaxServiceImpl.class);
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
     * Test of getTaxRateService method, of class TaxService.
     */
    @Test
    public void testGetTaxRateService() throws Exception {
        Tax newTax = service.getTaxRateService("KS");
        assertEquals(new BigDecimal("1"),newTax.getTaxRate());
    }

    /**
     * Test of listTaxes method, of class TaxService.
     */
    @Test
    public void testListTaxes() throws Exception {
        List<Tax> taxList = service.listTaxes();
        assertEquals(2,taxList.size());
    }    
}
