/*
 * ShoppingCart.java
 *
 * Created on Aug 22, 2007, 10:07:04 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.shoppingcart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author shannan
 */
public class ShoppingCart {

    public ShoppingCart() {
    }

    public Collection<CartItem> getCartItems() {
        return cartItems.values();
    }

    public CartItem getCartItem(Long id) {
        return cartItems.get(id);
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Double getShippingMethodPrice() {
        return shippingMethodPrice;
    }

    public void setShippingMethodPrice(Double shippingMethodPrice) {
        this.shippingMethodPrice = shippingMethodPrice;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxUsState() {
        return taxUsState;
    }

    public void setTaxUsState(String taxUsState) {
        this.taxUsState = taxUsState;
    }


    /**
     *
     * @param cartItem
     *
     *   adds this item to the shopping cart if it doesn't exits 
     *   or increments its quantity value for that item
     */
    public void addItem(CartItem cartItem) {
        if (cartItems.containsKey(cartItem.getId())) {
            CartItem cartItem1 = cartItems.get(cartItem.getId());
            System.out.println ( "__________________ " + cartItem1.getQuantity());            
            cartItem1.setQuantity(cartItem1.getQuantity() + 1);
            System.out.println ( "__________________ " + cartItem1.getQuantity());
        } else {
            cartItems.put(cartItem.getId(), cartItem);
        }
        
        System.out.println ( "__________________ Cart " + this.getCartItems());
    }

    /**
     *
     * @param itemId
     * @param quantity
     *
     *  if quantity is greater then zero then its replaced for that object
     *  else the object is removed from the cart
     *
     */
    public void updateItemQuantity(Long itemId, Long quantity) {
        if (cartItems.containsKey(itemId)) {
            if (quantity > 0L) {
                CartItem cartItem1 = cartItems.get(itemId);
                cartItem1.setQuantity(quantity);
            } else {
                cartItems.remove(itemId);
            }
        }
    }




    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getGrossTotal() {
        return DoubleFormatter.format(this.getSubTotal() + this.getTotalTax());
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Double getSubTotal() {
        return DoubleFormatter.format(calculateTotal());
    }



    public Double getTotalTax() {
        return DoubleFormatter.format(calculateTotal() * this.taxRate);
    }



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private Double calculateTotal() {
        Double total = 0.0;
        Collection<CartItem> cartItemsLocal = this.getCartItems();
        for (CartItem cartItemLocal : cartItemsLocal) {
            total += cartItemLocal.getPrice() * cartItemLocal.getQuantity();
        }
        return total;
    }

    private Map<Long, CartItem> cartItems = new HashMap<Long, CartItem>();
    private String shippingMethod = "PICK UP";
    private Double shippingMethodPrice = 0.0;
    private Double taxRate = 0.0;
    private String taxUsState = "PA";
    private String address;
    private String host;
    private String port;
    private String user;
}
