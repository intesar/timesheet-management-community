/*
 * QueryFormBean.java
 * 
 * Created on Nov 16, 2007, 11:27:52 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.web.formBeans;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Amer
 */
public class QueryFormBean extends org.apache.struts.action.ActionForm {

    private String message;
    private Long student;

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
    *
    */
    public QueryFormBean() {
        super();
    // TODO Auto-generated constructor stub
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        System.out.println ( "Student : " + getStudent() );
        ActionErrors errors = new ActionErrors();
        if (getMessage() == null || getMessage().length() < 1) {
            errors.add("message", new ActionMessage("error.message.required"));            
        }
        if (getStudent() == null || getStudent() < 1) {
            errors.add("message", new ActionMessage("error.message.required"));
        }
        return errors;
    }
}
