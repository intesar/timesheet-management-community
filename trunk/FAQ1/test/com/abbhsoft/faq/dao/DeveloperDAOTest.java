/*
 * DeveloperDAOTest.java
 * JUnit 4.x based test
 *
 * Created on November 24, 2007, 5:50 PM
 */

package com.abbhsoft.faq.dao;

import com.abbhsoft.faq.model.Developer;
import java.util.List;
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
public class DeveloperDAOTest {
    
    public DeveloperDAOTest() {
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
        System.out.println("save");
        Developer transientInstance = null;
        DeveloperDAO instance = new DeveloperDAO();
        instance.save(transientInstance);
        fail("The test case is a prototype.");
    } /* Test of save method, of class DeveloperDAO. */

    @Test
    public void delete() {
        System.out.println("delete");
        Developer persistentInstance = null;
        DeveloperDAO instance = new DeveloperDAO();
        instance.delete(persistentInstance);
        fail("The test case is a prototype.");
    } /* Test of delete method, of class DeveloperDAO. */

    @Test
    public void findById() {
        System.out.println("findById");
        Integer id = null;
        DeveloperDAO instance = new DeveloperDAO();
        Developer expResult = null;
        Developer result = instance.findById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findById method, of class DeveloperDAO. */

    @Test
    public void findByExample() {
        System.out.println("findByExample");
        Developer instance_2 = null;
        DeveloperDAO instance = new DeveloperDAO();
        List expResult = null;
        List result = instance.findByExample(instance_2);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByExample method, of class DeveloperDAO. */

    @Test
    public void findByProperty() {
        System.out.println("findByProperty");
        String propertyName = "";
        Object value = null;
        DeveloperDAO instance = new DeveloperDAO();
        List expResult = null;
        List result = instance.findByProperty(propertyName, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByProperty method, of class DeveloperDAO. */

    @Test
    public void findByName() {
        System.out.println("findByName");
        Object name = null;
        DeveloperDAO instance = new DeveloperDAO();
        List expResult = null;
        List result = instance.findByName(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByName method, of class DeveloperDAO. */

    @Test
    public void findByEmail() {
        System.out.println("findByEmail");
        Object email = null;
        DeveloperDAO instance = new DeveloperDAO();
        List expResult = null;
        List result = instance.findByEmail(email);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByEmail method, of class DeveloperDAO. */

    @Test
    public void findByPhone() {
        System.out.println("findByPhone");
        Object phone = null;
        DeveloperDAO instance = new DeveloperDAO();
        List expResult = null;
        List result = instance.findByPhone(phone);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByPhone method, of class DeveloperDAO. */

    @Test
    public void findByContribution() {
        System.out.println("findByContribution");
        Object contribution = null;
        DeveloperDAO instance = new DeveloperDAO();
        List expResult = null;
        List result = instance.findByContribution(contribution);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByContribution method, of class DeveloperDAO. */

    @Test
    public void findAll() {
        System.out.println("findAll");
        DeveloperDAO instance = new DeveloperDAO();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findAll method, of class DeveloperDAO. */

    @Test
    public void merge() {
        System.out.println("merge");
        Developer detachedInstance = null;
        DeveloperDAO instance = new DeveloperDAO();
        Developer expResult = null;
        Developer result = instance.merge(detachedInstance);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of merge method, of class DeveloperDAO. */

    @Test
    public void attachDirty() {
        System.out.println("attachDirty");
        Developer instance_2 = null;
        DeveloperDAO instance = new DeveloperDAO();
        instance.attachDirty(instance_2);
        fail("The test case is a prototype.");
    } /* Test of attachDirty method, of class DeveloperDAO. */

    @Test
    public void attachClean() {
        System.out.println("attachClean");
        Developer instance_2 = null;
        DeveloperDAO instance = new DeveloperDAO();
        instance.attachClean(instance_2);
        fail("The test case is a prototype.");
    } /* Test of attachClean method, of class DeveloperDAO. */
    
}
