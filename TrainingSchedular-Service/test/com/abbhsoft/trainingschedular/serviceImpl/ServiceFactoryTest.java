/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.service.CourseService;
import com.abbhsoft.trainingschedular.service.InstructorService;
import com.abbhsoft.trainingschedular.service.UsersService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author mdshannan
 */
public class ServiceFactoryTest extends TestCase {
    
    public ServiceFactoryTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ServiceFactoryTest.class);
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
     * Test of getCourseService method, of class ServiceFactory.
     */
    public void testGetCourseService() {
        System.out.println("getCourseService");
        CourseService expResult = null;
        CourseService result = ServiceFactory.getCourseService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstructorService method, of class ServiceFactory.
     */
    public void testGetInstructorService() {
        System.out.println("getInstructorService");
        InstructorService expResult = null;
        InstructorService result = ServiceFactory.getInstructorService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserService method, of class ServiceFactory.
     */
    public void testGetUserService() {
        System.out.println("getUserService");
        UsersService expResult = null;
        UsersService result = ServiceFactory.getUserService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
