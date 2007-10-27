/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.service.CourseService;
import com.abbhsoft.trainingschedular.dao.CourseDAO;
import com.abbhsoft.trainingschedular.model.Course;
import com.abbhsoft.trainingschedular.model.CourseClass;
import com.abbhsoft.trainingschedular.model.PreRequisite;
import com.abbhsoft.trainingschedular.model.Users;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO;

    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }
    
    public void addCourse( Course course ) {
        this.courseDAO.save(course);
    }
    public List<Course> getAll () {
        return (List<Course>) courseDAO.findAll();
    }
    
    public Course getById( BigDecimal id ) {
        return courseDAO.findById(id);
    }

    public List<CourseClass> getCourseClasses( BigDecimal pk ) {
        Course course = courseDAO.findById(pk);
        return (List<CourseClass>) course.getCourseClassCollection();
    }
    
    public List<PreRequisite> getCoursePreRequisites ( BigDecimal pk ) {
        Course course = courseDAO.findById(pk);
        return (List<PreRequisite>) course.getPreRequisiteCollection();
    }

    public void enroll(BigDecimal pk, Users user) {
        this.courseDAO.findById(pk).getUserCollection().add(user);
    }

    public Integer getTotalEnrollees(BigDecimal courseId) {
        return this.courseDAO.findById(courseId).getUserCollection().size();
    }

  
    
}
