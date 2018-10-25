/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DAO.TaxDao;
import DAO.TaxDaoFileImpl;
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
public class TaxDaoTest {
    TaxDao taxTest;
    Tax tax1;
    Tax tax2;
    
    public TaxDaoTest() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        taxTest = ctx.getBean("TaxDao", DAO.TaxDaoFileImpl.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //taxTest.emptyMap();
        
        Tax tax1 = new Tax();
        tax1.setState("test1");
        tax1.setTaxRate(BigDecimal.ONE);
        this.tax1 = tax1;
        
        Tax tax2 = new Tax();
        tax1.setState("test2");
        tax1.setTaxRate(BigDecimal.ONE);
        this.tax2 = tax2;
        
        taxTest.addTax(tax1.getState(), tax1);
        taxTest.addTax(tax2.getState(), tax2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTaxRate method, of class TaxDao.
     */
    @Test
    public void testGetTaxRate() throws Exception {
        assertEquals(tax1, taxTest.getTaxRate(tax1.getState()));
        assertEquals(tax2, taxTest.getTaxRate(tax2.getState()));
    }

    /**
     * Test of listTaxes method, of class TaxDao.
     */
    @Test
    public void testListTaxes() throws Exception {
        List <Tax> taxList = taxTest.listTaxes();
        
        assertEquals(6, taxList.size());
    }
    
}
