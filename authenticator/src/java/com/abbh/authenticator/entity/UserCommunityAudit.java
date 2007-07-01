/*
 * UserCommunityAudit.java
 * 
 * Created on Jul 1, 2007, 7:11:48 PM
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
@Table(name = "user_community_audit")
@NamedQueries({@NamedQuery(name = "UserCommunityAudit.findByUsername", query = "SELECT u FROM UserCommunityAudit u WHERE u.username = :username"), @NamedQuery(name = "UserCommunityAudit.findByCompany", query = "SELECT u FROM UserCommunityAudit u WHERE u.company = :company"), @NamedQuery(name = "UserCommunityAudit.findByEnabled", query = "SELECT u FROM UserCommunityAudit u WHERE u.enabled = :enabled"), @NamedQuery(name = "UserCommunityAudit.findByCreationDate", query = "SELECT u FROM UserCommunityAudit u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserCommunityAudit.findByLastModifiedDate", query = "SELECT u FROM UserCommunityAudit u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserCommunityAudit.findByExpirationDate", query = "SELECT u FROM UserCommunityAudit u WHERE u.expirationDate = :expirationDate"), @NamedQuery(name = "UserCommunityAudit.findByCreationUser", query = "SELECT u FROM UserCommunityAudit u WHERE u.creationUser = :creationUser"), @NamedQuery(name = "UserCommunityAudit.findByLastModifiedUser", query = "SELECT u FROM UserCommunityAudit u WHERE u.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "UserCommunityAudit.findByAuditUser", query = "SELECT u FROM UserCommunityAudit u WHERE u.auditUser = :auditUser"), @NamedQuery(name = "UserCommunityAudit.findByAuditDate", query = "SELECT u FROM UserCommunityAudit u WHERE u.auditDate = :auditDate"), @NamedQuery(name = "UserCommunityAudit.findById", query = "SELECT u FROM UserCommunityAudit u WHERE u.id = :id")})
public class UserCommunityAudit implements Serializable {

    @Column(name = "username")
    private String username;

    @Column(name = " company")
    private String company;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @Column(name = "creation_user")
    private String creationUser;

    @Column(name = "last_modified_user")
    private String lastModifiedUser;

    @Column(name = "audit_user")
    private String auditUser;

    @Column(name = "audit_date")
    private String auditDate;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    public UserCommunityAudit() {
    }

    public UserCommunityAudit(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public String getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate) {
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
        if (!(object instanceof UserCommunityAudit)) {
            return false;
        }
        UserCommunityAudit other = (UserCommunityAudit) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserCommunityAudit[id=" + id + "]";
    }

}
