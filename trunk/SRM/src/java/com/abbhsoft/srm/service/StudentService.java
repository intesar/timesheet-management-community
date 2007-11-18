/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.Query;
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
    
    // returns all student conversations
    
    List<Query> getAllConversations ( Long studentId );
    
    // adds new converstaion
    void addConversation ( Long studentId, Query query);
    
    // returns past events
    
    List<Event> getPastEvents(Long emailGroupId );
    
    // returns future events
    
    List<Event> getFutureEvents ( Long emailGroupId );
    
    // returns all events for the Entity
    List<Event> getAllEvents ( Long emailGroupId );
    
    // recent entities
    
    List<Student> getRecentUpdates();
    
    // searches database
    
    List search ( String text );

}
