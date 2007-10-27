/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.daoImpl;

import com.abbhsoft.trainingschedular.dao.CourseClassDAO;
import com.abbhsoft.trainingschedular.model.CourseClass;
import java.math.BigDecimal;

/**
 *
 * @author mdshannan
 */
public class CourseClassDAOImpl extends GenericAbstractDAO<CourseClass, BigDecimal> implements CourseClassDAO {
    public CourseClassDAOImpl() {
        super (CourseClass.class );
    }

}
