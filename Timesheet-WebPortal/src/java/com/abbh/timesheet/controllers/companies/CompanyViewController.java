/*
 * CompanyController.java
 *
 * Created on Aug 15, 2007, 11:15:43 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.controllers.companies;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 *
 * @author shannan
 *   
 *   reads the company id, and loads it
 * 
 */
public class CompanyViewController extends AbstractController implements InitializingBean {

//    private CompanyService companyService;
    public void afterPropertiesSet() throws Exception {
//        if (this.companyService == null) {
//            throw new IllegalArgumentException("A CompanyService is required");
//        }
    }

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        Integer id = new Integer(request.getParameter("company"));
        Object object = null; //companyService.getCompany(id);
        return new ModelAndView("companyView", "company", object);
    }

//
//        public void setCompanyService(CompanyService companyService) {
//            this.companyService = companyService;
//          }
//
//
//
}
