/*
 * CompanyGroupUser.java
 * 
 * Created on Aug 18, 2007, 8:32:14 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shannan
 */
@Entity
@Table(name = "company_group_user")
@NamedQueries({@NamedQuery(name = "CompanyGroupUser.findByCompany", query = "SELECT c FROM CompanyGroupUser c WHERE c.companyGroupUserPK.company = :company"), @NamedQuery(name = "CompanyGroupUser.findByGroup", query = "SELECT c FROM CompanyGroupUser c WHERE c.companyGroupUserPK.group = :group"), @NamedQuery(name = "CompanyGroupUser.findByUser", query = "SELECT c FROM CompanyGroupUser c WHERE c.companyGroupUserPK.user = :user"), @NamedQuery(name = "CompanyGroupUser.findByStatus", query = "SELECT c FROM CompanyGroupUser c WHERE c.status = :status"), @NamedQuery(name = "CompanyGroupUser.findByCreateDate", query = "SELECT c FROM CompanyGroupUser c WHERE c.createDate = :createDate"), @NamedQuery(name = "CompanyGroupUser.findByCreateUser", query = "SELECT c FROM CompanyGroupUser c WHERE c.createUser = :createUser"), @NamedQuery(name = "CompanyGroupUser.findByLastModifiedUser", query = "SELECT c FROM CompanyGroupUser c WHERE c.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "CompanyGroupUser.findByLastModifiedDate", query = "SELECT c FROM CompanyGroupUser c WHERE c.lastModifiedDate = :lastModifiedDate")})
public class CompanyGroupUser implements Serializable {
    @EmbeddedId
    protected CompanyGroupUserPK companyGroupUserPK;
    @Column(name = "status")
    private String status;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "create_user")
    private String createUser;
    @Column(name = "last_modified_user")
    private String lastModifiedUser;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
    @JoinColumns({@JoinColumn(name = "group", referencedColumnName = "name", insertable = false, updatable = false), @JoinColumn(name = "company", referencedColumnName = "company", insertable = false, updatable = false)})
    @ManyToOne
    private CompanyGroup companyGroup;
    @JoinColumn(name = "user", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne
    private Users users;

    public CompanyGroupUser() {
    }

    public CompanyGroupUser(CompanyGroupUserPK companyGroupUserPK) {
        this.companyGroupUserPK = companyGroupUserPK;
    }

    public CompanyGroupUser(int company, String group, String user) {
        this.companyGroupUserPK = new CompanyGroupUserPK(company, group, user);
    }

    public CompanyGroupUserPK getCompanyGroupUserPK() {
        return companyGroupUserPK;
    }

    public void setCompanyGroupUserPK(CompanyGroupUserPK companyGroupUserPK) {
        this.companyGroupUserPK = companyGroupUserPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public CompanyGroup getCompanyGroup() {
        return companyGroup;
    }

    public void setCompanyGroup(CompanyGroup companyGroup) {
        this.companyGroup = companyGroup;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyGroupUserPK != null ? companyGroupUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof CompanyGroupUser)) {
            return false;
        }
        CompanyGroupUser other = (CompanyGroupUser) object;
        if (this.companyGroupUserPK != other.companyGroupUserPK && (this.companyGroupUserPK == null || !this.companyGroupUserPK.equals(other.companyGroupUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.timesheet.model.CompanyGroupUser[companyGroupUserPK=" + companyGroupUserPK + "]";
    }

}
