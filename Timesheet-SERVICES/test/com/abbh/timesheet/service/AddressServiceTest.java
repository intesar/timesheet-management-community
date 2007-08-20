/*
 * AddressServiceTest.java
 * JUnit 4.x based test
 *
 * Created on August 19, 2007, 8:14 PM
 */

package com.abbh.timesheet.service;

import com.abbh.timesheet.model.Address;
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
public class AddressServiceTest {
    
    public AddressServiceTest () {
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

    @Test
    public void save() {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext( new String[] {"classpath:context/applicationContext-DAO.xml", "classpath:context/applicationContext-Services.xml", "classpath:context/applicationContext-Transactions.xml" });  
        AddressService a = (AddressService) factory.getBean("addressServiceImpl");
        Address address = new Address();
        address.setCity("CITY");
        address.setCountry("COUNTRY");
        address.setId(5L);
        address.setState("STATE");
        address.setStreet("STREET");
        address.setType("TYPE");
        a.save(address);
    } /* Test of save method, of class AddressService. */
    
}
