/*
 * UserCommunityPK.java
 * 
 * Created on Jul 1, 2007, 7:11:54 PM
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

    @Column(name = "community_name", nullable = false)
    private String communityName;

    public UserCommunityPK() {
    }

    public UserCommunityPK(String username, String communityName) {
        this.username = username;
        this.communityName = communityName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (communityName != null ? communityName.hashCode() : 0);
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
        if (this.communityName != other.communityName && (this.communityName == null || !this.communityName.equals(other.communityName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserCommunityPK[username=" + username + ", communityName=" + communityName + "]";
    }

}
