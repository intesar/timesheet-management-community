/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.service.InstructorService;
import com.abbhsoft.trainingschedular.dao.InstructorDAO;
import com.abbhsoft.trainingschedular.model.Instructor;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class InstructorServiceImpl implements InstructorService {
    private InstructorDAO instructorDAO;

    public void setInstructorDAO(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }
    
    public void add ( Instructor newInstance ) {
        this.instructorDAO.save(newInstance);
    }
    
    public List<Instructor> getAll () {
        return (List<Instructor>) this.instructorDAO.findAll();
    }
    
    
    
}
