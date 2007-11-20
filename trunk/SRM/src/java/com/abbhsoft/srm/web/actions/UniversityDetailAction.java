/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author mdshannan
 */
public class UniversityDetailAction extends org.apache.struts.action.Action {

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
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println ( "### inside University Detail ");
        String id = request.getParameter("universityId");
        if ( id == null || id.length() < 1 )
            id = "3";
        Long universityId = Long.valueOf(id);
//        UniversityService service = (UniversityService) ServiceFactory.getInstance().getBean("universityServiceImpl");
//        University u = service.getUniversityByIdWithDetails(universityId);
        request.getSession().setAttribute("universityId", universityId);
        return mapping.findForward(SUCCESS);

    }
}