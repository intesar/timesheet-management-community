/*
 * UserPhone.java
 * 
 * Created on Jul 1, 2007, 7:11:58 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@NamedQueries({@NamedQuery(name = "UserPhone.findById", query = "SELECT u FROM UserPhone u WHERE u.id = :id"), @NamedQuery(name = "UserPhone.findByUsername", query = "SELECT u FROM UserPhone u WHERE u.userPhonePK.username = :username"), @NamedQuery(name = "UserPhone.findByType", query = "SELECT u FROM UserPhone u WHERE u.userPhonePK.type = :type"), @NamedQuery(name = "UserPhone.findByPhoneNumber", query = "SELECT u FROM UserPhone u WHERE u.phoneNumber = :phoneNumber"), @NamedQuery(name = "UserPhone.findByIsPublic", query = "SELECT u FROM UserPhone u WHERE u.isPublic = :isPublic"), @NamedQuery(name = "UserPhone.findByCreationDate", query = "SELECT u FROM UserPhone u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserPhone.findByLastModifiedDate", query = "SELECT u FROM UserPhone u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserPhone.findByIsDeleted", query = "SELECT u FROM UserPhone u WHERE u.isDeleted = :isDeleted")})
public class UserPhone implements Serializable {

    @EmbeddedId
    protected UserPhonePK userPhonePK;

    @Column(name = "id")
    private Integer id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne
    private Users users;

    public UserPhone() {
    }

    public UserPhone(UserPhonePK userPhonePK) {
        this.userPhonePK = userPhonePK;
    }

    public UserPhone(String username, String type) {
        this.userPhonePK = new UserPhonePK(username, type);
    }

    public UserPhonePK getUserPhonePK() {
        return userPhonePK;
    }

    public void setUserPhonePK(UserPhonePK userPhonePK) {
        this.userPhonePK = userPhonePK;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userPhonePK != null ? userPhonePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPhone)) {
            return false;
        }
        UserPhone other = (UserPhone) object;
        if (this.userPhonePK != other.userPhonePK && (this.userPhonePK == null || !this.userPhonePK.equals(other.userPhonePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserPhone[userPhonePK=" + userPhonePK + "]";
    }

}
