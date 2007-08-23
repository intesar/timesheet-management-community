/*
 * SearchController.java
 *
 * Created on Aug 18, 2007, 11:06:37 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.controller;

import com.abbhsoft.shoppingcart.ShoppingCart;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 *
 * @author shannan
 *
 *  Updates Cart Item
 *  Required Params [ id(item), quantity ]
 *
 */
public class ShoppingCartUpdateItemController extends AbstractController implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
    }

    @Override
    protected void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        //read required params
        Long id = Long.valueOf(request.getParameter("id").trim());
        Long quantity = Long.valueOf(request.getParameter("quantity").trim());

        // find cart in session
        ShoppingCart shoppingCart = (ShoppingCart) request.getPortletSession().getAttribute("SHOPPING_CART",request.getPortletSession().APPLICATION_SCOPE);

        // update the cart
        shoppingCart.updateItemQuantity(id, quantity);
    }

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        return new ModelAndView("cart/view");
    }
}
