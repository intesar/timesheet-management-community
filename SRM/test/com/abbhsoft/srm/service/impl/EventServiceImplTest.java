/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.base.BaseTest;
import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.service.EventService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class EventServiceImplTest extends BaseTest {

    public EventServiceImplTest(String testName) {
        super(testName);
    }
    private EventService eventService;

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }


    /**
     * Test of currentEvents method, of class EventServiceImpl.
     */
    public void testCurrentEvents() {
        System.out.println("currentEvents");
        Date date = new Date();

        Event event1 = new Event(date, "Call");
        
        Event event2 = new Event(date, "Email");
        
        Event event3 = new Event(date, "Message");
        
        eventService.save(event1);
        eventService.save(event2);
        eventService.save(event3);

        List<Event> result = eventService.currentEvents();
        assertTrue(result.size() >= 3);

    }
}

   
