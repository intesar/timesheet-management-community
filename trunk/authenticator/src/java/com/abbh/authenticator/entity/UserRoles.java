/*
 * UserRoles.java
 * 
 * Created on Jul 1, 2007, 7:11:49 PM
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
@Table(name = "user_roles")
@NamedQueries({@NamedQuery(name = "UserRoles.findByUsername", query = "SELECT u FROM UserRoles u WHERE u.userRolesPK.username = :username"), @NamedQuery(name = "UserRoles.findByRole", query = "SELECT u FROM UserRoles u WHERE u.userRolesPK.role = :role"), @NamedQuery(name = "UserRoles.findByCreationDate", query = "SELECT u FROM UserRoles u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserRoles.findByLastModifiedDate", query = "SELECT u FROM UserRoles u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserRoles.findByIsDeleted", query = "SELECT u FROM UserRoles u WHERE u.isDeleted = :isDeleted")})
public class UserRoles implements Serializable {

    @EmbeddedId
    protected UserRolesPK userRolesPK;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @JoinColumn(name = "username", referencedColumnName = " username", insertable = false, updatable = false)
    @ManyToOne
    private Users users;

    @JoinColumn(name = "role", referencedColumnName = "role", insertable = false, updatable = false)
    @ManyToOne
    private Role role1;

    public UserRoles() {
    }

    public UserRoles(UserRolesPK userRolesPK) {
        this.userRolesPK = userRolesPK;
    }

    public UserRoles(String username, String role) {
        this.userRolesPK = new UserRolesPK(username, role);
    }

    public UserRolesPK getUserRolesPK() {
        return userRolesPK;
    }

    public void setUserRolesPK(UserRolesPK userRolesPK) {
        this.userRolesPK = userRolesPK;
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

    public Role getRole1() {
        return role1;
    }

    public void setRole1(Role role1) {
        this.role1 = role1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRolesPK != null ? userRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoles)) {
            return false;
        }
        UserRoles other = (UserRoles) object;
        if (this.userRolesPK != other.userRolesPK && (this.userRolesPK == null || !this.userRolesPK.equals(other.userRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserRoles[userRolesPK=" + userRolesPK + "]";
    }

}
