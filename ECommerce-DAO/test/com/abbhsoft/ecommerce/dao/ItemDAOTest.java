/*
 * ItemDAOTest.java
 * JUnit based test
 *
 * Created on September 4, 2007, 3:23 PM
 */

package com.abbhsoft.ecommerce.dao;

import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Intesar.Mohammed
 */
public class ItemDAOTest extends TestCase
{
    
    public ItemDAOTest (String testName)
    {
        super (testName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testFindBySearchKeys() {
        System.out.println("findBySearchKeys");
        String[] keys = null;
        ItemDAO instance = null;
        List expResult = null;
        List result = instance.findBySearchKeys(keys);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findBySearchKeys method, of class ItemDAO. */

    public void testFindByPrice() {
        System.out.println("findByPrice");
        Double[] prices = null;
        ItemDAO instance = null;
        List expResult = null;
        List result = instance.findByPrice(prices);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } /* Test of findByPrice method, of class ItemDAO. */
    
}
