/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.EmailGroupDao;
import com.abbhsoft.srm.model.EmailGroup;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author mdshannan
 */
public class EmailGroupServiceImplTest extends TestCase {
    
    public EmailGroupServiceImplTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(EmailGroupServiceImplTest.class);
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
     * Test of recentEmailGroups method, of class EmailGroupServiceImpl.
     */
    public void testRecentEmailGroups() {
        System.out.println("recentEmailGroups");
        EmailGroupServiceImpl instance = new EmailGroupServiceImpl();
        List<EmailGroup> expResult = null;
        List<EmailGroup> result = instance.recentEmailGroups();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class EmailGroupServiceImpl.
     */
    public void testSave() {
        System.out.println("save");
        EmailGroup group = null;
        EmailGroupServiceImpl instance = new EmailGroupServiceImpl();
        instance.save(group);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroup1Dao method, of class EmailGroupServiceImpl.
     */
    public void testSetGroup1Dao() {
        System.out.println("setGroup1Dao");
        EmailGroupDao group1Dao = null;
        EmailGroupServiceImpl instance = new EmailGroupServiceImpl();
        instance.setGroup1Dao(group1Dao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
