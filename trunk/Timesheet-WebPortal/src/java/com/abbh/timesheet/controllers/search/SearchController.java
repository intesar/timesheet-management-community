/*
 * SearchController.java
 *
 * Created on Aug 18, 2007, 11:06:37 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.controllers.search;

import com.abbh.timesheet.service.CompanyService;
import com.abbhsoft.framework.valueListHandler.ValueListHandler;
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
        if (this.companyService == null) {
            ;
        }
    }

    @Override
    protected void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        // get the key and search it
        String key = request.getParameter("key");
        System.out.println(" _______ search key : " + key);
        System.out.println("  inside .... ");
        ValueListHandler vlh = null;
        try {
            vlh = companyService.search(key);
        } catch (RuntimeException re) {
            System.out.println("  inside Exception.... ");
            re.printStackTrace();
        }
        System.out.println(" finished service call..... ");
        vlh.createList(1);
        System.out.println(" ________ VLH " + vlh.getCurrentResultList().toString());
        request.getPortletSession().setAttribute("SEARCH_VLH", vlh, request.getPortletSession().APPLICATION_SCOPE);
    }

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        return new ModelAndView("search/view");
    }


    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }



    private CompanyService companyService;
}
