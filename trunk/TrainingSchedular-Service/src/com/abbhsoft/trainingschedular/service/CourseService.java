/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.service;

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
public interface CourseService {

    List<Course> getAll();

    Course getById(BigDecimal id);

    List<CourseClass> getCourseClasses(BigDecimal pk);

    List<PreRequisite> getCoursePreRequisites(BigDecimal pk);

    void setCourseDAO(CourseDAO courseDAO);
    
    void enroll ( BigDecimal pk,Users user );
    
    //void deRoll ( BigDecimal pk)
    
    Integer getTotalEnrollees (BigDecimal courseId );
    

}
