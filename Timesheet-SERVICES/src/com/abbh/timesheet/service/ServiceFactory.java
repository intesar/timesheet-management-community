/*
 * ServiceFactory.java
 *
 * Created on Aug 19, 2007, 7:30:35 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author shannan
 */
public class ServiceFactory {

    ClassPathXmlApplicationContext factory = null;

    private ServiceFactory() {
        
        factory = new ClassPathXmlApplicationContext(new String[]{"classpath:context/applicationContext-DAO.xml", "classpath:context/applicationContext-Services.xml", "classpath:context/applicationContext-Transactions.xml"});
    }
    public static ServiceFactory instance = new ServiceFactory();

    public Object getBean(String bean) {
        return factory.getBean(bean);
    }
}
