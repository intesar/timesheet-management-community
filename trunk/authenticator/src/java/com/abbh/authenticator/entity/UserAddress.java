/*
 * UserAddress.java
 * 
 * Created on Jul 1, 2007, 7:11:49 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@NamedQueries({@NamedQuery(name = "UserAddress.findById", query = "SELECT u FROM UserAddress u WHERE u.id = :id"), @NamedQuery(name = "UserAddress.findByUsername", query = "SELECT u FROM UserAddress u WHERE u.userAddressPK.username = :username"), @NamedQuery(name = "UserAddress.findByType", query = "SELECT u FROM UserAddress u WHERE u.userAddressPK.type = :type"), @NamedQuery(name = "UserAddress.findByStreet", query = "SELECT u FROM UserAddress u WHERE u.street = :street"), @NamedQuery(name = "UserAddress.findByCity", query = "SELECT u FROM UserAddress u WHERE u.city = :city"), @NamedQuery(name = "UserAddress.findByState", query = "SELECT u FROM UserAddress u WHERE u.state = :state"), @NamedQuery(name = "UserAddress.findByZipcode", query = "SELECT u FROM UserAddress u WHERE u.zipcode = :zipcode"), @NamedQuery(name = "UserAddress.findByCountry", query = "SELECT u FROM UserAddress u WHERE u.country = :country"), @NamedQuery(name = "UserAddress.findByIsPublic", query = "SELECT u FROM UserAddress u WHERE u.isPublic = :isPublic"), @NamedQuery(name = "UserAddress.findByCreationDate", query = "SELECT u FROM UserAddress u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserAddress.findByLastModifiedDate", query = "SELECT u FROM UserAddress u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserAddress.findByIsDeleted", query = "SELECT u FROM UserAddress u WHERE u.isDeleted = :isDeleted")})
public class UserAddress implements Serializable {

    @EmbeddedId
    protected UserAddressPK userAddressPK;

    @Column(name = "id")
    private Integer id;

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

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @JoinColumn(name = "username", referencedColumnName = " username", insertable = false, updatable = false)
    @ManyToOne
    private Users users;

    public UserAddress() {
    }

    public UserAddress(UserAddressPK userAddressPK) {
        this.userAddressPK = userAddressPK;
    }

    public UserAddress(UserAddressPK userAddressPK, String street, String city, String state, String zipcode, String country) {
        this.userAddressPK = userAddressPK;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    public UserAddress(String username, String type) {
        this.userAddressPK = new UserAddressPK(username, type);
    }

    public UserAddressPK getUserAddressPK() {
        return userAddressPK;
    }

    public void setUserAddressPK(UserAddressPK userAddressPK) {
        this.userAddressPK = userAddressPK;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAddressPK != null ? userAddressPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAddress)) {
            return false;
        }
        UserAddress other = (UserAddress) object;
        if (this.userAddressPK != other.userAddressPK && (this.userAddressPK == null || !this.userAddressPK.equals(other.userAddressPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserAddress[userAddressPK=" + userAddressPK + "]";
    }

}
