/*
 * Company.java
 * 
 * Created on Aug 18, 2007, 8:32:13 PM
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
@Table(name = "company")
@NamedQueries({@NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id"), @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"), @NamedQuery(name = "Company.findByType", query = "SELECT c FROM Company c WHERE c.type = :type"), @NamedQuery(name = "Company.findByCity", query = "SELECT c FROM Company c WHERE c.city = :city"), @NamedQuery(name = "Company.findByDescription", query = "SELECT c FROM Company c WHERE c.description = :description"), @NamedQuery(name = "Company.findByOwner", query = "SELECT c FROM Company c WHERE c.owner = :owner"), @NamedQuery(name = "Company.findByCreateDate", query = "SELECT c FROM Company c WHERE c.createDate = :createDate"), @NamedQuery(name = "Company.findByCreateUser", query = "SELECT c FROM Company c WHERE c.createUser = :createUser"), @NamedQuery(name = "Company.findByLastModifiedUser", query = "SELECT c FROM Company c WHERE c.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Company.findByLastModifiedDate", query = "SELECT c FROM Company c WHERE c.lastModifiedDate = :lastModifiedDate")})
public class Company implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "description")
    private String description;
    @Column(name = "owner", nullable = false)
    private String owner;
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
    @ManyToMany(mappedBy = "companyCollection")
    private Collection<Users> userCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company1")
    private Collection<CompanyGroup> companyGroupCollection;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
    }

    public Company(Integer id, String name, String city, String owner) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public Collection<Users> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<Users> userCollection) {
        this.userCollection = userCollection;
    }

    public Collection<CompanyGroup> getCompanyGroupCollection() {
        return companyGroupCollection;
    }

    public void setCompanyGroupCollection(Collection<CompanyGroup> companyGroupCollection) {
        this.companyGroupCollection = companyGroupCollection;
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
if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.timesheet.model.Company[id=" + id + "]";
    }

}
