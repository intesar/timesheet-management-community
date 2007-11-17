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
        return group1Dao.findByLastModifiedDate(date);
    }

    public void save ( EmailGroup group ) {
        group1Dao.create(group);
    }

    // dao injection code

    private EmailGroupDao group1Dao;

    public void setGroup1Dao(EmailGroupDao group1Dao) {
        this.group1Dao = group1Dao;
    }
    
}
