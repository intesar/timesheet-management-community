/*
 * UserCommunity.java
 * 
 * Created on Jul 1, 2007, 7:11:54 PM
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
@Table(name = "user_community")
@NamedQueries({@NamedQuery(name = "UserCommunity.findByUsername", query = "SELECT u FROM UserCommunity u WHERE u.userCommunityPK.username = :username"), @NamedQuery(name = "UserCommunity.findByCommunityName", query = "SELECT u FROM UserCommunity u WHERE u.userCommunityPK.communityName = :communityName"), @NamedQuery(name = "UserCommunity.findByEnabled", query = "SELECT u FROM UserCommunity u WHERE u.enabled = :enabled"), @NamedQuery(name = "UserCommunity.findByCreationDate", query = "SELECT u FROM UserCommunity u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserCommunity.findByLastModifiedDate", query = "SELECT u FROM UserCommunity u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserCommunity.findByExpirationDate", query = "SELECT u FROM UserCommunity u WHERE u.expirationDate = :expirationDate"), @NamedQuery(name = "UserCommunity.findByCreationUser", query = "SELECT u FROM UserCommunity u WHERE u.creationUser = :creationUser"), @NamedQuery(name = "UserCommunity.findByLastModifiedUser", query = "SELECT u FROM UserCommunity u WHERE u.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "UserCommunity.findByIsDeleted", query = "SELECT u FROM UserCommunity u WHERE u.isDeleted = :isDeleted"), @NamedQuery(name = "UserCommunity.findById", query = "SELECT u FROM UserCommunity u WHERE u.id = :id")})
public class UserCommunity implements Serializable {

    @EmbeddedId
    protected UserCommunityPK userCommunityPK;

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

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "community_name", referencedColumnName = "community_name", insertable = false, updatable = false)
    @ManyToOne
    private Community community;

    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne
    private Users users;

    public UserCommunity() {
    }

    public UserCommunity(UserCommunityPK userCommunityPK) {
        this.userCommunityPK = userCommunityPK;
    }

    public UserCommunity(String username, String communityName) {
        this.userCommunityPK = new UserCommunityPK(username, communityName);
    }

    public UserCommunityPK getUserCommunityPK() {
        return userCommunityPK;
    }

    public void setUserCommunityPK(UserCommunityPK userCommunityPK) {
        this.userCommunityPK = userCommunityPK;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
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
        hash += (userCommunityPK != null ? userCommunityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCommunity)) {
            return false;
        }
        UserCommunity other = (UserCommunity) object;
        if (this.userCommunityPK != other.userCommunityPK && (this.userCommunityPK == null || !this.userCommunityPK.equals(other.userCommunityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserCommunity[userCommunityPK=" + userCommunityPK + "]";
    }

}
