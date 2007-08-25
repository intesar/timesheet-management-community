/*
 * ItemServiceTest.java
 * 
 * Created on Aug 25, 2007, 6:50:25 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.service;

/**
 *
 * @author Mohammed Hamed
 */

import com.abbhsoft.ecommerce.model.Item;
import java.util.Collection;
import java.util.Iterator;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class ItemServiceTest extends  AbstractTransactionalDataSourceSpringContextTests { 

    
    private ItemService itemService;
    public ItemServiceTest() {
    }

    
    public void setItemService(ItemService itemService)
    {
        this.itemService=itemService;
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

    public ItemServiceTest(String testName) {
        super(testName);
    }

    public void testFindAll()
    {
        Collection<Item> items = itemService.getAllItems();   
        Iterator iter = items.iterator();
     
        
            Item it = (Item)iter.next();
            System.out.println(it.getName());
        
        }
        
    }

