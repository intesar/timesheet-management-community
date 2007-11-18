/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = ?1"), 
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = ?1"), 
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = ?1"), 
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = ?1"), 
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = ?1"), 
    @NamedQuery(name = "Users.findByEnabled", query = "SELECT u FROM Users u WHERE u.enabled = ?1"), 
    @NamedQuery(name = "Users.findByCreateUser", query = "SELECT u FROM Users u WHERE u.createUser = ?1"), 
    @NamedQuery(name = "Users.findByCreateDate", query = "SELECT u FROM Users u WHERE u.createDate = ?1"), 
    @NamedQuery(name = "Users.findByLastModifiedDate", query = "SELECT u FROM Users u WHERE u.lastModifiedDate = ?1"),
    @NamedQuery(name = "Users.findByLastModifiedUser", query = "SELECT u FROM Users u WHERE u.lastModifiedUser = ?1")})

public class Users extends BaseModel {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "enabled")
    private Boolean enabled;
    
    public Users() {
    }

    public Users(Long id) {
        this.id = id;
    }

    public Users(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firstName+" "+ lastName+ " "+username;
    }

}
