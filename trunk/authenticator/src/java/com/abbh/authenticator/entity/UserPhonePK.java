/*
 * UserPhonePK.java
 * 
 * Created on Jul 1, 2007, 7:11:58 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author intesar
 */
@Embeddable
public class UserPhonePK implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "type", nullable = false)
    private String type;

    public UserPhonePK() {
    }

    public UserPhonePK(String username, String type) {
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPhonePK)) {
            return false;
        }
        UserPhonePK other = (UserPhonePK) object;
        if (this.username != other.username && (this.username == null || !this.username.equals(other.username))) {
            return false;
        }
        if (this.type != other.type && (this.type == null || !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserPhonePK[username=" + username + ", type=" + type + "]";
    }

}
