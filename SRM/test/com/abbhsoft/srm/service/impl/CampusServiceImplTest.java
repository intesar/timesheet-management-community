/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.base.BaseTest;
import com.abbhsoft.srm.dao.CampusDao;
import com.abbhsoft.srm.model.Campus;
import com.abbhsoft.srm.service.CampusService;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * @author mdshannan
 */
public class CampusServiceImplTest extends BaseTest {
    
    private CampusService campusService;
    public void setCampusService(CampusService campusService){
        this.campusService=campusService;
    }
    
    public CampusServiceImplTest(String testName) {
        super(testName);
    }

//    public static Test suite() {
//        TestSuite suite = new TestSuite(CampusServiceImplTest.class);
//        return suite;
//    }

//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//    }

    /**
     * Test of recentCampuses method, of class CampusServiceImpl.
     */
    public void testRecentCampuses() {
        System.out.println("please pass");
        Campus campus1 = new Campus();
        campus1.setName("ufm");
        Campus campus2 = new Campus();
        campus2.setName("scsu");
        campusService.save(campus1);
        campusService.save(campus2);
        List<Campus> list= campusService.getAll();//.getRecentUpdates();
        assertTrue(list.size()>=2);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of save method, of class CampusServiceImpl.
     */

}
