/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.dao.UsersDAO;
import com.abbhsoft.trainingschedular.model.Users;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author mdshannan
 */
public class UserServiceImplTest extends TestCase {
    
    public UserServiceImplTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(UserServiceImplTest.class);
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
     * Test of setUserDAO method, of class UserServiceImpl.
     */
    public void testSetUserDAO() {
        System.out.println("setUserDAO");
        UsersDAO userDAO = null;
        UserServiceImpl instance = new UserServiceImpl();
        instance.setUserDAO(userDAO);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class UserServiceImpl.
     */
    public void testAdd() {
        System.out.println("add");
        Users user = null;
        UserServiceImpl instance = new UserServiceImpl();
        instance.add(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
