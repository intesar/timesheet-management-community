/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.base;



import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 *
 * @author Intesar.Mohammed
 * 
 *  FinderBaseTest loads the Spring container with Readonly transactions and extends the 
 *  JUnit test class
 *  
 * Any Class which extends the FinderBaseTest will be a JUnit test class
 *  can get hold of any service defined in the FinderBaseTest
 *  Executes all the finder and able to test them
 *  The Sub Class can override onSetUpInTransaction() to create few records into the database
 *  which are all inside the non-commited transaction 
 * 
 *  
 * 
 * 
 */
public class BaseTest extends AbstractTransactionalDataSourceSpringContextTests {
    /*
     * 
     *  declare a service instance and write getters and setters spring will
     *  inject the object at runtime which is transactional (non-commited)
     */


    @Override
    protected String[] getConfigLocations() {
        
        return new String[]{"classpath:context/applicationContext-Dao.xml",
                "classpath:context/applicationContext-Dao-Extention.xml",
                "classpath:context/applicationContext-Services.xml",
                "classpath:context/applicationContext-Transactions.xml"};
    }



    public BaseTest(String testName) {
        super(testName);
    }    
    
}
