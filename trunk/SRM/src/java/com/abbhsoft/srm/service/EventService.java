/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.Event;
import java.util.Date;
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
    
    List<Event> getAll ();
    
    // returns future events
    
    List<Event> getAllFutrueEvents ();
    
    // recent entities
    
    List<Event> getRecentUpdates();
    
    /*
     *  returns events between the dates
     *  maxRecords is the number of records returned
     *  maxRecords default is 20
     *  default startDate is current date
     *  default endDate is startDate
     * 
     */
    
    public List<Event> getEvents ( Date startDate, Date endDate );

}
