/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service.remote;

import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.service.EventService;
import com.abbhsoft.srm.service.ServiceFactory;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class EventRemoteService {

    /*
     *  returns events between the dates
     *  maxRecords is the number of records returned
     *  
     *  delegates call to EventService.getEvents(Date startDate, Date endDate, Integer maxRecords)
     * 
     */
    public List<Event> getEvents(String startDateString, String endDateString) {

        java.util.Date dt1 = null;
        java.util.Date dt2 = null;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yy");
        try {
            dt1 = sdf.parse(startDateString);
        } catch (java.text.ParseException p) {
        // logger
        } catch (NullPointerException np) {
        //logger
        }
        try {
            dt2 = sdf.parse(endDateString);
        } catch (java.text.ParseException p) {
        // logger
        } catch (NullPointerException np) {
        //logger
        }
        if (dt1 == null && dt2 != null) {
            dt1 = dt2;
        }
        if (dt2 == null && dt1 != null) {
            dt2 = dt1;
        }
        List<Event> events = null;
        EventService service = (EventService) ServiceFactory.getInstance().getBean("eventServiceImpl");
        events = service.getEvents(dt1, dt2);
        
        return events;
    }
}
