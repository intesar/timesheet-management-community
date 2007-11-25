/*
 * CategoryDAOTest.java
 * JUnit 4.x based test
 *
 * Created on November 24, 2007, 5:50 PM
 */

package com.abbhsoft.faq.dao;

import com.abbhsoft.faq.model.Category;
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
public class CategoryDAOTest {

    public CategoryDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    CategoryDAO dao = new CategoryDAO();
    Category c1 = new Category();
    Category c2 = new Category();

    @Before
    public void setUp() throws Exception {


        c1.setName("oracle");
        c2.setName("java1.5");
        dao.save(c1);
        dao.save(c2);
    }

    @After
    public void tearDown() throws Exception {
        dao.delete(c1);
        dao.delete(c2);
    }

    @Test
    public void save() {
        
    } /* Test of save method, of class CategoryDAO. */

    @Test
    public void delete() {
        
    } /* Test of delete method, of class CategoryDAO. */

    @Test
    public void findById() {
        System.out.println("findById");
        String id = "oracle";       
        Category result = dao.findById(id);
        assertNotNull(result);
        assertEquals(id, result.getName());
        
    } /* Test of findById method, of class CategoryDAO. */

    @Test
    public void findAll() {
        System.out.println("findAll");
        
        List result = dao.findAll();
        assertTrue(result.size() >= 2 );
        
    } /* Test of findAll method, of class CategoryDAO. */

    @Test
    public void merge() {
        System.out.println("merge");
        Category detachedInstance = null;
        CategoryDAO instance = new CategoryDAO();
        Category expResult = null;
        Category result = instance.merge(detachedInstance);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of merge method, of class CategoryDAO. */
}