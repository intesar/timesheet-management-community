/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;


import com.abbhsoft.srm.base.BaseTest;
import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.service.StudentService;
import java.util.List;
/**
 *
 * @author mdshannan
 */
public class StudentServiceImplTest extends BaseTest{
    
    public StudentServiceImplTest(String testName){
        super(testName);
    }
    
    private StudentService studentService;
    
    public void setStudentService(StudentService studentService){
        this.studentService = studentService;
    }
    
    public void testCurrentStudents(){
        System.out.println("Current Students");
        
        Student student1 = new Student(11L, "Amer");
        Student student2 = new Student(22L, "Saddam");
        Student student3 = new Student(33L, "Ismail");
        
        studentService.save(student1);
        studentService.save(student2);
        studentService.save(student3);
        
        List<Student> currentStudents = studentService.getAll();
        assertTrue(currentStudents.size() >= 3);
    }
}