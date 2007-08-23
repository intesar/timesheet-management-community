/*
 * SearchController.java
 *
 * Created on Aug 18, 2007, 11:06:37 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.controller;

import com.abbhsoft.shoppingcart.CartItem;
import com.abbhsoft.shoppingcart.ShoppingCart;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 *
 * @author shannan
 * 
 *  Adds and Item or Updates its Quantity
 *  required params [ id, name, description, price ]
 */
public class ShoppingCartAddItemController extends AbstractController implements InitializingBean {

    @Override
    protected void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        //read required params
        Long id = Long.valueOf(request.getParameter("id").trim());
        String name = request.getParameter("name").trim();
        String description = request.getParameter("description");
        Double price = Double.valueOf(request.getParameter("price").trim());

        // find cart in session
        ShoppingCart shoppingCart = (ShoppingCart) request.getPortletSession().getAttribute("SHOPPING_CART",request.getPortletSession().APPLICATION_SCOPE);
        // create one if doens't exists
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            request.getPortletSession().setAttribute("SHOPPING_CART", shoppingCart, request.getPortletSession().APPLICATION_SCOPE);
        }
        //add the item 
        // no need to add the cart reference to session its already added
        CartItem cartItem = new CartItem(id, name, description, price, 1L);
        shoppingCart.addItem(cartItem);
    }



    public void afterPropertiesSet() throws Exception {
    }
}
