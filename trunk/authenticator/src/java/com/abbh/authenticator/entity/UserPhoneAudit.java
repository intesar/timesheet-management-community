/*
 * UserPhoneAudit.java
 * 
 * Created on Jul 1, 2007, 7:11:55 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "user_phone_audit")
@NamedQueries({@NamedQuery(name = "UserPhoneAudit.findById", query = "SELECT u FROM UserPhoneAudit u WHERE u.id = :id"), @NamedQuery(name = "UserPhoneAudit.findByUsername", query = "SELECT u FROM UserPhoneAudit u WHERE u.username = :username"), @NamedQuery(name = "UserPhoneAudit.findByType", query = "SELECT u FROM UserPhoneAudit u WHERE u.type = :type"), @NamedQuery(name = "UserPhoneAudit.findByPhoneNumber", query = "SELECT u FROM UserPhoneAudit u WHERE u.phoneNumber = :phoneNumber"), @NamedQuery(name = "UserPhoneAudit.findByIsPublic", query = "SELECT u FROM UserPhoneAudit u WHERE u.isPublic = :isPublic"), @NamedQuery(name = "UserPhoneAudit.findByCreationDate", query = "SELECT u FROM UserPhoneAudit u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserPhoneAudit.findByLastModifiedDate", query = "SELECT u FROM UserPhoneAudit u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserPhoneAudit.findByAuditUser", query = "SELECT u FROM UserPhoneAudit u WHERE u.auditUser = :auditUser"), @NamedQuery(name = "UserPhoneAudit.findByAuditDate", query = "SELECT u FROM UserPhoneAudit u WHERE u.auditDate = :auditDate")})
public class UserPhoneAudit implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "type")
    private String type;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_public")
    private String isPublic;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    private String lastModifiedDate;

    @Column(name = "audit_user")
    private String auditUser;

    @Column(name = "audit_date")
    @Temporal(TemporalType.DATE)
    private Date auditDate;

    public UserPhoneAudit() {
    }

    public UserPhoneAudit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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
        if (!(object instanceof UserPhoneAudit)) {
            return false;
        }
        UserPhoneAudit other = (UserPhoneAudit) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserPhoneAudit[id=" + id + "]";
    }

}
