/*
 * Community.java
 * 
 * Created on Jul 4, 2007, 2:04:59 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "community")
@NamedQueries({@NamedQuery(name = "Community.findByCommunityName", query = "SELECT c FROM Community c WHERE c.communityName = :communityName"), @NamedQuery(name = "Community.findByDescription", query = "SELECT c FROM Community c WHERE c.description = :description"), @NamedQuery(name = "Community.findByCreationDate", query = "SELECT c FROM Community c WHERE c.creationDate = :creationDate"), @NamedQuery(name = "Community.findByLastModifiedDate", query = "SELECT c FROM Community c WHERE c.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Community.findByCreateUser", query = "SELECT c FROM Community c WHERE c.createUser = :createUser")})
public class Community implements Serializable {

    @Id
    @Column(name = "community_name", nullable = false)
    private String communityName;

    @Column(name = "description")
    private String description;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "create_user")
    private String createUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "community")
    private Collection<UserCommunity> userCommunityCollection;

    @OneToMany(mappedBy = "communityName")
    private Collection<Role> roleCollection;

    public Community() {
    }

    public Community(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Collection<UserCommunity> getUserCommunityCollection() {
        return userCommunityCollection;
    }

    public void setUserCommunityCollection(Collection<UserCommunity> userCommunityCollection) {
        this.userCommunityCollection = userCommunityCollection;
    }

    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (communityName != null ? communityName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Community)) {
            return false;
        }
        Community other = (Community) object;
        if (this.communityName != other.communityName && (this.communityName == null || !this.communityName.equals(other.communityName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.Community[communityName=" + communityName + "]";
    }

}
