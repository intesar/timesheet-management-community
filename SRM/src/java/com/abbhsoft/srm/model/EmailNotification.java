/*
 * EmailNotification.java
 * 
 * Created on Nov 24, 2007, 12:27:15 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "email_notification")
@NamedQueries({
    @NamedQuery(name = "email_notification.findById", query = "SELECT a FROM email_notification a WHERE a.id = ?1"), 
    @NamedQuery(name = "email_notification.findByEmailId", query = "SELECT a FROM email_notification a WHERE a.emailId = ?1"), 
    @NamedQuery(name = "email_notification.findBySentDate", query = "SELECT a FROM email_notification a WHERE a.sentDate = ?1"), 
    @NamedQuery(name = "email_notification.findByTemplate", query = "SELECT a FROM email_notification a WHERE a.template = ?1"), 
    @NamedQuery(name = "email_notification.findByCreateUser", query = "SELECT a FROM email_notification a WHERE a.createUser = ?1"),
    @NamedQuery(name = "email_notification.findByCreateDate", query = "SELECT a FROM email_notification a WHERE a.createDate = ?1"), 
    @NamedQuery(name = "email_notification.findByLastModiiedUser", query = "SELECT a FROM email_notification a WHERE a.lastModifiedUser = ?1"), 
    @NamedQuery(name = "email_notification.findByLastModifiedDate", query = "SELECT a FROM email_notification a WHERE a.lastModifiedDate = ?1")})
public class EmailNotification extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "sent_date")
    private String sentDate;
    @Column(name = "template")
    private String template;
    
    
    public EmailNotification() {
    }

    public EmailNotification(Long id) {
        this.id = id;
    }

    public EmailNotification(Long id, String emailId, String sentDate, String template) {
        this.id = id;
        this.emailId = emailId;
        this.sentDate = sentDate;
        this.template = template;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
      
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof  EmailNotification)) {
            return false;
        }
         EmailNotification other = ( EmailNotification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emailId+" "+sentDate+" "+template ;
    }

}
