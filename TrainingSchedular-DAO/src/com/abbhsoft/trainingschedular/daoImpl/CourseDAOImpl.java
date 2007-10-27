/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.daoImpl;

import com.abbhsoft.trainingschedular.dao.CourseDAO;
import com.abbhsoft.trainingschedular.model.Course;
import java.math.BigDecimal;

/**
 *
 * @author mdshannan
 */
public class CourseDAOImpl extends GenericAbstractDAO<Course, BigDecimal> implements CourseDAO {
    public CourseDAOImpl() {
        super ( Course.class );
    }
}
