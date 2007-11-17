/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

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
     *   saves a new Entity
     */
    void save ( Student student );
    
    // udpates Entity
    
    void update ( Student student );
    
    // returns all the entities from the database
    
    List<Student> getAll ();

}
