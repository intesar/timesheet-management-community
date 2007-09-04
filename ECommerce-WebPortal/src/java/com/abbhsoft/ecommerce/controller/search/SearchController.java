/*
 * SearchController.java
 *
 * Created on Aug 18, 2007, 11:06:37 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.controller.search;

import com.abbhsoft.ecommerce.controller.menu.*;
import com.abbhsoft.ecommerce.model.Item;
import com.abbhsoft.ecommerce.service.ItemService;
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
public class SearchController extends AbstractController implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        
    }

    @Override
    protected void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        String key = request.getParameter("key");
        List<Item> list = this.itemService.getMatchingItems(key);
        request.getPortletSession().setAttribute("ITEM_LIST", list, request.getPortletSession().APPLICATION_SCOPE);
        // removing selected category
        request.getPortletSession().removeAttribute("CATAGORY", request.getPortletSession().APPLICATION_SCOPE);
        // storing the entered key
        response.setRenderParameter("key", key);
    }

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
       //String key = request.getAttribute("KEY");
       
       return new ModelAndView("search/view");
       
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    
    
    private ItemService itemService;
   
}
