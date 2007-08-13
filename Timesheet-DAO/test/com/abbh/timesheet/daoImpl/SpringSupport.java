/*
 * SpringSupport.java
 *
 * Created on Aug 12, 2007, 4:43:14 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.daoImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author shannan
 */
public class SpringSupport {
    private static ClassPathXmlApplicationContext factory = null;
    static {   
        factory = new ClassPathXmlApplicationContext( new String[] {"classpath:context/applicationContext-DAO.xml" });  
    }
    
    public static Object getBean( String bean ) {
        return factory.getBean(bean);
    }
}
