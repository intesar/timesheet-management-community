/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.StudentDao;
import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.Query;
import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.service.StudentService;
import java.util.Collection;
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

    public void update(Student student) {
        this.studentDao.update(student);
    }

    public List<Student> getAll() {
        return this.studentDao.findAll();
    }

    public List<Query> getAllConversations(Long studentId) {
        Student student = this.studentDao.read(studentId);
        return (List<Query>) student.getQueryCollection();
    }

    public void addConversation(Long studentId, Query query) {
        Student student = this.studentDao.read(studentId);
        Collection<Query> queryCollection = student.getQueryCollection();
        queryCollection.add(query);
        this.studentDao.update(student);
    }

    public List<Event> getPastEvents(Long emailGroupId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Event> getFutureEvents(Long emailGroupId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Event> getAllEvents(Long emailGroupId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Student> getRecentUpdates() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Student getStudentByIdWithDetails(Long studentId) {
        Student s = this.studentDao.read(studentId);
        s.getAddress();
        s.getEventCollection().size();
        s.getQueryCollection().size();
        return s;
    }
    
    
    // dao injection code

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    
}
