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
public class SearchFormBean extends org.apache.struts.action.ActionForm {
    
   private String searchText;

   

   public SearchFormBean() {
       super();
       // TODO Auto-generated constructor stub
   }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
       ActionErrors errors = new ActionErrors();
       if (getSearchText() == null || getSearchText().length() < 1) {
           errors.add("name", new ActionMessage("error.name.required"));
           // TODO: add 'error.name.required' key to your resources
       }
       return errors;
   }
}
