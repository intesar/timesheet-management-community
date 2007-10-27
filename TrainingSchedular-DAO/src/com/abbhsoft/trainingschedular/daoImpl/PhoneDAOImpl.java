/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.daoImpl;

import com.abbhsoft.trainingschedular.dao.PhoneDAO;
import java.math.BigDecimal;

/**
 *
 * @author mdshannanbli
 */
public class PhoneDAOImpl extends GenericAbstractDAO<PhoneDAO,BigDecimal> implements PhoneDAO{
    public PhoneDAOImpl()
    {
        super(PhoneDAO.class);
    }

}
