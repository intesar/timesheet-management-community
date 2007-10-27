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

        jdbcTemplate.execute("insert into catagory (id, name, is_enabled ) values ( 1, 'DINNER', TRUE)");
        jdbcTemplate.execute("insert into catagory (id, name, is_enabled ) values ( 2, 'LUNCH', TRUE)");
        jdbcTemplate.execute("insert into catagory (id, name, is_enabled ) values ( 3, 'BEVERAGES', TRUE)");
        jdbcTemplate.execute("insert into catagory (id, name, is_enabled ) values ( 4, 'DESERTS', TRUE)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (1, 'CHILLY CHICKEN', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (2, 'TANDOORI CHICKEN', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (3, 'BUTTER CHICKEN', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (4, 'BEEF KABAB', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (5, 'LAMB BIRYANI', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (6, 'NAAN', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (7, 'LASSI', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 1,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 2,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 3,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 4,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 5,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 6,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 7,2)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 2,2)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 6,2)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 7,3)");
        
    }

    @Override
    protected void onTearDownAfterTransaction() throws Exception {

        super.onTearDownAfterTransaction();
        deleteFromTables(new String[]{"item_catagory", "item", "catagory"});
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
        CourseServiceImpl instance = new CourseServiceImpl();
        List<Course> expResult = null;
        List<Course> result = instance.getAll();
        if ( result.size() != 3 ) 
            fail (" failed ");
        
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
