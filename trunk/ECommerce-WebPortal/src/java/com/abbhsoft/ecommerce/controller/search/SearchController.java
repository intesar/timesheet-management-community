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
public class SearchController extends AbstractController implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        
    }

    @Override
    protected void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        
    }

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {

       return new ModelAndView("search/view");
       
    }


   
}
