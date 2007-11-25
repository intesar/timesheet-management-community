/*
 * QuestionsDAOTest.java
 * JUnit 4.x based test
 *
 * Created on November 24, 2007, 5:50 PM
 */

package com.abbhsoft.faq.dao;

import com.abbhsoft.faq.model.Questions;
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
public class QuestionsDAOTest {
    
    public QuestionsDAOTest() {
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
        Questions transientInstance = null;
        QuestionsDAO instance = new QuestionsDAO();
        instance.save(transientInstance);
        fail("The test case is a prototype.");
    } /* Test of save method, of class QuestionsDAO. */

    @Test
    public void delete() {
        System.out.println("delete");
        Questions persistentInstance = null;
        QuestionsDAO instance = new QuestionsDAO();
        instance.delete(persistentInstance);
        fail("The test case is a prototype.");
    } /* Test of delete method, of class QuestionsDAO. */

    @Test
    public void findById() {
        System.out.println("findById");
        String id = "";
        QuestionsDAO instance = new QuestionsDAO();
        Questions expResult = null;
        Questions result = instance.findById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findById method, of class QuestionsDAO. */

    @Test
    public void findByExample() {
        System.out.println("findByExample");
        Questions instance_2 = null;
        QuestionsDAO instance = new QuestionsDAO();
        List expResult = null;
        List result = instance.findByExample(instance_2);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByExample method, of class QuestionsDAO. */

    @Test
    public void findByProperty() {
        System.out.println("findByProperty");
        String propertyName = "";
        Object value = null;
        QuestionsDAO instance = new QuestionsDAO();
        List expResult = null;
        List result = instance.findByProperty(propertyName, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByProperty method, of class QuestionsDAO. */

    @Test
    public void findByAuthor() {
        System.out.println("findByAuthor");
        Object author = null;
        QuestionsDAO instance = new QuestionsDAO();
        List expResult = null;
        List result = instance.findByAuthor(author);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByAuthor method, of class QuestionsDAO. */

    @Test
    public void findAll() {
        System.out.println("findAll");
        QuestionsDAO instance = new QuestionsDAO();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findAll method, of class QuestionsDAO. */

    @Test
    public void merge() {
        System.out.println("merge");
        Questions detachedInstance = null;
        QuestionsDAO instance = new QuestionsDAO();
        Questions expResult = null;
        Questions result = instance.merge(detachedInstance);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of merge method, of class QuestionsDAO. */

    @Test
    public void attachDirty() {
        System.out.println("attachDirty");
        Questions instance_2 = null;
        QuestionsDAO instance = new QuestionsDAO();
        instance.attachDirty(instance_2);
        fail("The test case is a prototype.");
    } /* Test of attachDirty method, of class QuestionsDAO. */

    @Test
    public void attachClean() {
        System.out.println("attachClean");
        Questions instance_2 = null;
        QuestionsDAO instance = new QuestionsDAO();
        instance.attachClean(instance_2);
        fail("The test case is a prototype.");
    } /* Test of attachClean method, of class QuestionsDAO. */
    
}
