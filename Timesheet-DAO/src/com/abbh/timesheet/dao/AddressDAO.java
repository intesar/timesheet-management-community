/*
 * AddressDAO.java
 *
 * Created on Aug 12, 2007, 4:27:24 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.dao;

import com.abbh.timesheet.model.Address;
import java.util.Collection;

/**
 *
 * @author shannan
 */
public interface AddressDAO extends GenericDAO<Address, Long> {

    String STREET = "street";
    String ZIPCODE = "zipcode";
    String CITY = "city";
    String STATE = "state";
    String COUNTRY = "country";
    String TYPE = "type";
    /**
     * 
     * @param street 
     * @return 
     */
    Collection<Address> findByStreet(String street);

    /**
     * 
     * @param zipcode 
     * @return 
     */
    Collection<Address> findByZipcode(String zipcode);

    /**
     * 
     * @param city 
     * @return 
     */
    Collection<Address> findByCity(String city);

    /**
     * 
     * @param state 
     * @return 
     */
    Collection<Address> findByState(String state);

    /**
     * 
     * @param addressType 
     * @return 
     */
    Collection<Address> findByType(String addressType);

    /**
     * 
     * @param country 
     * @return 
     */
    Collection<Address> findByCountry(String country);
}
