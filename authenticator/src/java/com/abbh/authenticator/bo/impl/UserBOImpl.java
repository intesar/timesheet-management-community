/*
 * UserBOImpl.java
 * 
 * Created on Jul 1, 2007, 4:27:55 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.bo.impl;

import com.abbh.authenticator.bo.UserBO;
import com.abbh.authenticator.dao.UserDAO;
import com.abbh.authenticator.entity.Users;

/**
 *
 * @author Mohammed Hamed
 */
public class UserBOImpl implements UserBO {

    public UserBOImpl() {
    }

    

    public void addUser(Users user) {
        this.getUserDAO().save(user);
    }
    
    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    private UserDAO userDAO;
}
