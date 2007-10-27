/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.service.UsersService;
import com.abbhsoft.trainingschedular.dao.UsersDAO;
import com.abbhsoft.trainingschedular.model.Users;

/**
 *
 * @author mdshannan
 */
public class UserServiceImpl implements UsersService {
    private UsersDAO userDAO;

    public void setUserDAO(UsersDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public void add ( Users user ) {
        userDAO.save(user);
    }
}

