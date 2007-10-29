/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.service.CourseService;
import com.abbhsoft.trainingschedular.dao.CourseDAO;
import com.abbhsoft.trainingschedular.model.Course;

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
    
    public Course getById( Long id ) {
        return courseDAO.findById(id);
    }

    public Integer getTotalEnrollees(Long courseId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
