/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.dao.CourseDAO;
import com.abbhsoft.trainingschedular.model.Course;
import com.abbhsoft.trainingschedular.model.CourseClass;
import com.abbhsoft.trainingschedular.model.PreRequisite;
import com.abbhsoft.trainingschedular.model.Users;
import com.abbhsoft.trainingschedular.service.CourseService;
import java.math.BigDecimal;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 *
 * @author mdshannan
 */
public class CourseServiceImplTest  extends AbstractTransactionalDataSourceSpringContextTests {

    private CourseService courseService;

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    

    @Override
    protected String[] getConfigLocations() {
        return new String[]{"classpath:context/applicationContext-DAO.xml", 
                             "classpath:context/applicationContext-Services.xml",
                             "classpath:context/applicationContext-Transactions.xml"};
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {

        jdbcTemplate.execute("insert into course (iid, name, description) values (3, 'test', 'test')");
        
    }

    @Override
    protected void onTearDownAfterTransaction() throws Exception {

        super.onTearDownAfterTransaction();
        deleteFromTables(new String[]{"course"});
    }

    
    public CourseServiceImplTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CourseServiceImplTest.class);
        return suite;
    }

    

    

    /**
     * Test of getAll method, of class CourseServiceImpl.
     */
    public void testGetAll() {
        System.out.println("getAll");
        CourseService instance = ServiceFactory.getCourseService();
        List list = instance.getAll();
        if ( list.size() != 1 ) {
            fail (" failed ");
        }
    }

    /**
     * Test of getById method, of class CourseServiceImpl.
     */
    public void testGetById() {
        System.out.println("getById");
        BigDecimal id = null;
        CourseServiceImpl instance = new CourseServiceImpl();
        Course expResult = null;
        Course result = instance.getById(id);
        
        
    }

    /**
     * Test of getCourseClasses method, of class CourseServiceImpl.
     */
    public void testGetCourseClasses() {
        System.out.println("getCourseClasses");
        BigDecimal pk = null;
        CourseServiceImpl instance = new CourseServiceImpl();
        List<CourseClass> expResult = null;
        List<CourseClass> result = instance.getCourseClasses(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoursePreRequisites method, of class CourseServiceImpl.
     */
    public void testGetCoursePreRequisites() {
        System.out.println("getCoursePreRequisites");
        BigDecimal pk = null;
        CourseServiceImpl instance = new CourseServiceImpl();
        List<PreRequisite> expResult = null;
        List<PreRequisite> result = instance.getCoursePreRequisites(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enroll method, of class CourseServiceImpl.
     */
    public void testEnroll() {
        System.out.println("enroll");
        BigDecimal pk = null;
        Users user = null;
        CourseServiceImpl instance = new CourseServiceImpl();
        instance.enroll(pk, user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalEnrollees method, of class CourseServiceImpl.
     */
    public void testGetTotalEnrollees() {
        System.out.println("getTotalEnrollees");
        BigDecimal courseId = null;
        CourseServiceImpl instance = new CourseServiceImpl();
        Integer expResult = null;
        Integer result = instance.getTotalEnrollees(courseId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
