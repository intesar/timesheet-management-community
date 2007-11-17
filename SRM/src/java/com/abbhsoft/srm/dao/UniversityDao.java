/*
 * UniversityDao.java
 * 
 * Created on Nov 17, 2007, 9:41:42 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.University;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface UniversityDao extends GenericDao < University , Long> {
    
    public List<University> findBytName (String name );
    
    
}
