/*
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
 * @author mdshannan
 */
public class UniversityBean extends org.apache.struts.action.ActionForm {
    
   private String name;

  

   /**
    * @return
    */
   public String getName() {
       return name;
   }

   /**
    * @param string
    */
   public void setName(String string) {
       name = string;
   }

  

   /**
    *
    */
   public UniversityBean() {
       super();       
   }

   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
       ActionErrors errors = new ActionErrors();
       if (getName() == null || getName().length() < 1) {
           errors.add("name", new ActionMessage("error.name.required"));           
       }
       return errors;
   }
}
