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
public class CatagoryServiceTest extends AbstractTransactionalDataSourceSpringContextTests {

    private CatagoryService catagoryService;

    public void setCatagoryService(CatagoryService catagoryService) {
        this.catagoryService = catagoryService;
    }

    

    @Override
    protected String[] getConfigLocations() {
        return new String[]{"classpath:context/applicationContext-DAO.xml", 
                             "classpath:context/applicationContext-Services.xml",
                             "classpath:context/applicationContext-Transactions.xml"};
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {

        jdbcTemplate.execute("insert into catagory (id, name, is_enabled ) values ( 1, 'DINNER', TRUE)");
        jdbcTemplate.execute("insert into catagory (id, name, is_enabled ) values ( 2, 'LUNCH', TRUE)");
        jdbcTemplate.execute("insert into catagory (id, name, is_enabled ) values ( 3, 'BEVERAGES', TRUE)");
        jdbcTemplate.execute("insert into catagory (id, name, is_enabled ) values ( 4, 'DESERTS', TRUE)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (1, 'CHILLY CHICKEN', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (2, 'TANDOORI CHICKEN', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (3, 'BUTTER CHICKEN', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (4, 'BEEF KABAB', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (5, 'LAMB BIRYANI', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (6, 'NAAN', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM ( ID, NAME, DESCRIPTION, PRICE, TAX ) VALUES (7, 'LASSI', 'CHIKEN WITH CHILLY GRAVY', 5.99, .75)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 1,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 2,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 3,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 4,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 5,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 6,1)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 7,2)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 2,2)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 6,2)");
        jdbcTemplate.execute("INSERT INTO ITEM_CATAGORY ( ITEM_ID, CATAGORY_ID ) VALUES ( 7,3)");
        
    }

    @Override
    protected void onTearDownAfterTransaction() throws Exception {

        super.onTearDownAfterTransaction();
        deleteFromTables(new String[]{"item_catagory", "item", "catagory"});
    }

    public CatagoryServiceTest(String testName) {
        super(testName);
    }

    public void testGetCatagories() {
        System.out.println("getCatagories");
        
        List result = catagoryService.getCatagories();
        assertNotNull ( result );
        assertTrue ( result.size() == 4 );
        System.out.println ( result );
    } /* Test of getCatagories method, of class ItemService. */

    public void testGetCatagoryItems() {
        System.out.println("getCatagoryItems");
        Long catagory = 1L;
        
        List result = catagoryService.getCatagoryItems(catagory);
        assertNotNull ( result );
        assertTrue ( result.size() == 6 );
        System.out.println ( result );
    } /* Test of getCatagoryItems method, of class ItemService. */
}
