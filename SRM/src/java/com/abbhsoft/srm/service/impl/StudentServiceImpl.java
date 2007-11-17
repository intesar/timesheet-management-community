/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.StudentDao;
import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.service.StudentService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class StudentServiceImpl implements StudentService {

    public List<Student> recentStudents() {
        Date date = new Date();
        return this.studentDao.findByLastModifiedDate(date);
    }

    public void save(Student student) {
        this.studentDao.create(student);
    }
    

    // dao injection code

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    

}
