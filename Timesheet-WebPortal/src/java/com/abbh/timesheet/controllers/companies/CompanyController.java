/*
 * CompanyController.java
 *
 * Created on Aug 15, 2007, 11:15:43 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.controllers.companies;

import java.util.HashMap;
import java.util.Map;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 *
 * @author shannan
 *   This Controller looks is there any object with name "SEARCH_COMPANIES" in session
 *   if it finds then it type casts it to ValueListHandler and currentList and pageList
 *   into model.put("currentList", ...) etc
 *   
 *   if it doesn't find anything in session then it get current user registered companies and 
 *   does the same thing
 * 
 *   all the comments needs to removed once the appropriate services are done
 * 
 */
public class CompanyController extends AbstractController implements InitializingBean {

//    private CompanyService companyService;
    public void afterPropertiesSet() throws Exception {
//        if (this.companyService == null) {
//            throw new IllegalArgumentException("A CompanyService is required");
//        }
    }

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {

        Map model = new HashMap();
//        model.put("books", campies);
        return new ModelAndView("booksView", "model", model);
    }

//
//        public void setCompanyService(CompanyService companyService) {
//            this.companyService = companyService;
//          }
//
//
//
}
