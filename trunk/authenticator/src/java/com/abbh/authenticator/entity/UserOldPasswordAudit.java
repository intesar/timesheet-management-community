/*
 * UserOldPasswordAudit.java
 * 
 * Created on Jul 4, 2007, 2:04:49 PM
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
@Table(name = "user_old_password_audit")
@NamedQueries({@NamedQuery(name = "UserOldPasswordAudit.findByUsername", query = "SELECT u FROM UserOldPasswordAudit u WHERE u.username = :username"), @NamedQuery(name = "UserOldPasswordAudit.findByPassword", query = "SELECT u FROM UserOldPasswordAudit u WHERE u.password = :password"), @NamedQuery(name = "UserOldPasswordAudit.findByPasswordStrength", query = "SELECT u FROM UserOldPasswordAudit u WHERE u.passwordStrength = :passwordStrength"), @NamedQuery(name = "UserOldPasswordAudit.findByCreationDate", query = "SELECT u FROM UserOldPasswordAudit u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserOldPasswordAudit.findByLastModifiedDate", query = "SELECT u FROM UserOldPasswordAudit u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserOldPasswordAudit.findByAuditDate", query = "SELECT u FROM UserOldPasswordAudit u WHERE u.auditDate = :auditDate"), @NamedQuery(name = "UserOldPasswordAudit.findById", query = "SELECT u FROM UserOldPasswordAudit u WHERE u.id = :id")})
public class UserOldPasswordAudit implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "password_strength")
    private String passwordStrength;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "audit_date")
    @Temporal(TemporalType.DATE)
    private Date auditDate;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    public UserOldPasswordAudit() {
    }

    public UserOldPasswordAudit(Integer id) {
        this.id = id;
    }

    public UserOldPasswordAudit(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordStrength() {
        return passwordStrength;
    }

    public void setPasswordStrength(String passwordStrength) {
        this.passwordStrength = passwordStrength;
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
        if (!(object instanceof UserOldPasswordAudit)) {
            return false;
        }
        UserOldPasswordAudit other = (UserOldPasswordAudit) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserOldPasswordAudit[id=" + id + "]";
    }

}
