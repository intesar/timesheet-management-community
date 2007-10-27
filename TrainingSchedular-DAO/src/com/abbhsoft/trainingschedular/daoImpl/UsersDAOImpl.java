/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.daoImpl;

import com.abbhsoft.trainingschedular.dao.UsersDAO;
import com.abbhsoft.trainingschedular.model.Users;
import java.math.BigDecimal;

/**
 *
 * @author mdshannan
 */
public class UsersDAOImpl  extends GenericAbstractDAO<Users,BigDecimal> implements UsersDAO{
    
    public UsersDAOImpl()
    {
        super(Users.class);
    }

}
