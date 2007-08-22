/*
 * ItemDAOTest.java
 * JUnit based test
 *
 * Created on August 21, 2007, 12:19 AM
 */

package com.abbhsoft.ecommerce.dao;

import com.abbhsoft.ecommerce.model.Catagory;
import com.abbhsoft.ecommerce.model.Item;
import java.util.Collection;
import java.util.List;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 *
 * @author shannan
 */
public class CatagoryDAOTest  extends AbstractTransactionalDataSourceSpringContextTests {

  

    private CatagoryDAO catagoryDAO;

    public void setCatagoryDAO(CatagoryDAO catagoryDAO) {
        this.catagoryDAO = catagoryDAO;
    }

   

  
    @Override
    protected String[] getConfigLocations() {
        return new String[]{"classpath:context/applicationContext-DAO.xml"};
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {

//        jdbcTemplate.execute("insert into users ( id, email ) values ( 1, 'test')");
//        jdbcTemplate.execute("insert into company (id, name, type, city, owner ) values ( 1, 'name1', 'type1', 'chicago', 'test')");
            }

    @Override
    protected void onTearDownAfterTransaction() throws Exception {

        super.onTearDownAfterTransaction();
        deleteFromTables(new String[]{"_tem", "catagory", "catagory_item"});
    }

    
    public CatagoryDAOTest (String testName) {
        super (testName);
    }

 

    public void testFindAllCatagories() {
        System.out.println("findAllCatagories");
        Long catagory = 0L;
        List expResult = null;
        Collection<Catagory> result = catagoryDAO.findAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findAllCatagories method, of class ItemDAO. */

    public void testFindCatagoryItems() {
        System.out.println("findCatagoryItems");
        Long catagory = 0L;
        
        List expResult = null;
        List<Item> result = catagoryDAO.findCatagoryItems(catagory);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findCatagoryItems method, of class ItemDAO. */
    
}
