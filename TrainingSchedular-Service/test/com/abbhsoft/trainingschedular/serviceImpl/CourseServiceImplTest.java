/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.service.ServiceFactory;
import com.abbhsoft.trainingschedular.dao.CourseDAO;
import com.abbhsoft.trainingschedular.model.Course;

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

        jdbcTemplate.execute("insert into course (iid, name, description) values (6, 'test', 'test')");
        
    }

    @Override
    protected void onTearDownAfterTransaction() throws Exception {

        super.onTearDownAfterTransaction();
        //deleteFromTables(new String[]{"course"});ct
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

   

}
