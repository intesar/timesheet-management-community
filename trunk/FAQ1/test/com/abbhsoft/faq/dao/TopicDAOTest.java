/*
 * TopicDAOTest.java
 * JUnit 4.x based test
 *
 * Created on November 24, 2007, 5:48 PM
 */

package com.abbhsoft.faq.dao;

import com.abbhsoft.faq.model.Topic;
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
public class TopicDAOTest {
    
    public TopicDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
TopicDAO dao=new TopicDAO();
        Topic t1=new Topic();
        Topic t2=new Topic();
    @Before
    public void setUp() throws Exception {
        t1.setName("oracle");
        t2.setName("java");
        dao.save(t1);
        dao.save(t2);
    }

    @After
    public void tearDown() throws Exception {
        dao.delete(t1);
        dao.delete(t2);
    }

    @Test
    public void save() {
        System.out.println("save");
        Topic transientInstance = null;
        TopicDAO instance = new TopicDAO();
        instance.save(transientInstance);
        fail("The test case is a prototype.");
    } /* Test of save method, of class TopicDAO. */

    @Test
    public void delete() {
        System.out.println("delete");
        Topic persistentInstance = null;
        TopicDAO instance = new TopicDAO();
        instance.delete(persistentInstance);
        fail("The test case is a prototype.");
    } /* Test of delete method, of class TopicDAO. */

    @Test
    public void findById() {
        System.out.println("findById");
        String id = "";
        TopicDAO instance = new TopicDAO();
        Topic expResult = null;
        Topic result = instance.findById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findById method, of class TopicDAO. */

    @Test
    public void findByExample() {
        System.out.println("findByExample");
        Topic instance_2 = null;
        TopicDAO instance = new TopicDAO();
        List expResult = null;
        List result = instance.findByExample(instance_2);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByExample method, of class TopicDAO. */

    @Test
    public void findByProperty() {
        System.out.println("findByProperty");
        String propertyName = "";
        Object value = null;
        TopicDAO instance = new TopicDAO();
        List expResult = null;
        List result = instance.findByProperty(propertyName, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByProperty method, of class TopicDAO. */

    @Test
    public void findAll() {
        System.out.println("findAll");
        TopicDAO instance = new TopicDAO();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findAll method, of class TopicDAO. */

    @Test
    public void merge() {
        System.out.println("merge");
        Topic detachedInstance = null;
        TopicDAO instance = new TopicDAO();
        Topic expResult = null;
        Topic result = instance.merge(detachedInstance);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of merge method, of class TopicDAO. */

    @Test
    public void attachDirty() {
        System.out.println("attachDirty");
        Topic instance_2 = null;
        TopicDAO instance = new TopicDAO();
        instance.attachDirty(instance_2);
        fail("The test case is a prototype.");
    } /* Test of attachDirty method, of class TopicDAO. */

    @Test
    public void attachClean() {
        System.out.println("attachClean");
        Topic instance_2 = null;
        TopicDAO instance = new TopicDAO();
        instance.attachClean(instance_2);
        fail("The test case is a prototype.");
    } /* Test of attachClean method, of class TopicDAO. */
    
}
