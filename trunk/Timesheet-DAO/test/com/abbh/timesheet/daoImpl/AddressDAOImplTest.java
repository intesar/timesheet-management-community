/*
 * AddressDAOImplTest.java
 * JUnit 4.x based test
 *
 * Created on August 12, 2007, 6:24 PM
 */

package com.abbh.timesheet.daoImpl;

import com.abbh.timesheet.dao.AddressDAO;
import com.abbh.timesheet.model.Address;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

/**
 *
 * @author shannan
 */
public class AddressDAOImplTest {
    
   public AddressDAOImplTest() {       
       instance = (AddressDAO) SpringSupport.getBean("addressDAOImpl");
   }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    private AddressDAO instance = null;
    
    
    public void save() {
        System.out.println ( "save");
        Address a = new Address();
        a.setCity("CITY");
        a.setCountry("USA");
        a.setState("STATE");
        a.setStreet("STREET");
        a.setType("TYPE");
        a.setZipcode("ZIPCODE");
        a.setId(3L);
        instance.save(a);
    }

    @Test
    public void findByStreet() {
        
        System.out.println("findByStreet");
        String street = "STREET";

        Collection result = instance.findByStreet(street);
        assertTrue(result.size() > 0);
        System.out.println(result.size());
    } /* Test of findByStreet method, of class AddressDAOImpl. */

    @Test
    public void findByZipcode() {
        System.out.println("findByZipcode");
        String zipcode = "ZIPCODE";


        Collection result = instance.findByZipcode(zipcode);
        assertTrue(result.size() > 0);
    } /* Test of findByZipcode method, of class AddressDAOImpl. */

    @Test
    public void findByCity() {
        System.out.println("findByCity");
        String city = "CITY";


        Collection result = instance.findByCity(city);
        assertTrue(result.size() > 0);
    } /* Test of findByCity method, of class AddressDAOImpl. */

    @Test
    public void findByState() {
        System.out.println("findByState");
        String state = "STATE";


        Collection result = instance.findByState(state);
        assertTrue(result.size() > 0);
    } /* Test of findByState method, of class AddressDAOImpl. */

    @Test
    public void findByType() {
        System.out.println("findByType");
        String type = "TYPE";


        Collection result = instance.findByType(type);
        assertTrue(result.size() > 0);
    } /* Test of findByType method, of class AddressDAOImpl. */

    @Test
    public void findByCountry() {
        System.out.println("findByCountry");
        String country = "COUNTRY";


        Collection result = instance.findByCountry(country);
        assertTrue(result.size() > 0);
    } /* Test of findByCountry method, of class AddressDAOImpl. */
}
