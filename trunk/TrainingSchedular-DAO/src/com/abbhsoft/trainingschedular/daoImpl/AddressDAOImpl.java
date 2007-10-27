/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.daoImpl;

import com.abbhsoft.trainingschedular.dao.AddressDAO;
import com.abbhsoft.trainingschedular.model.Address;
import java.math.BigDecimal;

/**
 *
 * @author mdshannan
 */
public class AddressDAOImpl extends GenericAbstractDAO<Address, BigDecimal> implements AddressDAO  {

   public AddressDAOImpl() {
       super ( Address.class );
   }
} 
