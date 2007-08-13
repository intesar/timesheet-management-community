/*
 * Main.java
 * 
 * Created on Aug 12, 2007, 10:04:28 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.serviceImpl;

import com.abbh.timesheet.model.Address;
import com.abbh.timesheet.service.AddressService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author shannan
 */
public class Main {

    public Main() {
    }
    
    public static void main (String[] args ) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext( new String[] {"classpath:context/applicationContext-DAO.xml", "classpath:context/applicationContext-Services.xml", "classpath:context/applicationContext-Transactions.xml" });  
        AddressService a = (AddressService) factory.getBean("addressServiceImpl");
        Address address = new Address();
        address.setCity("CITY");
        address.setCountry("COUNTRY");
        address.setId(4L);
        address.setState("STATE");
        address.setStreet("STREET");
        address.setType("TYPE");
        a.save(address);
    }

}
