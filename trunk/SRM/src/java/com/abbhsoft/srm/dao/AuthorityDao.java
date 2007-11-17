/*
 * AuthorityDao.java
 * 
 * Created on Nov 17, 2007, 9:45:32 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.Authority;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface AuthorityDao extends GenericDao<Authority,Long>{
    
    public List<Authority> findByAuthority(String authority);
    public List<Authority> findByDescription(String description);

}
