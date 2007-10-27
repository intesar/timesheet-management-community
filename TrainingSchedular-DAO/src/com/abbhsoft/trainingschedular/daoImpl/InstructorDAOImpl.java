/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.daoImpl;

import com.abbhsoft.trainingschedular.dao.InstructorDAO;
import com.abbhsoft.trainingschedular.model.Instructor;
import java.math.BigDecimal;

/**
 *
 * @author mdshannan
 */
public class InstructorDAOImpl extends GenericAbstractDAO<Instructor, BigDecimal> implements InstructorDAO {
    public InstructorDAOImpl() {
        super (Instructor.class);
    }

}
