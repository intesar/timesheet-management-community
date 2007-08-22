/*
 * SearchController.java
 *
 * Created on Aug 18, 2007, 11:06:37 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.controller;

import com.abbhsoft.ecommerce.service.CatagoryService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
        if (this.catagoryService == null) {
            throw new NullPointerException();
        }
    }

    @Override
    protected void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        try {
            Long catagory = Long.parseLong(request.getParameter("catagory"));
            request.getPortletSession().setAttribute("catagory", catagory, request.getPortletSession().APPLICATION_SCOPE);
        } catch (RuntimeException re) {
            //log
        }
    }

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {

        Map<String, Collection> model = new HashMap<String, Collection>();
        model.put("catagories", catagoryService.getCatagories());

        return new ModelAndView("menuCatagory/view", "model", model);
    }


    public void setCatagoryService(CatagoryService catagoryService) {
        this.catagoryService = catagoryService;
    }



    private CatagoryService catagoryService;
}
