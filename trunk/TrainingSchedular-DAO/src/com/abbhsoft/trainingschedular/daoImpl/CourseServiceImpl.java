/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.daoImpl;

import com.abbhsoft.trainingschedular.dao.CourseService;
import com.abbhsoft.trainingschedular.model.Course;

/**
 *
 * @author mdshannan
 */
public class CourseServiceImpl extends GenericAbstractDAO<Course, Long> implements CourseService {

    public CourseServiceImpl() {
        super ( Course.class );
    }
}
