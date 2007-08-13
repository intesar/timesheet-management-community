/*
 * AddressServiceImpl.java
 * 
 * Created on Aug 12, 2007, 9:37:49 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.serviceImpl;

import com.abbh.timesheet.dao.AddressDAO;
import com.abbh.timesheet.service.AddressService;
import com.abbh.timesheet.model.Address;


/**
 *
 * @author shannan
 */
public class AddressServiceImpl implements AddressService {

    public AddressServiceImpl() {
    }

    public void save(Address address) {
       this.addressDAO.save(address);
    }

    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    private AddressDAO addressDAO;
}
