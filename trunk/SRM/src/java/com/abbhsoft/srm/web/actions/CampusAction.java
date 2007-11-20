/*
 * CampusAction.java
 * 
 * Created on Nov 16, 2007, 8:26:27 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.web.actions;

import com.abbhsoft.srm.model.Campus;
import com.abbhsoft.srm.service.CampusService;
import com.abbhsoft.srm.service.ServiceFactory;
import com.abbhsoft.srm.web.converters.CampusConverter;
import com.abbhsoft.srm.web.formBeans.CampusBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Amer
 */
public class CampusAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CampusBean bean = (CampusBean) form;
        Campus c = CampusConverter.toModel(bean);
        CampusService service = (CampusService) ServiceFactory.getInstance().getBean("campusServiceImpl");
        service.save(c);
        return mapping.findForward(SUCCESS);
        
    }
}