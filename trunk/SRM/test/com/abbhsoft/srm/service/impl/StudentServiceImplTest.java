/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.StudentDao;
import com.abbhsoft.srm.model.Student;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author mdshannan
 */
public class StudentServiceImplTest extends TestCase {
    
    public StudentServiceImplTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(StudentServiceImplTest.class);
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
     * Test of recentStudents method, of class StudentServiceImpl.
     */
    public void testRecentStudents() {
        System.out.println("recentStudents");
        StudentServiceImpl instance = new StudentServiceImpl();
        List<Student> expResult = null;
        List<Student> result = instance.recentStudents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class StudentServiceImpl.
     */
    public void testSave() {
        System.out.println("save");
        Student student = null;
        StudentServiceImpl instance = new StudentServiceImpl();
        instance.save(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStudentDao method, of class StudentServiceImpl.
     */
    public void testSetStudentDao() {
        System.out.println("setStudentDao");
        StudentDao studentDao = null;
        StudentServiceImpl instance = new StudentServiceImpl();
        instance.setStudentDao(studentDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
