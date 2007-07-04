/*
 * UserRolesAudit.java
 * 
 * Created on Jul 4, 2007, 2:05:18 PM
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
@Table(name = "user_roles_audit")
@NamedQueries({@NamedQuery(name = "UserRolesAudit.findByUsername", query = "SELECT u FROM UserRolesAudit u WHERE u.username = :username"), @NamedQuery(name = "UserRolesAudit.findByRole", query = "SELECT u FROM UserRolesAudit u WHERE u.role = :role"), @NamedQuery(name = "UserRolesAudit.findByCreationDate", query = "SELECT u FROM UserRolesAudit u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserRolesAudit.findByLastModifiedDate", query = "SELECT u FROM UserRolesAudit u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserRolesAudit.findByAuditUser", query = "SELECT u FROM UserRolesAudit u WHERE u.auditUser = :auditUser"), @NamedQuery(name = "UserRolesAudit.findByAuditDate", query = "SELECT u FROM UserRolesAudit u WHERE u.auditDate = :auditDate"), @NamedQuery(name = "UserRolesAudit.findById", query = "SELECT u FROM UserRolesAudit u WHERE u.id = :id")})
public class UserRolesAudit implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "role")
    private String role;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "audit_user")
    private String auditUser;

    @Column(name = "audit_date")
    private String auditDate;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    public UserRolesAudit() {
    }

    public UserRolesAudit(Integer id) {
        this.id = id;
    }

    public UserRolesAudit(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        if (!(object instanceof UserRolesAudit)) {
            return false;
        }
        UserRolesAudit other = (UserRolesAudit) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserRolesAudit[id=" + id + "]";
    }

}
