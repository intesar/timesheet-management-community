/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.web.actions;

import com.abbhsoft.srm.service.SearchEngineService;
import com.abbhsoft.srm.service.ServiceFactory;
import com.abbhsoft.srm.service.impl.SearchEngineServiceImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Intesar.Mohammed
 */
public class SearchAction extends org.apache.struts.action.Action {
    
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
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String text = request.getParameter("searchText");
        SearchEngineService service = (SearchEngineService) ServiceFactory.getInstance().getBean("searchEngineServiceImpl");
        List list = service.search(text);
        request.setAttribute("list", list);
        return mapping.findForward(SUCCESS);
        
    }
}