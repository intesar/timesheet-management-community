/*
 * BOFactoryTest.java
 * JUnit 4.x based test
 *
 * Created on July 1, 2007, 7:39 PM
 */

package com.abbh.authenticator.bo;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author intesar
 */
public class BOFactoryTest {
    static BOFactory factory;
    public BOFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        factory = BOFactory.getInstance();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    //@Test
    public void getInstance() {
        System.out.println("getInstance");
        BOFactory result = BOFactory.getInstance();
        assertNotNull(result);
        
    }
    
   @Test
    public void getBean() {
        System.out.println("getBean");
        String beanName = "UserBO";
        UserBO result = (UserBO) factory.getBean(beanName);
        assertNotNull(result);
        
    }
    
}
