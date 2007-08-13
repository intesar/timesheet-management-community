/*
 * Address.java
 *
 * Created on Aug 12, 2007, 3:55:25 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "address")
@NamedQueries(value = {@NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id"), @NamedQuery(name = "Address.findByZipcode", query = "SELECT a FROM Address a WHERE a.zipcode = :zipcode"), @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country"), @NamedQuery(name = "Address.findByType", query = "SELECT a FROM Address a WHERE a.type = :type"), @NamedQuery(name = "Address.findByCreateUser", query = "SELECT a FROM Address a WHERE a.createUser = :createUser"), @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"), @NamedQuery(name = "Address.findByCreateDate", query = "SELECT a FROM Address a WHERE a.createDate = :createDate"), @NamedQuery(name = "Address.findByLastModifiedDate", query = "SELECT a FROM Address a WHERE a.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Address.findByState", query = "SELECT a FROM Address a WHERE a.state = :state"), @NamedQuery(name = "Address.findByLastModifiedUser", query = "SELECT a FROM Address a WHERE a.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street")})
public class Address implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "country")
    private String country;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "create_user")
    private String createUser;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "create_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "last_modified_date")
    private String lastModifiedDate;
    @Column(name = "state")
    private String state;
    @Column(name = "last_modified_user")
    private String lastModifiedUser;
    @Column(name = "street")
    private String street;

    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    public Address(Long id, String type, String city) {
        this.id = id;
        this.type = type;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.timesheet.model.Address[id=" + id + "]";
    }
}
