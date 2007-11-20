/*
 * newCampusBean.java
 * 
 * Created on Nov 16, 2007, 8:15:36 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.web.formBeans;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.abbhsoft.srm.model.Address;
/**
 *
 * @author Amer
 */
public class CampusBean extends org.apache.struts.action.ActionForm {
    
   private Long university;
   private String campus;
   private String street;
   private String type;
   private String city;
   private String state;
   private String zip;
   private String country;

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public Long getUniversity() {
        return university;
    }

    public void setUniversity(Long university) {
        this.university = university;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    
    
   public CampusBean() {
       super();
       // TODO Auto-generated constructor stub
   }

   @Override
   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
       ActionErrors errors = new ActionErrors();
       if (getCampus() == null || getCampus().length() < 1) {
           errors.add("campus", new ActionMessage("error.campus.required"));
           // TODO: add 'error.name.required' key to your resources
       }
       if(getStreet() == null || getStreet().length() < 1) {
           errors.add("street", new ActionMessage("error.street.required"));
       }
       if(getCity() == null || getCity().length() < 1) {
           errors.add("city", new ActionMessage("error.city.required"));
       }
       return errors;
   }
}
