/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.CampusDao;
import com.abbhsoft.srm.model.Campus;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author mdshannan
 */
public class CampusServiceImplTest extends TestCase {
    
    public CampusServiceImplTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CampusServiceImplTest.class);
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
     * Test of recentCampuses method, of class CampusServiceImpl.
     */
    public void testRecentCampuses() {
        System.out.println("recentCampuses");
        CampusServiceImpl instance = new CampusServiceImpl();
        List<Campus> expResult = null;
        List<Campus> result = instance.recentCampuses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class CampusServiceImpl.
     */
    public void testSave() {
        System.out.println("save");
        Campus campus = null;
        CampusServiceImpl instance = new CampusServiceImpl();
        instance.save(campus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCampusDao method, of class CampusServiceImpl.
     */
    public void testSetCampusDao() {
        System.out.println("setCampusDao");
        CampusDao campusDao = null;
        CampusServiceImpl instance = new CampusServiceImpl();
        instance.setCampusDao(campusDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
