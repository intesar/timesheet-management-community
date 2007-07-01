/*
 * UserCommunityPK.java
 * 
 * Created on Jul 1, 2007, 5:40:36 PM
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
public class UserCommunityPK implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "community", nullable = false)
    private String community;

    public UserCommunityPK() {
    }

    public UserCommunityPK(String username, String community) {
        this.username = username;
        this.community = community;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (community != null ? community.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCommunityPK)) {
            return false;
        }
        UserCommunityPK other = (UserCommunityPK) object;
        if (this.username != other.username && (this.username == null || !this.username.equals(other.username))) {
            return false;
        }
        if (this.community != other.community && (this.community == null || !this.community.equals(other.community))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserCommunityPK[username=" + username + ", community=" + community + "]";
    }

}
