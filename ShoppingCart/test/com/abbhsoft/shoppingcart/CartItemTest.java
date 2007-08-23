/*
 * CartItemTest.java
 * JUnit 4.x based test
 *
 * Created on August 23, 2007, 5:14 PM
 */

package com.abbhsoft.shoppingcart;

import java.text.DecimalFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Intesar.Mohammed
 */
public class CartItemTest {

    public CartItemTest() {
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
    public void getDescription() {
        System.out.println("getDescription");
        CartItem instance = new CartItem();
        String expResult = "";
        String result = instance.getDescription();
    } /* Test of getDescription method, of class CartItem. */

    @Test
    public void setDescription() {
        System.out.println("setDescription");
        String description = "";
        CartItem instance = new CartItem();
        instance.setDescription(description);
    } /* Test of setDescription method, of class CartItem. */

    @Test
    public void getId() {
        System.out.println("getId");
        CartItem instance = new CartItem();
        Long expResult = null;
        Long result = instance.getId();
    } /* Test of getId method, of class CartItem. */

    @Test
    public void setId() {
        System.out.println("setId");
        Long id = null;
        CartItem instance = new CartItem();
        instance.setId(id);
    } /* Test of setId method, of class CartItem. */

    @Test
    public void getName() {
        System.out.println("getName");
        CartItem instance = new CartItem();
        String expResult = "";
        String result = instance.getName();
    } /* Test of getName method, of class CartItem. */

    @Test
    public void setName() {
        System.out.println("setName");
        String name = "";
        CartItem instance = new CartItem();
        instance.setName(name);
    } /* Test of setName method, of class CartItem. */

    @Test
    public void getPrice() {
        System.out.println("getPrice");
        CartItem instance = new CartItem();
        Double expResult = null;
        Double result = instance.getPrice();
    } /* Test of getPrice method, of class CartItem. */

    @Test
    public void setPrice() {
        System.out.println("setPrice");
        Double price = null;
        CartItem instance = new CartItem();
        instance.setPrice(price);
    } /* Test of setPrice method, of class CartItem. */

    @Test
    public void getQuantity() {
        System.out.println("getQuantity");
        CartItem instance = new CartItem();
        Long expResult = null;
        Long result = instance.getQuantity();
    } /* Test of getQuantity method, of class CartItem. */

    @Test
    public void setQuantity() {
        System.out.println("setQuantity");
        Long quantity = null;
        CartItem instance = new CartItem();
        instance.setQuantity(quantity);
    } /* Test of setQuantity method, of class CartItem. */

    @Test
    public void subTotal() {
        System.out.println("subTotal");
        CartItem instance = new CartItem();
        Double expResult = null;
        Double result = instance.subTotal();
    } /* Test of subTotal method, of class CartItem. */

    @Test
    public void equals() {
        System.out.println("equals");
        Object obj = null;
        CartItem instance = new CartItem();
        boolean expResult = false;
        boolean result = instance.equals(obj);
    } /* Test of equals method, of class CartItem. */

    @Test
    public void DecimalScale() {
//       Double d = 100.0033;
//       BigDecimal bd = new BigDecimal(d);
//       bd.setScale(1,RoundingMode.CEILING);
//       System.out.println ( bd.doubleValue() );
//
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setDecimalSeparatorAlwaysShown(true);
        Double d = Double.valueOf(df.format(33));
        System.out.println (d );
        
    }
}
