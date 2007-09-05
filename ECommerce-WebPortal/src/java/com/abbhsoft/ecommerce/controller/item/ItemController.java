/*
 * SearchController.java
 *
 * Created on Aug 18, 2007, 11:06:37 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.controller.item;

import com.abbhsoft.ecommerce.model.Item;
import com.abbhsoft.ecommerce.service.CatagoryService;
import com.abbhsoft.shoppingcart.CartItem;
import com.abbhsoft.shoppingcart.ShoppingCart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
 */
public class ItemController extends AbstractController implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        if (this.catagoryService == null) {
            throw new NullPointerException();
        }
    }

    @Override
    protected void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        //read required params
        Long id = Long.valueOf(request.getParameter("itemId").trim());
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

    @Override
    @SuppressWarnings(value = "unchecked")
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        Long id = (Long) request.getPortletSession().getAttribute("CATAGORY", request.getPortletSession().APPLICATION_SCOPE);
        Collection<Item> items = null;
        if (id != null) {
            items = catagoryService.getCatagoryItems(id);
        } else {
            items = (Collection<Item>) request.getPortletSession().getAttribute("ITEM_LIST", request.getPortletSession().APPLICATION_SCOPE);
        }

        if (items == null) {
            items = new ArrayList<Item>();
        }
        request.setAttribute("ITEMS", items);
        return new ModelAndView("item/view");
    }

    public void setCatagoryService(CatagoryService catagoryService) {
        this.catagoryService = catagoryService;
    }



    private CatagoryService catagoryService;
}
