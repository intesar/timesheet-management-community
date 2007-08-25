/*
 * SearchController.java
 *
 * Created on Aug 18, 2007, 11:06:37 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.controller.shoppingCart;

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

        // find cart in session
        ShoppingCart sp = (ShoppingCart) request.getPortletSession().getAttribute("SHOPPING_CART", request.getPortletSession().APPLICATION_SCOPE);
        if (sp == null) {
            sp = new ShoppingCart();
            request.getPortletSession().setAttribute("SHOPPING_CART", sp, request.getPortletSession().APPLICATION_SCOPE);
        }

        
        //read required params
        boolean flag = true;
        for (int i = 1; flag; i++) {
            System.out.println (" ______ " + i);
            String key = request.getParameter("item_name_" + i);
            if (key != null && key.trim().length() > 0) {
                Long id = Long.valueOf(key);
                Long quantity = 0L;
                try { 
                    quantity = Long.valueOf(request.getParameter("item_quantity_" + i));
                } catch ( Exception e) {                    
                    // log exception
                }
                System.out.println (" ______ " + id + "  " + quantity);                
                sp.updateItemQuantity(id, quantity);
            } else {
                flag = false;
            }
        }
        
    }

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        // find cart in session
        ShoppingCart sp = (ShoppingCart) request.getPortletSession().getAttribute("SHOPPING_CART", request.getPortletSession().APPLICATION_SCOPE);
        if (sp == null) {
//            com.abbhsoft.shoppingcart.CartItem item = new com.abbhsoft.shoppingcart.CartItem();
//            item.setId(33L);
//            item.setName("Name");
//            item.setPrice(333.3);
//            item.setQuantity(1L);
//
//            com.abbhsoft.shoppingcart.CartItem item1 = new com.abbhsoft.shoppingcart.CartItem();
//            item1.setId(34L);
//            item1.setName("Name1");
//            item1.setPrice(333.3);
//            item1.setQuantity(1L);
//
//            com.abbhsoft.shoppingcart.CartItem item2 = new com.abbhsoft.shoppingcart.CartItem();
//            item2.setId(38L);
//            item2.setName("Name2");
//            item2.setPrice(333.3);
//            item2.setQuantity(4L);
            sp = new com.abbhsoft.shoppingcart.ShoppingCart();
//            sp.addItem(item);
//            sp.addItem(item1);
//            sp.addItem(item2);

            request.getPortletSession().setAttribute("SHOPPING_CART", sp, request.getPortletSession().APPLICATION_SCOPE);
        }
        return new ModelAndView("shoppingCart/view");
    }
}
