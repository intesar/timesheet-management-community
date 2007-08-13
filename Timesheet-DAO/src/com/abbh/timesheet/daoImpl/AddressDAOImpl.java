/*
 * AddressDAOImpl.java
 *
 * Created on Aug 12, 2007, 4:32:08 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.daoImpl;

import com.abbh.timesheet.dao.AddressDAO;
import com.abbh.timesheet.model.Address;
import java.util.Collection;

/**
 *
 * @author shannan
 */
public class AddressDAOImpl extends GenericAbstractDAO<Address, Long> implements AddressDAO {

    public AddressDAOImpl() {
        super(Address.class);
    }

    public Collection<Address> findByStreet(String street) {
        return this.findByProperty(STREET, street);
    }

    public Collection<Address> findByZipcode(String zipcode) {
        return this.findByProperty(ZIPCODE, zipcode);
    }

    public Collection<Address> findByCity(String city) {
        return this.findByProperty ( CITY, city );
    }

    public Collection<Address> findByState(String state) {
        return this.findByProperty ( STATE, state );
    }

    public Collection<Address> findByType(String type) {
        return this.findByProperty ( TYPE, type );
    }

    public Collection<Address> findByCountry(String country) {
        return this.findByProperty ( COUNTRY, country );
    }
}
