/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.Group1;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public interface EmailGroupService {
    
    /*
     *  returns todays current events
     */
    List<Group1> recentEmailGroups () ;

    /*
     *   saves a new Event
     */
    void save ( Group1 group1 );

}
