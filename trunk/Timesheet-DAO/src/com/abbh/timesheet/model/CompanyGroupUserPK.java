/*
 * CompanyGroupUserPK.java
 * 
 * Created on Aug 18, 2007, 8:32:14 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author shannan
 */
@Embeddable
public class CompanyGroupUserPK implements Serializable {
    @Column(name = "company", nullable = false)
    private int company;
    @Column(name = "group", nullable = false)
    private String group;
    @Column(name = "user", nullable = false)
    private String user;

    public CompanyGroupUserPK() {
    }

    public CompanyGroupUserPK(int company, String group, String user) {
        this.company = company;
        this.group = group;
        this.user = user;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) company;
        hash += (group != null ? group.hashCode() : 0);
        hash += (user != null ? user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof CompanyGroupUserPK)) {
            return false;
        }
        CompanyGroupUserPK other = (CompanyGroupUserPK) object;
        if (this.company != other.company) {
            return false;
        }
        if (this.group != other.group && (this.group == null || !this.group.equals(other.group))) {
            return false;
        }
        if (this.user != other.user && (this.user == null || !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.timesheet.model.CompanyGroupUserPK[company=" + company + ", group=" + group + ", user=" + user + "]";
    }

}
