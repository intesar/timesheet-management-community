/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.service;

import com.abbhsoft.trainingschedular.model.Instructor;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public interface InstructorService {

    void add(Instructor newInstance);

    List<Instructor> getAll();

}
