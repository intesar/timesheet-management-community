/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.EventDao;
import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.service.EventService;
import java.util.Date;
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

    // dao injection code

    private EventDao eventDao;

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }


}
