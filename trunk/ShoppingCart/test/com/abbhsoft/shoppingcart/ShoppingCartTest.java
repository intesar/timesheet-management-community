/*
 * ShoppingCartTest.java
 * JUnit 4.x based test
 *
 * Created on August 22, 2007, 10:27 PM
 */

package com.abbhsoft.shoppingcart;

import java.util.Collection;
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
public class ShoppingCartTest {

    public ShoppingCartTest() {
        System.out.println ("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        shoppingCart = new ShoppingCart();
        shoppingCart.setShippingMethod("PICK UP");
        shoppingCart.setShippingMethodPrice(0.0);
        shoppingCart.setTaxRate(0.00785);
        shoppingCart.setTaxUsState("PA");
        CartItem cartItem = new CartItem();
        cartItem.setId(1L);
        cartItem.setName("BURGER VEG");
        cartItem.setDescription("DOUBLE CHEESE");
        cartItem.setPrice(4.99);
        cartItem.setQuantity(1L);
        shoppingCart.addItem(cartItem);
    }

    private ShoppingCart shoppingCart = null;

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
    public void getCartItems() {
        System.out.println("getCartItems");
        
        Collection result = shoppingCart.getCartItems();
        assertNotNull(result);
        System.out.println ( " ________ " + result.size() );
        assertTrue(result.size() == 1);
    } /* Test of getCartItems method, of class ShoppingCart. */

    @Test
    public void getCartItemsforEmptyCart() {
        System.out.println("getCartItems");
        ShoppingCart instance = new ShoppingCart();
        Collection result = instance.getCartItems();
        assertNotNull(result);
        assertTrue(result.size() == 0);
    } /* Test of getCartItems method, of class ShoppingCart. */

    @Test
    public void getShippingMethod() {
        System.out.println("getShippingMethod");
        String expResult = "PICK UP";
        String result = shoppingCart.getShippingMethod();
        assertEquals(expResult, result);
    } /* Test of getShippingMethod method, of class ShoppingCart. */

    @Test
    public void setShippingMethod() {
        System.out.println("setShippingMethod");
        String shippingMethod = "ELECTRONICAL";
        shoppingCart.setShippingMethod(shippingMethod);
        String expResult = "ELECTRONICAL";
        String result = shoppingCart.getShippingMethod();
        assertEquals(expResult, result);
    } /* Test of setShippingMethod method, of class ShoppingCart. */

    @Test
    public void getShippingMethodPrice() {
        System.out.println("getShippingMethodPrice");
        Double expResult = 0.0;
        Double result = shoppingCart.getShippingMethodPrice();
        assertEquals(expResult, result);
    } /* Test of getShippingMethodPrice method, of class ShoppingCart. */

    @Test
    public void setShippingMethodPrice() {
        System.out.println("setShippingMethodPrice");
        Double shippingMethodPrice = 1.99;
        shoppingCart.setShippingMethodPrice(shippingMethodPrice);
        Double expResult = 1.99;
        Double result = shoppingCart.getShippingMethodPrice();
        assertEquals(expResult, result);
    } /* Test of setShippingMethodPrice method, of class ShoppingCart. */

    @Test
    public void getTaxRate() {
        System.out.println("getTaxRate");
        Double expResult = 0.00785;
        Double result = shoppingCart.getTaxRate();
        assertEquals(expResult, result);
    } /* Test of getTaxRate method, of class ShoppingCart. */

    @Test
    public void setTaxRate() {
        System.out.println("setTaxRate");
        Double taxRate = 0.005;
        shoppingCart.setTaxRate(taxRate);
        Double expResult = 0.005;
        Double result = shoppingCart.getTaxRate();
        assertEquals(expResult, result);
    } /* Test of setTaxRate method, of class ShoppingCart. */

    @Test
    public void getTaxUsState() {
        System.out.println("getTaxUsState");
        String expResult = "PA";
        String result = shoppingCart.getTaxUsState();
        assertEquals(expResult, result);
        
    } /* Test of getTaxUsState method, of class ShoppingCart. */

    @Test
    public void setTaxUsState() {
        System.out.println("setTaxUsState");
        String taxUsState = "NY";
        shoppingCart.setTaxUsState(taxUsState);
        String expResult = "NY";
        String result = shoppingCart.getTaxUsState();
        assertEquals(expResult, result);
    } /* Test of setTaxUsState method, of class ShoppingCart. */

    @Test
    public void addItem() {
        System.out.println("addItem");
        CartItem cartItem = new CartItem(2L, "APPLE PIE", "SUPER APPLE PIE", 0.99, 1L);
        shoppingCart.addItem(cartItem);
        System.out.println ("addItem"+ shoppingCart.getCartItems() );
        assertTrue ( shoppingCart.getCartItems().size() == 2 );
        
    } /* Test of addItem method, of class ShoppingCart. */

    @Test
    public void updateItemQuantity() {
        System.out.println("updateItemQuantity");
        Long itemId = 1L;
        Long quantity = 3L;
        System.out.println ("updateItemQuantity"+ shoppingCart.getCartItems() );
        shoppingCart.updateItemQuantity(itemId, quantity);
        CartItem cartItem = shoppingCart.getCartItem(itemId);
        assertTrue ( cartItem.getQuantity() == 3L );
        System.out.println ( "updateItemQuantity"+shoppingCart.getCartItems() );
    } /* Test of updateItemQuantity method, of class ShoppingCart. */
    
    @Test
    public void updateItemQuantityForRemove() {
        System.out.println("updateItemQuantity");
        Long itemId = 1L;
        Long quantity = 0L;
        System.out.println ( shoppingCart.getCartItems() );
        shoppingCart.updateItemQuantity(itemId, quantity);
        System.out.println ( shoppingCart.getCartItems() );
        assertTrue ( shoppingCart.getCartItems().size() == 0 );
    } /* Test of updateItemQuantity method, of class ShoppingCart. */
}
