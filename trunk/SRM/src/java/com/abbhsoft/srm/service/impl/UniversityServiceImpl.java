/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.UniversityDao;
import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.service.UniversityService;

/**
 *
 * @author mdshannan
 */
public class UniversityServiceImpl implements UniversityService {

    public void save(University u) {
        this.universityDao.create(u);
    }
    
    private UniversityDao universityDao;
    
    public void setUniversityDao ( UniversityDao universityDao ) {
        this.universityDao = universityDao;
                
    }

}
