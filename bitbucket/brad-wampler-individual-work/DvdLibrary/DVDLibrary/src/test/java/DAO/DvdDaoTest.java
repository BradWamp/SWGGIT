/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author bwamp
 */
public class DvdDaoTest {
    //private DvdDao dao = new DvdDaoFileImpl(); 
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    DvdDao dao = ctx.getBean("newDao", DvdDaoFileImpl.class);
   
   
    public DvdDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List <Dvd> newDvd = dao.listDvd();
        for(Dvd dvd : newDvd) {
            dao.removeDvd(dvd.getTitle());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdDao.
     */
    @Test
    public void testAddSearchDvd() throws Exception {
        Dvd newDvd = new Dvd();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt;
        newDvd.setTitle("this is a test");
        newDvd.setDirectorsName("test director");
        newDvd.setMpaaRatng("7");
        dt = LocalDate.parse("2017-12-31",dtf);
        newDvd.setReleaseDate(dt);
        newDvd.setStudio("Studio 42");
        newDvd.setUserRatingNotes("No Notes to add");
        
        dao.addDvd(newDvd.getTitle(), newDvd);
        Dvd anotherDvd = dao.searchForDvd(newDvd.getTitle());
        assertEquals(newDvd, anotherDvd);
        
    }

    /**
     * Test of removeDvd method, of class DvdDao.
     */
    @Test
    public void testRemoveDvd() throws Exception {
        Dvd newDvd = new Dvd();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt;
        newDvd.setTitle("this is a test");
        newDvd.setDirectorsName("test director");
        newDvd.setMpaaRatng("7");
        newDvd.setReleaseDate(LocalDate.parse("2017-12-31",dtf));
        newDvd.setStudio("Studio 42");
        newDvd.setUserRatingNotes("No Notes to add");
        
        dao.addDvd(newDvd.getTitle(), newDvd);
        dao.removeDvd("this is a test");
        
        assertEquals(0,dao.listDvd().size());
        // could add multiple and test that each remove has worked.
    }

    /**
     * Test of editDvd method, of class DvdDao.
     */
    @Test
    public void testEditDvd() throws Exception {
        Dvd newDvd = new Dvd();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        newDvd.setTitle("this is a test");
        newDvd.setDirectorsName("test director");
        newDvd.setMpaaRatng("7");
        newDvd.setReleaseDate(LocalDate.parse("2017-12-31",dtf));
        newDvd.setStudio("Studio 42");
        newDvd.setUserRatingNotes("No Notes to add");
        
        dao.addDvd(newDvd.getTitle(), newDvd);
        dao.editDvd("this is a test", 1, "this has been changed");
        assertEquals("this has been changed", newDvd.getTitle());
        
    }

    /**
     * Test of listDvd method, of class DvdDao.
     */
    @Test
    public void testListDvd() throws Exception {
        Dvd newDvd1 = new Dvd();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        newDvd1.setTitle("this is a test1");
        newDvd1.setDirectorsName("test director");
        newDvd1.setMpaaRatng("7");
        newDvd1.setReleaseDate(LocalDate.parse("2017-12-31",dtf));
        newDvd1.setStudio("Studio 42");
        newDvd1.setUserRatingNotes("No Notes to add");
        
        dao.addDvd(newDvd1.getTitle(), newDvd1);
        
        Dvd newDvd2 = new Dvd();
        newDvd2.setTitle("this is a test2");
        newDvd2.setDirectorsName("test director");
        newDvd2.setMpaaRatng("7");
        newDvd2.setReleaseDate(LocalDate.parse("2017-12-31",dtf));
        newDvd2.setStudio("Studio 42");
        newDvd2.setUserRatingNotes("No Notes to add");
        
        dao.addDvd(newDvd2.getTitle(), newDvd2);
        
        assertEquals(2, dao.listDvd().size());
    }

    /**
     * Test of searchForDvd method, of class DvdDao.
     */
    @Test
    public void testSearchForDvd() throws Exception { // already tested for with add.
    }
}
