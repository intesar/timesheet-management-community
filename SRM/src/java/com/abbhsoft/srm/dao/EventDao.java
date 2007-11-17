/*
 * EventDao.java
 * 
 * Created on Nov 17, 2007, 9:44:49 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import antlr.debug.Event;
import com.abbhsoft.srm.base.GenericDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface EventDao extends GenericDao < Event, Long> {
    public List<Event> findByDate(Date date);
    public List<Event> findByType(Date type);
    public List<Event> findByDescript(String description);
    public List<Event> findByStudent(String student);
    public List<Event> findByGroup(String group);
    public List<Event> findByUniversity(String university);

}
