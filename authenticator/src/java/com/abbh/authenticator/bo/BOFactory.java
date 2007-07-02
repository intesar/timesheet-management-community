/*
 * BOFactory.java
 *
 * Created on Jul 1, 2007, 7:27:41 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.bo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author intesar
 *
 *  Spring bean factory
 *  loads Spring IOC Container and creates beans
 */
public class BOFactory {
    private static final BOFactory instance = new BOFactory();
    private static BeanFactory factory;
    private BOFactory() {
        Resource resource = new ClassPathResource("context/applicationContext.xml");
        factory = new XmlBeanFactory(resource);
    }
    
    public final static BOFactory getInstance() {
        return instance;
    }
    
    /**
     *
     * @param beanName  (Spring bean name)
     * @return Object (Spring bean needs to be type cast)
     *
     *
     */
    public final Object getBean( String beanName) {
        System.out.println ( factory);
        return factory.getBean(beanName);
    }
}
