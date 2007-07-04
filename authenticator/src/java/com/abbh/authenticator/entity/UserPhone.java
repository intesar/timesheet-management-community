/*
 * UserPhone.java
 * 
 * Created on Jul 4, 2007, 2:05:12 PM
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "user_phone")
@NamedQueries({@NamedQuery(name = "UserPhone.findById", query = "SELECT u FROM UserPhone u WHERE u.id = :id"), @NamedQuery(name = "UserPhone.findByPhoneType", query = "SELECT u FROM UserPhone u WHERE u.phoneType = :phoneType"), @NamedQuery(name = "UserPhone.findByPhoneNumber", query = "SELECT u FROM UserPhone u WHERE u.phoneNumber = :phoneNumber"), @NamedQuery(name = "UserPhone.findByIsPublic", query = "SELECT u FROM UserPhone u WHERE u.isPublic = :isPublic"), @NamedQuery(name = "UserPhone.findByIsDeleted", query = "SELECT u FROM UserPhone u WHERE u.isDeleted = :isDeleted"), @NamedQuery(name = "UserPhone.findByCreationDate", query = "SELECT u FROM UserPhone u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserPhone.findByCreatedBy", query = "SELECT u FROM UserPhone u WHERE u.createdBy = :createdBy"), @NamedQuery(name = "UserPhone.findByLastModifiedDate", query = "SELECT u FROM UserPhone u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserPhone.findByLastModifiedBy", query = "SELECT u FROM UserPhone u WHERE u.lastModifiedBy = :lastModifiedBy")})
public class UserPhone implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "PHONE_TYPE", nullable = false)
    private String phoneType;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "IS_PUBLIC")
    private Short isPublic;

    @Column(name = "IS_DELETED")
    private Short isDeleted;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "LAST_MODIFIED_BY", nullable = false)
    private String lastModifiedBy;

    @JoinColumn(name = "USERNAME", referencedColumnName = "username")
    @ManyToOne
    private Users username;

    public UserPhone() {
    }

    public UserPhone(Integer id) {
        this.id = id;
    }

    public UserPhone(Integer id, String phoneType, String phoneNumber, String createdBy, Date lastModifiedDate, String lastModifiedBy) {
        this.id = id;
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
        this.createdBy = createdBy;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Short getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Short isPublic) {
        this.isPublic = isPublic;
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
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
        if (!(object instanceof UserPhone)) {
            return false;
        }
        UserPhone other = (UserPhone) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserPhone[id=" + id + "]";
    }

}
