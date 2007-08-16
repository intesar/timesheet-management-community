/*
 * CompanyEditController.java
 *
 * Created on Aug 15, 2007, 11:36:51 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.controllers.companies;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.PortletRequestDataBinder;
import org.springframework.web.portlet.mvc.SimpleFormController;

/**
 *
 * @author shannan
 *  reads companyId and loads it
 *
 */
public class CompanyEditController extends SimpleFormController implements InitializingBean {

//    private CompanyService companyService;
    public void afterPropertiesSet() throws Exception {
//        if (this.companyService == null) {
//            throw new IllegalArgumentException("A CompanyService is required");
//        }
    }

    public void onSubmitAction(ActionRequest request, ActionResponse response, Object command, BindException errors) throws Exception {

//        CompanyDTO companyDTO = (CompanyDTO) command;
//        companyService.add ( companyDTO );
//        response.setRenderParameter("action", "books");
    }

    protected Object formBackingObject(PortletRequest request) throws Exception {

//        CompanyDTO companyDTO;
//
//        try {
//            Integer key = new Integer(request.getParameter("company"));
//            companyDTO = companyService.getCompany(key);
//        } catch (NumberFormatException ex) {
//            companyDTO = new CompanyDTO();
//        }
//
//        return companyDTO;
        
        return null;
    }

    protected void initBinder(PortletRequest request, PortletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
        binder.setAllowedFields(new String[]{"author", "title", "description", "availability", "count"});
    }

    protected ModelAndView renderInvalidSubmit(RenderRequest request, RenderResponse response) throws Exception {
        return null;
    }

    protected void handleInvalidSubmit(ActionRequest request, ActionResponse response) throws Exception {
        response.setRenderParameter("action", "companies");
    }
}
