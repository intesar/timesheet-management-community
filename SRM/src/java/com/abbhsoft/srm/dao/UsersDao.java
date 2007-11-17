/*
 * UsersDao.java
 * 
 * Created on Nov 17, 2007, 9:23:35 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.Users;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface UsersDao extends GenericDao<Users, Long> {

    public List<Users> findByFirstName (String firstName );
    public List<Users> findByLastName (String lastName );
    public List<Users> findByUsername (String userName );
    public List<Users> findByPassword(String password);
    public List<Users> findByEnabled (boolean enabled );
    
}
