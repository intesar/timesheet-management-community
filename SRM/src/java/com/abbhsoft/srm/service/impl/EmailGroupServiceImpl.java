/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.Group1Dao;
import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.Group1;
import com.abbhsoft.srm.service.EmailGroupService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class EmailGroupServiceImpl implements EmailGroupService {

    public List<Group1> recentEmailGroups() {
        Date date = new Date();
        return group1Dao.findByLastModifiedDate(date);
    }

    public void save ( Group1 group ) {
        group1Dao.create(group);
    }

    // dao injection code

    private Group1Dao group1Dao;

    public void setGroup1Dao(Group1Dao group1Dao) {
        this.group1Dao = group1Dao;
    }
    
}
