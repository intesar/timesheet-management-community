/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.EmailGroup;
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
     *   saves a new Event
     */
    void save ( EmailGroup group1 );

}
