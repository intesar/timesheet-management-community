/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.service;

import com.abbhsoft.trainingschedular.service.CourseService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mdshannan
 */
public class ServiceFactory {
    private static ApplicationContext context = null;
    private static BeanFactory factory = null;
    static {
        context = new ClassPathXmlApplicationContext(
        new String[] {"classpath:context/applicationContext-DAO.xml", "classpath:context/applicationContext-Services.xml", "classpath:context/applicationContext-Transactions.xml"});
        factory = (BeanFactory) context;
    }
    
    public static CourseService getCourseService() {
        context = new ClassPathXmlApplicationContext(
        new String[] {"classpath:context/applicationContext-DAO.xml", "classpath:context/applicationContext-Services.xml", "classpath:context/applicationContext-Transactions.xml"});
        factory = (BeanFactory) context;
        return (CourseService) factory.getBean("courseServiceImpl");
    }
    
   
}
