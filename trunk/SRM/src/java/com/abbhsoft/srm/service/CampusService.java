/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.Campus;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public interface CampusService {
    
    /*
     *  returns todays current events
     */
    List<Campus> recentCampuses () ;

    /*
     *   saves a new Entity
     */
    void save ( Campus campus );
    
    // udpates Entity
    
    void update ( Campus campus );
    
    // returns all the entities from the database
    
    List<Campus> findAll ();

}
