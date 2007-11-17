/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mdshannan
 */
public class ServiceFactory {

    BeanFactory factory = null;

    private ServiceFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"classpath:context/applicationContext-Dao.xml",
                "classpath:context/applicationContext-Dao-Extention.xml",
                "classpath:context/applicationContext-Services.xml",
                "classpath:context/applicationContext-Transactions.xml"});

        // of course, an ApplicationContext is just a BeanFactory
        factory = (BeanFactory) context;
    }

    /*
     *  bean names : 
     *       eventServiceImpl, campusServiceImpl, emailGroupServiceImpl, studentServiceImpl
     *
     *
     */
    public Object getBean (String bean ) {
        return factory.getBean(bean);
    }

    public static final ServiceFactory instance = new ServiceFactory();

    public static final ServiceFactory getInstance() {
        return instance;
    }
}
