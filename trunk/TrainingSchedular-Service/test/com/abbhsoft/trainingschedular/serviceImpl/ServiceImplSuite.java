/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author mdshannan
 */
public class ServiceImplSuite extends TestCase {
    
    public ServiceImplSuite(String testName) {
        super(testName);
    }            

    public static Test suite() {
        TestSuite suite = new TestSuite("ServiceImplSuite");
        suite.addTest(com.abbhsoft.trainingschedular.serviceImpl.InstructorServiceImplTest.suite());
        suite.addTest(com.abbhsoft.trainingschedular.serviceImpl.UserServiceImplTest.suite());
        suite.addTest(com.abbhsoft.trainingschedular.serviceImpl.CourseServiceImplTest.suite());
        suite.addTest(com.abbhsoft.trainingschedular.serviceImpl.ServiceFactoryTest.suite());
        return suite;
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
