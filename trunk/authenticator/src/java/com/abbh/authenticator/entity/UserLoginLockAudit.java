/*
 * UserLoginLockAudit.java
 * 
 * Created on Jul 1, 2007, 7:11:53 PM
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
@Table(name = "user_login_lock_audit")
@NamedQueries({@NamedQuery(name = "UserLoginLockAudit.findByUsername", query = "SELECT u FROM UserLoginLockAudit u WHERE u.username = :username"), @NamedQuery(name = "UserLoginLockAudit.findBySummary", query = "SELECT u FROM UserLoginLockAudit u WHERE u.summary = :summary"), @NamedQuery(name = "UserLoginLockAudit.findByCreationDate", query = "SELECT u FROM UserLoginLockAudit u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserLoginLockAudit.findByLastModifiedDate", query = "SELECT u FROM UserLoginLockAudit u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserLoginLockAudit.findByAuditUser", query = "SELECT u FROM UserLoginLockAudit u WHERE u.auditUser = :auditUser"), @NamedQuery(name = "UserLoginLockAudit.findByAuditDate", query = "SELECT u FROM UserLoginLockAudit u WHERE u.auditDate = :auditDate"), @NamedQuery(name = "UserLoginLockAudit.findById", query = "SELECT u FROM UserLoginLockAudit u WHERE u.id = :id")})
public class UserLoginLockAudit implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "summary")
    private String summary;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "audit_user")
    private String auditUser;

    @Column(name = "audit_date")
    @Temporal(TemporalType.DATE)
    private Date auditDate;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    public UserLoginLockAudit() {
    }

    public UserLoginLockAudit(Integer id) {
        this.id = id;
    }

    public UserLoginLockAudit(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof UserLoginLockAudit)) {
            return false;
        }
        UserLoginLockAudit other = (UserLoginLockAudit) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserLoginLockAudit[id=" + id + "]";
    }

}
