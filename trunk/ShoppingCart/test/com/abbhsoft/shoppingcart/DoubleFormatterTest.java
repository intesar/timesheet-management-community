/*
 * DoubleFormatterTest.java
 * JUnit 4.x based test
 *
 * Created on August 23, 2007, 8:00 PM
 */

package com.abbhsoft.shoppingcart;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shannan
 */
public class DoubleFormatterTest {
    
    public DoubleFormatterTest () {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void format() {
        System.out.println("format");
        Double value = 33.333;
        Double expResult = 33.33;
        Double result = DoubleFormatter.format(value);
        assertEquals(expResult, result);
        
    } /* Test of format method, of class DoubleFormatter. */
    
     @Test
    public void format1() {
        System.out.println("format");
        Double value = 33.333;
        Double expResult = 3333.3;
        Double result = DoubleFormatter.format(value * 100);
        assertEquals(expResult, result);
        
    } /* Test of format method, of class DoubleFormatter. */
    
}
