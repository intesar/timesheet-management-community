/*
 * AuthoritiesDao.java
 * 
 * Created on Nov 17, 2007, 9:45:52 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.Authorities;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface AuthoritiesDao extends GenericDao<Authorities, Long >{
    
    public List<Authorities>findByAuthority(String authority);
    public List<Authorities>findByUsername(String userName);

}
