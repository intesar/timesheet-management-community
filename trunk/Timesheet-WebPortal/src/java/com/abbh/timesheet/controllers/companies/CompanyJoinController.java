/*
 * CompanyController.java
 *
 * Created on Aug 15, 2007, 11:15:43 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.controllers.companies;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 *
 * @author shannan
 *   
 *   reads the company id, comments and submit a join request
 * 
 */
public class CompanyJoinController extends AbstractController implements InitializingBean {

//    private CompanyService companyService;
    public void afterPropertiesSet() throws Exception {
//        if (this.companyService == null) {
//            throw new IllegalArgumentException("A CompanyService is required");
//        }
    }

    @Override
    public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
        Integer id = new Integer(request.getParameter("company"));
        String comment = new String(request.getParameter("comment"));
        String userId = request.getRemoteUser();
//        companyService.join ( id, userId, comment);
       
    }

//
//        public void setCompanyService(CompanyService companyService) {
//            this.companyService = companyService;
//          }
//
//
//
}

