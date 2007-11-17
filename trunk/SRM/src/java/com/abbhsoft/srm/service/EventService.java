/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.Event;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public interface EventService {
    
    /*
     *  returns todays current events
     */
    List<Event> currentEvents () ;

    /*
     *   saves a new Event
     */
    void save ( Event event );
    
    // udpates Entity
    
    void update ( Event event );
    
    // returns all the entities from the database
    
    List<Event> findAll ();

}
