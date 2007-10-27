/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.dao.InstructorDAO;
import com.abbhsoft.trainingschedular.model.Instructor;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author mdshannan
 */
public class InstructorServiceImplTest extends TestCase {
    
    public InstructorServiceImplTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(InstructorServiceImplTest.class);
        return suite;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of setInstructorDAO method, of class InstructorServiceImpl.
     */
    public void testSetInstructorDAO() {
        System.out.println("setInstructorDAO");
        InstructorDAO instructorDAO = null;
        InstructorServiceImpl instance = new InstructorServiceImpl();
        instance.setInstructorDAO(instructorDAO);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class InstructorServiceImpl.
     */
    public void testAdd() {
        System.out.println("add");
        Instructor newInstance = null;
        InstructorServiceImpl instance = new InstructorServiceImpl();
        instance.add(newInstance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class InstructorServiceImpl.
     */
    public void testGetAll() {
        System.out.println("getAll");
        InstructorServiceImpl instance = new InstructorServiceImpl();
        List<Instructor> expResult = null;
        List<Instructor> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
