/*
 * AnswersDAOTest.java
 * JUnit 4.x based test
 *
 * Created on November 24, 2007, 5:50 PM
 */

package com.abbhsoft.faq.dao;

import com.abbhsoft.faq.model.Answers;
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
public class AnswersDAOTest {
    
    public AnswersDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        AnswersDAO dao = new AnswersDAO();
        Answers a1 = new Answers();
        
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
        System.out.println("save");
        Answers transientInstance = null;
        AnswersDAO instance = new AnswersDAO();
        AnswersDAO in = new AnswersDAO();
        
        instance.save(transientInstance);
        fail("The test case is a prototype.");
    } /* Test of save method, of class AnswersDAO. */

    @Test
    public void delete() {
        System.out.println("delete");
        Answers persistentInstance = null;
        AnswersDAO instance = new AnswersDAO();
        instance.delete(persistentInstance);
        fail("The test case is a prototype.");
    } /* Test of delete method, of class AnswersDAO. */

    @Test
    public void findById() {
        System.out.println("findById");
        Integer id = null;
        AnswersDAO instance = new AnswersDAO();
        Answers expResult = null;
        Answers result = instance.findById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findById method, of class AnswersDAO. */

    @Test
    public void findByExample() {
        System.out.println("findByExample");
        Answers instance_2 = null;
        AnswersDAO instance = new AnswersDAO();
        List expResult = null;
        List result = instance.findByExample(instance_2);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByExample method, of class AnswersDAO. */

    @Test
    public void findByProperty() {
        System.out.println("findByProperty");
        String propertyName = "";
        Object value = null;
        AnswersDAO instance = new AnswersDAO();
        List expResult = null;
        List result = instance.findByProperty(propertyName, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByProperty method, of class AnswersDAO. */

    @Test
    public void findByAnswer() {
        System.out.println("findByAnswer");
        Object answer = null;
        AnswersDAO instance = new AnswersDAO();
        List expResult = null;
        List result = instance.findByAnswer(answer);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByAnswer method, of class AnswersDAO. */

    @Test
    public void findByAuthor() {
        System.out.println("findByAuthor");
        Object author = null;
        AnswersDAO instance = new AnswersDAO();
        List expResult = null;
        List result = instance.findByAuthor(author);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByAuthor method, of class AnswersDAO. */

    @Test
    public void findByIsAppropriate() {
        System.out.println("findByIsAppropriate");
        Object isAppropriate = null;
        AnswersDAO instance = new AnswersDAO();
        List expResult = null;
        List result = instance.findByIsAppropriate(isAppropriate);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByIsAppropriate method, of class AnswersDAO. */

    @Test
    public void findByIsAppropriateBy() {
        System.out.println("findByIsAppropriateBy");
        Object isAppropriateBy = null;
        AnswersDAO instance = new AnswersDAO();
        List expResult = null;
        List result = instance.findByIsAppropriateBy(isAppropriateBy);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByIsAppropriateBy method, of class AnswersDAO. */

    @Test
    public void findAll() {
        System.out.println("findAll");
        AnswersDAO instance = new AnswersDAO();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findAll method, of class AnswersDAO. */

    @Test
    public void merge() {
        System.out.println("merge");
        Answers detachedInstance = null;
        AnswersDAO instance = new AnswersDAO();
        Answers expResult = null;
        Answers result = instance.merge(detachedInstance);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of merge method, of class AnswersDAO. */

    @Test
    public void attachDirty() {
        System.out.println("attachDirty");
        Answers instance_2 = null;
        AnswersDAO instance = new AnswersDAO();
        instance.attachDirty(instance_2);
        fail("The test case is a prototype.");
    } /* Test of attachDirty method, of class AnswersDAO. */

    @Test
    public void attachClean() {
        System.out.println("attachClean");
        Answers instance_2 = null;
        AnswersDAO instance = new AnswersDAO();
        instance.attachClean(instance_2);
        fail("The test case is a prototype.");
    } /* Test of attachClean method, of class AnswersDAO. */
    
}
