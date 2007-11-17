/*
 * GroupBean.java
 * 
 * Created on Nov 16, 2007, 9:05:08 PM
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
public class GroupBean extends org.apache.struts.action.ActionForm {
    
   private String owner;
   private String subscribeEmail;
   private String groupEmail;
   private String unSubscribeEmail;

    public String getGroupEmail() {
        return groupEmail;
    }

    public void setGroupEmail(String groupEmail) {
        this.groupEmail = groupEmail;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSubscribeEmail() {
        return subscribeEmail;
    }

    public void setSubscribeEmail(String subscribeEmail) {
        this.subscribeEmail = subscribeEmail;
    }

    public String getUnSubscribeEmail() {
        return unSubscribeEmail;
    }

    public void setUnSubscribeEmail(String unSubscribeEmail) {
        this.unSubscribeEmail = unSubscribeEmail;
    }
   
   

   /**
    *
    */
   public GroupBean() {
       super();
       // TODO Auto-generated constructor stub
   }

   @Override
   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
       ActionErrors errors = new ActionErrors();
       if (getGroupEmail() == null || getGroupEmail().length() < 1) {
           errors.add("groupEmail", new ActionMessage("error.groupEmail.required"));
           // TODO: add 'error.name.required' key to your resources
       }
       return errors;
   }
}
