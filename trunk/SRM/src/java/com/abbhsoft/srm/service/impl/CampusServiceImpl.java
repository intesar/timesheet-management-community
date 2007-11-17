/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.CampusDao;
import com.abbhsoft.srm.dao.EventDao;
import com.abbhsoft.srm.model.Campus;
import com.abbhsoft.srm.service.CampusService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class CampusServiceImpl implements CampusService {

    public List<Campus> recentCampuses() {
        Date date = new Date();
        return campusDao.findByLastModifiedDate(date);
    }

    public void save ( Campus campus ) {
        campusDao.create(campus);
    }

    public void update(Campus campus) {
        campusDao.update(campus);
    }

    public List<Campus> findAll() {
        return campusDao.findAll();
    }
    // dao injection code

    private CampusDao campusDao;

    public void setCampusDao(CampusDao campusDao) {
        this.campusDao = campusDao;
    }

    


}
