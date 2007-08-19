/*
 * CompanyGroupPK.java
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
public class CompanyGroupPK implements Serializable {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "company", nullable = false)
    private int company;

    public CompanyGroupPK() {
    }

    public CompanyGroupPK(String name, int company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        hash += (int) company;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof CompanyGroupPK)) {
            return false;
        }
        CompanyGroupPK other = (CompanyGroupPK) object;
        if (this.name != other.name && (this.name == null || !this.name.equals(other.name))) {
            return false;
        }
        if (this.company != other.company) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.timesheet.model.CompanyGroupPK[name=" + name + ", company=" + company + "]";
    }

}
