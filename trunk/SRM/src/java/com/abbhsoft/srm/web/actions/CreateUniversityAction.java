/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.web.actions;

import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.service.ServiceFactory;
import com.abbhsoft.srm.service.UniversityService;
import com.abbhsoft.srm.web.converters.UniversityConverter;
import com.abbhsoft.srm.web.formBeans.UniversityBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author mdshannan
 */
public class CreateUniversityAction extends org.apache.struts.action.Action {
    
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
        
        UniversityBean bean = (UniversityBean) form;
        University u = UniversityConverter.toUniversityModel(bean);
        UniversityService service = (UniversityService) ServiceFactory.getInstance().getBean("universityServiceImpl");
        service.save(u);
        
        return mapping.findForward(SUCCESS);
        
    }
}