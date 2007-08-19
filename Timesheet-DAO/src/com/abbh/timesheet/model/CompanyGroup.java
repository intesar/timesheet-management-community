/*
 * CompanyGroup.java
 * 
 * Created on Aug 18, 2007, 8:32:13 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author shannan
 */
@Entity
@Table(name = "company_group")
@NamedQueries({@NamedQuery(name = "CompanyGroup.findByName", query = "SELECT c FROM CompanyGroup c WHERE c.companyGroupPK.name = :name"), @NamedQuery(name = "CompanyGroup.findByCompany", query = "SELECT c FROM CompanyGroup c WHERE c.companyGroupPK.company = :company"), @NamedQuery(name = "CompanyGroup.findByManager", query = "SELECT c FROM CompanyGroup c WHERE c.manager = :manager"), @NamedQuery(name = "CompanyGroup.findByDescription", query = "SELECT c FROM CompanyGroup c WHERE c.description = :description"), @NamedQuery(name = "CompanyGroup.findByIsEnabled", query = "SELECT c FROM CompanyGroup c WHERE c.isEnabled = :isEnabled")})
public class CompanyGroup implements Serializable {
    @EmbeddedId
    protected CompanyGroupPK companyGroupPK;
    @Column(name = "manager")
    private String manager;
    @Column(name = "description")
    private String description;
    @Column(name = "is_enabled")
    private Boolean isEnabled;
    @JoinColumn(name = "company", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Company company1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyGroup")
    private Collection<CompanyGroupUser> companyGroupUserCollection;

    public CompanyGroup() {
    }

    public CompanyGroup(CompanyGroupPK companyGroupPK) {
        this.companyGroupPK = companyGroupPK;
    }

    public CompanyGroup(String name, int company) {
        this.companyGroupPK = new CompanyGroupPK(name, company);
    }

    public CompanyGroupPK getCompanyGroupPK() {
        return companyGroupPK;
    }

    public void setCompanyGroupPK(CompanyGroupPK companyGroupPK) {
        this.companyGroupPK = companyGroupPK;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Company getCompany1() {
        return company1;
    }

    public void setCompany1(Company company1) {
        this.company1 = company1;
    }

    public Collection<CompanyGroupUser> getCompanyGroupUserCollection() {
        return companyGroupUserCollection;
    }

    public void setCompanyGroupUserCollection(Collection<CompanyGroupUser> companyGroupUserCollection) {
        this.companyGroupUserCollection = companyGroupUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyGroupPK != null ? companyGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof CompanyGroup)) {
            return false;
        }
        CompanyGroup other = (CompanyGroup) object;
        if (this.companyGroupPK != other.companyGroupPK && (this.companyGroupPK == null || !this.companyGroupPK.equals(other.companyGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.timesheet.model.CompanyGroup[companyGroupPK=" + companyGroupPK + "]";
    }

}
