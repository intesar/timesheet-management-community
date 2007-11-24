/*
 * EmailTemplate.java
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
@Table(name = "email_template")

@NamedQueries({
    @NamedQuery(name = "email_template.findById", query = "SELECT a FROM email_template a WHERE a.id = ?1"), 
    @NamedQuery(name = "email_template.findByName", query = "SELECT a FROM email_template a WHERE a.name = ?1"), 
    @NamedQuery(name = "email_template.findByTemplate", query = "SELECT a FROM email_template a WHERE a.template = ?1"), 
    @NamedQuery(name = "email_template.findByCreateUser", query = "SELECT a FROM email_template a WHERE a.createUser = ?1"),
    @NamedQuery(name = "email_template.findByCreateDate", query = "SELECT a FROM email_template a WHERE a.createDate = ?1"), 
    @NamedQuery(name = "email_template.findByLastModiiedUser", query = "SELECT a FROM email_template a WHERE a.lastModifiedUser = ?1"), 
    @NamedQuery(name = "email_template.findByLastModifiedDate", query = "SELECT a FROM email_template a WHERE a.lastModifiedDate = ?1")})
/**
 *
 * @author ABDUL RAHMAN
 */
public class EmailTemplate extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
   
    @Column(name = "name")
    private String name;
    @Column(name = "template")
    private String template;
    
    
    
    public EmailTemplate() {
    }

    public EmailTemplate(Long id) {
        this.id = id;
    }

    public EmailTemplate(Long id, String name, String template) {
        this.id = id;
        this.name = name;
        this.template = template;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof EmailTemplate)) {
            return false;
        }
        EmailTemplate other = (EmailTemplate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name+" "+ template;
    }

    
    
}
