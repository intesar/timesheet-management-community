/*
 * BaseHibernateDAOTest.java
 * JUnit 4.x based test
 *
 * Created on November 24, 2007, 5:50 PM
 */

package com.abbhsoft.faq.dao;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mohammed
 */
public class BaseHibernateDAOTest {
    
    public BaseHibernateDAOTest() {
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
    public void getSession() {
        System.out.println("getSession");
        BaseHibernateDAO instance = new BaseHibernateDAO();
        Session expResult = null;
        Session result = instance.getSession();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of getSession method, of class BaseHibernateDAO. */
    
}
