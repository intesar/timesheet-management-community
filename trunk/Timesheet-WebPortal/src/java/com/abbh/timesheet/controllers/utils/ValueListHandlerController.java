/*
 * CompanyController.java
 *
 * Created on Aug 15, 2007, 11:15:43 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.controllers.utils;

import com.abbh.timesheet.controllers.companies.*;
import com.abbhsoft.framework.valueListHandler.ValueListHandler;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 *
 * @author shannan
 *   
 *   All the Pagination code calls this controllers and passes two params
 *   ValueListHandler Session Id and pageNo
 * 
 */
public class ValueListHandlerController extends AbstractController implements InitializingBean {

//    private CompanyService companyService;
    public void afterPropertiesSet() throws Exception {
//        if (this.companyService == null) {
//            throw new IllegalArgumentException("A CompanyService is required");
//        }
    }

    @Override
    public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        String id = new String(request.getParameter("VLH_SESSION_ID"));
        Integer pageNo = new Integer(request.getParameter("pageNo"));
        ValueListHandler vlh = (ValueListHandler) request.getPortletSession().getAttribute(id, PortletSession.APPLICATION_SCOPE);
//        create list
//        set current list in session
//        set current page list in session

       
    }

//
//        public void setCompanyService(CompanyService companyService) {
//            this.companyService = companyService;
//          }
//
//
//
}

