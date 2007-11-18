/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.EventDao;
import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.service.EventService;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class EventServiceImpl implements EventService {

    public List<Event> currentEvents() {
        Date date = new Date();
        return eventDao.findByDate(date);
    }

    public void save ( Event event ) {
        eventDao.create(event);
    }
    
    public void update(Event event) {
        this.eventDao.update(event);
    }

    public List<Event> getAll() {
        return this.eventDao.findAll();
    }

    public List<Event> getAllFutrueEvents() {
        Date date = null;
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+1);
        date = calendar.getTime();
        return this.eventDao.findByDate(date);
    }
    
  

    public List<Event> getRecentUpdates() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // dao injection code

    private EventDao eventDao;

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

}