/*
 * UserAddress.java
 * 
 * Created on Jul 4, 2007, 2:04:58 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "user_address")
@NamedQueries({@NamedQuery(name = "UserAddress.findById", query = "SELECT u FROM UserAddress u WHERE u.id = :id"), @NamedQuery(name = "UserAddress.findByType", query = "SELECT u FROM UserAddress u WHERE u.type = :type"), @NamedQuery(name = "UserAddress.findByStreet", query = "SELECT u FROM UserAddress u WHERE u.street = :street"), @NamedQuery(name = "UserAddress.findByCity", query = "SELECT u FROM UserAddress u WHERE u.city = :city"), @NamedQuery(name = "UserAddress.findByState", query = "SELECT u FROM UserAddress u WHERE u.state = :state"), @NamedQuery(name = "UserAddress.findByZipcode", query = "SELECT u FROM UserAddress u WHERE u.zipcode = :zipcode"), @NamedQuery(name = "UserAddress.findByCountry", query = "SELECT u FROM UserAddress u WHERE u.country = :country"), @NamedQuery(name = "UserAddress.findByIsPublic", query = "SELECT u FROM UserAddress u WHERE u.isPublic = :isPublic"), @NamedQuery(name = "UserAddress.findByCreationDate", query = "SELECT u FROM UserAddress u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserAddress.findByLastModifiedDate", query = "SELECT u FROM UserAddress u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserAddress.findByIsDeleted", query = "SELECT u FROM UserAddress u WHERE u.isDeleted = :isDeleted"), @NamedQuery(name = "UserAddress.findByCreatedBy", query = "SELECT u FROM UserAddress u WHERE u.createdBy = :createdBy"), @NamedQuery(name = "UserAddress.findByLastModifiedBy", query = "SELECT u FROM UserAddress u WHERE u.lastModifiedBy = :lastModifiedBy")})
public class UserAddress implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "LAST_MODIFIED_BY", nullable = false)
    private String lastModifiedBy;

    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private Users username;

    public UserAddress() {
    }

    public UserAddress(Integer id) {
        this.id = id;
    }

    public UserAddress(Integer id, String street, String city, String state, String zipcode, String country, Date lastModifiedDate, String lastModifiedBy) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
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
        if (!(object instanceof UserAddress)) {
            return false;
        }
        UserAddress other = (UserAddress) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserAddress[id=" + id + "]";
    }

}
