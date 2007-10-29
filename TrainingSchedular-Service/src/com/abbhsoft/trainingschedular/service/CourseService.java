/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.service;

import com.abbhsoft.trainingschedular.dao.CourseDAO;
import com.abbhsoft.trainingschedular.model.Course;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public interface CourseService {
    
   void addCourse ( Course course) ;

    List<Course> getAll();

    Course getById(Long id);

    

    void setCourseDAO(CourseDAO courseDAO);
    
    
    
    
    Integer getTotalEnrollees (Long courseId );
    

}
