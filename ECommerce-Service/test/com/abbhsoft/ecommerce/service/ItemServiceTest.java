/*
 * ItemServiceTest.java
 * JUnit based test
 *
 * Created on August 21, 2007, 12:12 AM
 */

package com.abbhsoft.ecommerce.service;

import java.util.List;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 *
 * @author shannan
 */
public class ItemServiceTest extends AbstractTransactionalDataSourceSpringContextTests {

  

    private ItemService itemService;

    public void setCompanyDAO(ItemService itemService) {
        this.itemService = itemService;
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
        deleteFromTables(new String[]{"company", "users"});
    }

    public ItemServiceTest (String testName) {
        super (testName);
    }

    public void testGetCatagories() {
        System.out.println("getCatagories");
        ItemService instance = itemService;
        List expResult = null;
        List result = instance.getCatagories();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of getCatagories method, of class ItemService. */

    public void testGetCatagoryItems() {
        System.out.println("getCatagoryItems");
        String catagory = "";
        ItemService instance = itemService;
        List expResult = null;
        List result = instance.getCatagoryItems(catagory);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of getCatagoryItems method, of class ItemService. */
    
}
