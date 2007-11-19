/*
 * StudentAction.java
 * 
 * Created on Nov 16, 2007, 10:44:26 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.web.actions;

import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.service.ServiceFactory;
import com.abbhsoft.srm.service.StudentService;
import com.abbhsoft.srm.web.converters.StudentConverter;
import com.abbhsoft.srm.web.formBeans.StudentFormBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Amer
 */
public class StudentAction extends org.apache.struts.action.Action {

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
        StudentFormBean bean = (StudentFormBean) form;
        Student student = StudentConverter.toModel(bean);
        StudentService service = (StudentService) ServiceFactory.getInstance().getBean("studentServiceImpl");
        service.save(student);
        return mapping.findForward(SUCCESS);

    }
}