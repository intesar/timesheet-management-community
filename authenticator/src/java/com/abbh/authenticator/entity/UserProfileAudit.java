/*
 * UserProfileAudit.java
 * 
 * Created on Jul 4, 2007, 2:05:02 PM
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
import javax.persistence.Lob;
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
@Table(name = "user_profile_audit")
@NamedQueries({@NamedQuery(name = "UserProfileAudit.findByUsername", query = "SELECT u FROM UserProfileAudit u WHERE u.username = :username"), @NamedQuery(name = "UserProfileAudit.findByFirstName", query = "SELECT u FROM UserProfileAudit u WHERE u.firstName = :firstName"), @NamedQuery(name = "UserProfileAudit.findByLastName", query = "SELECT u FROM UserProfileAudit u WHERE u.lastName = :lastName"), @NamedQuery(name = "UserProfileAudit.findByMiddleName", query = "SELECT u FROM UserProfileAudit u WHERE u.middleName = :middleName"), @NamedQuery(name = "UserProfileAudit.findByTitle", query = "SELECT u FROM UserProfileAudit u WHERE u.title = :title"), @NamedQuery(name = "UserProfileAudit.findByCompany", query = "SELECT u FROM UserProfileAudit u WHERE u.company = :company"), @NamedQuery(name = "UserProfileAudit.findByCreationDate", query = "SELECT u FROM UserProfileAudit u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserProfileAudit.findByLastModifiedDate", query = "SELECT u FROM UserProfileAudit u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserProfileAudit.findByAuditUser", query = "SELECT u FROM UserProfileAudit u WHERE u.auditUser = :auditUser"), @NamedQuery(name = "UserProfileAudit.findByAuditDate", query = "SELECT u FROM UserProfileAudit u WHERE u.auditDate = :auditDate"), @NamedQuery(name = "UserProfileAudit.findById", query = "SELECT u FROM UserProfileAudit u WHERE u.id = :id")})
public class UserProfileAudit implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "title")
    private String title;

    @Column(name = "company")
    private String company;

    @Lob
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

    public UserProfileAudit() {
    }

    public UserProfileAudit(Integer id) {
        this.id = id;
    }

    public UserProfileAudit(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
        if (!(object instanceof UserProfileAudit)) {
            return false;
        }
        UserProfileAudit other = (UserProfileAudit) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserProfileAudit[id=" + id + "]";
    }

}
