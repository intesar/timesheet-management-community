/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.EmailGroup;
import com.abbhsoft.srm.model.Event;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public interface EmailGroupService {
    
    /*
     *  returns todays current events
     */
    List<EmailGroup> recentEmailGroups () ;

    /*
     *   saves a new Entity
     */
    void save ( EmailGroup emailGroup );
    
    // udpates Entity
    
    void update ( EmailGroup emailGroup );
    
    // returns all the entities from the database
    
    List<EmailGroup> getAll ();
    
    // returns past events
    
    List<Event> getPastEvents(Long emailGroupId );
    
    // returns future events
    
    List<Event> getFutureEvents ( Long emailGroupId );
    
    // returns all events for the Entity
    List<Event> getAllEvents ( Long emailGroupId );

    // recent entities
    List<EmailGroup> getRecentUpdates();
}
