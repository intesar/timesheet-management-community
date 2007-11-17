/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.Student;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public interface StudentService {
    
    /*
     *  returns todays current events
     */
    List<Student> recentStudents () ;

    /*
     *   saves a new Event
     */
    void save ( Student student );

}
