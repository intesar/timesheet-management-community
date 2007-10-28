/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.serviceImpl;

import com.abbhsoft.trainingschedular.service.CourseService;
import com.abbhsoft.trainingschedular.service.InstructorService;
import com.abbhsoft.trainingschedular.service.UsersService;
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
    
    public static InstructorService getInstructorService() {
        return (InstructorService) factory.getBean("instructorServiceImpl");
    }
    
    public static UsersService getUserService() {
        return (UsersService) factory.getBean("usersServiceImpl");
    }
}
