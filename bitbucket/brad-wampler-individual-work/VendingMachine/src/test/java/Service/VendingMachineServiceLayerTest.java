/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.VendingDaoFile;
import Dao.VendingDaoFileStubImpl;
import Dao.VendingLoggingDao;
import Dao.VendingLoggingDaoFileImpl;
import Dto.Change;
import Dto.Item;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author J1BDW02
 */
public class VendingMachineServiceLayerTest {
    private VendingMachineServiceLayer testService;
    
    public VendingMachineServiceLayerTest() {
        //VendingDaoFile testDao = new VendingDaoFileStubImpl();
        //VendingLoggingDao testLoggingDao = new VendingLoggingDaoFileImpl();
        //testService = new VendingMachineServiceLayerImpl(testDao, testLoggingDao);
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        testService = ctx.getBean("myService", VendingMachineServiceLayerImpl.class);
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
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(1, testService.getAllItems().size());
    }

    /**
     * Test of getItemService method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItemService() throws Exception {
        Item item = testService.getItemService(1);
        assertNotNull(item);
    }
    @Test 
    public void testPurchaseItemInsufficientMoney() throws Exception {
        Item newItem = new Item();
        newItem.setAmount(1);
        newItem.setItem("test");
        newItem.setItemNumber(2);
        newItem.setPrice(BigDecimal.ONE);
        try {
            testService.purchaseItem(newItem, BigDecimal.ZERO);
            fail("Expected Exception was not thrown");
        }catch(InsufficientFundsException e) {
            return;
        }
    }
    @Test 
    public void testPurchaseItemInsufficientIventory() throws Exception {
        Item newItem = new Item();
        newItem.setAmount(0);
        newItem.setItem("test");
        newItem.setItemNumber(2);
        newItem.setPrice(BigDecimal.ONE);
        try {
            testService.purchaseItem(newItem, BigDecimal.ONE);
            fail("Expected Exception was not thrown");
        }catch(NoItemInventoryException e) {
            return;
        }
    }
    @Test
    public void testCalculateChange() throws Exception {
        Item newItem = testService.getItemService(1);
        Change newChange = testService.calculateChange(newItem.getPrice(),newItem.getPrice().add(BigDecimal.ONE));
        
        assertEquals(4, newChange.getQuarterCount());
        assertEquals(0, newChange.getDimeCount());
        assertEquals(0, newChange.getNickelCount());
        assertEquals(0, newChange.getPennyCount());
    }
    
    

    /**
     * Test of checkInventory method, of class VendingMachineServiceLayer.
     */
    /*@Test
    public void testCheckInsufficientInventory() throws Exception {
        Item newItem = new Item();
        newItem.setAmount(0);
        newItem.setItem("test");
        newItem.setItemNumber(2);
        newItem.setPrice(BigDecimal.ONE);
        try {
            testService.checkInventory(newItem);
            fail("Expected Exception was not thrown");
        }catch(NoItemInventoryException e) {
            return;
        }
    }
    @Test
    public void testCheckSufficientInventory() throws Exception {
        Item newItem = new Item();
        newItem.setAmount(1);
        newItem.setItem("test");
        newItem.setItemNumber(2);
        newItem.setPrice(BigDecimal.ONE);
        try {
            testService.checkInventory(newItem);
            return;
        }catch(NoItemInventoryException e) {
            fail("Exception was thrown");
        }
    }

    
    @Test
    public void testCheckSufficientMoney() throws Exception {
        Item newItem = new Item();
        newItem.setAmount(1);
        newItem.setItem("test");
        newItem.setItemNumber(2);
        newItem.setPrice(BigDecimal.ONE);
        try {
            testService.checkMoney(newItem, BigDecimal.ONE);
            return;
        }catch(InsufficientFundsException e) {
            fail("Exception was thrown");
        }
    }
    @Test
    public void testCheckInsufficientMoney() throws Exception {
        Item newItem = new Item();
        newItem.setAmount(1);
        newItem.setItem("test");
        newItem.setItemNumber(2);
        newItem.setPrice(BigDecimal.ONE);
        try {
            testService.checkMoney(newItem, BigDecimal.ZERO);
            fail("Exception was thrown");
        }catch(InsufficientFundsException e) {
            return;
        }
    }

    @Test
    public void testCalculateCoins()throws Exception {
        Item newItem = testService.getItemService(1);
        Change newChange = testService.calculateCoins(new BigDecimal("2"),newItem.getPrice());
        
        assertEquals(4, newChange.getQuarterCount());
        assertEquals(0, newChange.getDimeCount());
        assertEquals(0, newChange.getNickelCount());
        assertEquals(0, newChange.getPennyCount());
    }*/

    /**
     * Test of updateInventoryService method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testUpdateInventoryService() throws Exception {
        Item newItem = testService.getItemService(1);
        testService.updateInventoryService(newItem);
        assertNotNull(newItem);
    }    
}
