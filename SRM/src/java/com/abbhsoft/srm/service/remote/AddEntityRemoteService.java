/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service.remote;

import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.service.EventService;
import com.abbhsoft.srm.service.ServiceFactory;
import com.abbhsoft.srm.service.UniversityService;

/**
 *
 * @author mdshannan
 */
public class AddEntityRemoteService {

    public String addUniversity(String name) {
        String msg = "Operation Successful!";
        UniversityService service = (UniversityService) ServiceFactory.getInstance().getBean("universityServiceImpl");
        University u = new University();
        u.setName(name);
        try {
            service.save(u);
        } catch (RuntimeException re) {
            msg = "Error Creating University!";
            throw re;
        } finally {
            return msg;
        }
    }

    public String addEvent(String type, String description, String date, String priority) {
        String msg = "Operation Successful!";
        EventService service = (EventService) ServiceFactory.getInstance().getBean("eventServiceImpl");
        Event e = new Event();
        if ( type == null || type.length() < 1 ) {
            return "Type is Required!";
        }
        e.setType(type);
        e.setDescript(description);
        e.setPriority(priority);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yy");
        try {
            java.util.Date dt = sdf.parse(date);
            e.setDate(dt);
            service.save(e);
        } catch (java.text.ParseException p) {
            msg = " Invalid Date!";
            throw p;
        } catch (RuntimeException re) {
            msg = "Error Creating Event!";
            throw re;
        } finally {
            return msg;
        }
    }
}
