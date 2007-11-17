/*
 * AddressDao.java
 * 
 * Created on Nov 17, 2007, 9:46:09 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.Address;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface AddressDao extends GenericDao<Address,Long>{
    public List<Address>findByType(String type);
    public List<Address>findByStreet(String street);
    public List<Address>findByCity(String city);
    public List<Address>findByState(String state);
    public List<Address>findByZipcode(String zipcode);
    public List<Address>findByCountry(String country);

}
