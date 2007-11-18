/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "address")
@NamedQueries({
    @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = ?1"), 
    @NamedQuery(name = "Address.findByType", query = "SELECT a FROM Address a WHERE a.type = ?1"), 
    @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = ?1"), 
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = ?1"), 
    @NamedQuery(name = "Address.findByState", query = "SELECT a FROM Address a WHERE a.state = ?1"), 
    @NamedQuery(name = "Address.findByZipcode", query = "SELECT a FROM Address a WHERE a.zipcode = ?1"), 
    @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = ?1"), 
    @NamedQuery(name = "Address.findByCreateUser", query = "SELECT a FROM Address a WHERE a.createUser = ?1"),
    @NamedQuery(name = "Address.findByCreateDate", query = "SELECT a FROM Address a WHERE a.createDate = ?1"), 
    @NamedQuery(name = "Address.findByLastModiiedUser", query = "SELECT a FROM Address a WHERE a.lastModifiedUser = ?1"), 
    @NamedQuery(name = "Address.findByLastModifiedDate", query = "SELECT a FROM Address a WHERE a.lastModifiedDate = ?1")})
public class Address extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "type")
    private String type;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "country")
    private String country;
   
    @OneToMany(mappedBy = "address")
    private Collection<Campus> campusCollection;

    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    public Address(Long id, String street, String city) {
        this.id = id;
        this.street = street;
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public void setCampusCollection(Collection<Campus> campusCollection) {
        this.campusCollection = campusCollection;
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return type+" "+ street+" "+ city+" "+ state+" "+zipcode+ " " +  country ;
    }

}
