/*
 * Role.java
 * 
 * Created on Jul 1, 2007, 5:40:36 PM
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "role")
@NamedQueries({@NamedQuery(name = "Role.findByRole", query = "SELECT r FROM Role r WHERE r.role = :role"), @NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description"), @NamedQuery(name = "Role.findByCreationDate", query = "SELECT r FROM Role r WHERE r.creationDate = :creationDate"), @NamedQuery(name = "Role.findByLastModifiedDate", query = "SELECT r FROM Role r WHERE r.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Role.findByIsDeleted", query = "SELECT r FROM Role r WHERE r.isDeleted = :isDeleted")})
public class Role implements Serializable {

    @Id
    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "description")
    private String description;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role1")
    private Collection<UserRoles> userRolesCollection;

    @JoinColumn(name = "community", referencedColumnName = "name")
    @ManyToOne
    private Community community;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Collection<UserRoles> getUserRolesCollection() {
        return userRolesCollection;
    }

    public void setUserRolesCollection(Collection<UserRoles> userRolesCollection) {
        this.userRolesCollection = userRolesCollection;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (role != null ? role.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if (this.role != other.role && (this.role == null || !this.role.equals(other.role))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.Role[role=" + role + "]";
    }

}
