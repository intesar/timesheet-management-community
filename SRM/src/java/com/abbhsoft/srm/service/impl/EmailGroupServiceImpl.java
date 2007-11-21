/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.EmailGroupDao;
import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.EmailGroup;
import com.abbhsoft.srm.service.EmailGroupService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class EmailGroupServiceImpl implements EmailGroupService {

    public List<EmailGroup> recentEmailGroups() {
        Date date = new Date();
        return emailGroupDao.findByLastModifiedDate(date);
    }

    public void save ( EmailGroup group ) {
        emailGroupDao.create(group);
    }

    public void update(EmailGroup emailGroup) {
        emailGroupDao.update(emailGroup);
    }

    public List<EmailGroup> getAll() {
        return emailGroupDao.findAll();
    }
    
    public List<Event> getPastEvents(Long emailGroupId) {
        EmailGroup emailGroup = this.emailGroupDao.read(emailGroupId);
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
    public List<Event> getFutureEvents(Long emailGroupId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Event> getAllEvents(Long emailGroupId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<EmailGroup> getRecentUpdates() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // dao injection code

    private EmailGroupDao emailGroupDao;

    public void setEmailGroupDao(EmailGroupDao emailGroupDao) {
        this.emailGroupDao = emailGroupDao;
    }

    

    
    
    
}