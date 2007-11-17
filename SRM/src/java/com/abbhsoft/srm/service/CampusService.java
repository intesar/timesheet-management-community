/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.Campus;
import com.abbhsoft.srm.model.Event;
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
     *   saves a new Event
     */
    void save ( Campus campus );

}
