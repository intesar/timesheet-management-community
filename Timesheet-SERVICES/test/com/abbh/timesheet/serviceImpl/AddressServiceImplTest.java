/*
 * AddressServiceImplTest.java
 * JUnit 4.x based test
 *
 * Created on August 12, 2007, 10:32 PM
 */

package com.abbh.timesheet.serviceImpl;

import com.abbh.timesheet.model.Address;
import com.abbh.timesheet.service.AddressService;
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
public class AddressServiceImplTest {
    
    public AddressServiceImplTest () {
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
    } /* Test of setAddressDAO method, of class AddressServiceImpl. */
    
}
