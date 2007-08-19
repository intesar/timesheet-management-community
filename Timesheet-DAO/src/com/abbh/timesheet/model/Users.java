/*
 * Users.java
 * 
 * Created on Aug 18, 2007, 8:32:12 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shannan
 */
@Entity
@Table(name = "users")
@NamedQueries({@NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"), @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"), @NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname = :firstname"), @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname"), @NamedQuery(name = "Users.findByMi", query = "SELECT u FROM Users u WHERE u.mi = :mi"), @NamedQuery(name = "Users.findByCompany", query = "SELECT u FROM Users u WHERE u.company = :company"), @NamedQuery(name = "Users.findByTitle", query = "SELECT u FROM Users u WHERE u.title = :title"), @NamedQuery(name = "Users.findByDescription", query = "SELECT u FROM Users u WHERE u.description = :description"), @NamedQuery(name = "Users.findByCreateDate", query = "SELECT u FROM Users u WHERE u.createDate = :createDate"), @NamedQuery(name = "Users.findByCreatedUser", query = "SELECT u FROM Users u WHERE u.createdUser = :createdUser"), @NamedQuery(name = "Users.findByLastModifiedUser", query = "SELECT u FROM Users u WHERE u.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Users.findByLastModifiedDate", query = "SELECT u FROM Users u WHERE u.lastModifiedDate = :lastModifiedDate")})
public class Users implements Serializable {
    @Column(name = "id")
    private Integer id;
    @Id
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "mi")
    private String mi;
    @Column(name = "company")
    private String company;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "created_user")
    private String createdUser;
    @Column(name = "last_modified_user")
    private String lastModifiedUser;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
    @JoinTable(name = "company_admin", joinColumns = {@JoinColumn(name = "user", referencedColumnName = "email")}, inverseJoinColumns = {@JoinColumn(name = "company", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Company> companyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<CompanyGroupUser> companyGroupUserCollection;

    public Users() {
    }

    public Users(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
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

    public Collection<Company> getCompanyCollection() {
        return companyCollection;
    }

    public void setCompanyCollection(Collection<Company> companyCollection) {
        this.companyCollection = companyCollection;
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
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if (this.email != other.email && (this.email == null || !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.timesheet.model.Users[email=" + email + "]";
    }

}
