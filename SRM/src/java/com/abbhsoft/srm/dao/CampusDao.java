/*
 * CampusDao.java
 * 
 * Created on Nov 17, 2007, 9:45:07 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.Campus;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface CampusDao extends GenericDao <Campus, Long>{

    public List<Campus> findByName(String name);
    
}
