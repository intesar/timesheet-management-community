/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.web.formBeans;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author mdshannan
 */
public class EventFormBean extends org.apache.struts.action.ActionForm {

    private String dateString;
    private Date date;
    private String type;
    private String descript;
    private String priority;
    private Long university;
    private Long group;
    private Long student;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
    
    

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUniversity() {
        return university;
    }

    public void setUniversity(Long university) {
        this.university = university;
    }

   
    /**
    *
    */
    public EventFormBean() {
        super();
    // TODO Auto-generated constructor stub
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
         java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        try {
            
            java.util.Date dt = sdf.parse(dateString);
            date = dt;
        }catch(java.text.ParseException p) {
            System.out.println ( dateString );
            p.printStackTrace();
            errors.add("date", new ActionMessage("error.date.required"));
        }
 

        return errors;
    }
}
