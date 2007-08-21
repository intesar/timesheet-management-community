/*
 * SearchController.java
 *
 * Created on Aug 18, 2007, 11:06:37 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.controller;



import com.abbhsoft.ecommerce.service.ItemService;
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
public class MenuCatagoryController extends AbstractController implements InitializingBean {

     public void afterPropertiesSet() throws Exception {
        if (this.itemService == null) {
            throw new NullPointerException();
        }
    }

    @Override
    protected void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        
        //request.getPortletSession().setAttribute("SEARCH_VLH", vlh, request.getPortletSession().APPLICATION_SCOPE);
    }

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        return new ModelAndView("menuCatagory/view");
    }


    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }



    private ItemService itemService;
}
