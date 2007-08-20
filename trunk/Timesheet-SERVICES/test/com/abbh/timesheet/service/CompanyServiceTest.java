/*
 * CompanyServiceTest.java
 * JUnit 4.x based test
 *
 * Created on August 19, 2007, 8:15 PM
 */

package com.abbh.timesheet.service;

import com.abbhsoft.framework.valueListHandler.ValueListHandler;
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
public class CompanyServiceTest {

    public CompanyServiceTest() {
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
    public void search() {
        System.out.println("search");
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(new String[]{"classpath:context/applicationContext-DAO.xml", "classpath:context/applicationContext-Services.xml", "classpath:context/applicationContext-Transactions.xml"});
        CompanyService instance = (CompanyService) factory.getBean("companyServiceImpl");

        String key = "chicago";


        ValueListHandler result = instance.search(key);
        result.createList(1);
        System.out.println(result.getCurrentResultList().size());
        System.out.println(result.getCurrentResultList());
        //assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    } /* Test of search method, of class CompanyService. */
}
