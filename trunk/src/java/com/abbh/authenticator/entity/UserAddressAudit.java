/*
 * UserAddressAudit.java
 * 
 * Created on Jul 1, 2007, 5:40:36 PM
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
@Table(name = "user_address_audit")
@NamedQueries({@NamedQuery(name = "UserAddressAudit.findById", query = "SELECT u FROM UserAddressAudit u WHERE u.id = :id"), @NamedQuery(name = "UserAddressAudit.findByUserame", query = "SELECT u FROM UserAddressAudit u WHERE u.userame = :userame"), @NamedQuery(name = "UserAddressAudit.findByType", query = "SELECT u FROM UserAddressAudit u WHERE u.type = :type"), @NamedQuery(name = "UserAddressAudit.findByStreet", query = "SELECT u FROM UserAddressAudit u WHERE u.street = :street"), @NamedQuery(name = "UserAddressAudit.findByCity", query = "SELECT u FROM UserAddressAudit u WHERE u.city = :city"), @NamedQuery(name = "UserAddressAudit.findByState", query = "SELECT u FROM UserAddressAudit u WHERE u.state = :state"), @NamedQuery(name = "UserAddressAudit.findByZipcode", query = "SELECT u FROM UserAddressAudit u WHERE u.zipcode = :zipcode"), @NamedQuery(name = "UserAddressAudit.findByCountry", query = "SELECT u FROM UserAddressAudit u WHERE u.country = :country"), @NamedQuery(name = "UserAddressAudit.findByIsPublic", query = "SELECT u FROM UserAddressAudit u WHERE u.isPublic = :isPublic"), @NamedQuery(name = "UserAddressAudit.findByCreationDate", query = "SELECT u FROM UserAddressAudit u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "UserAddressAudit.findByLastModifiedDate", query = "SELECT u FROM UserAddressAudit u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "UserAddressAudit.findByAuditUser", query = "SELECT u FROM UserAddressAudit u WHERE u.auditUser = :auditUser"), @NamedQuery(name = "UserAddressAudit.findByAuditDate", query = "SELECT u FROM UserAddressAudit u WHERE u.auditDate = :auditDate")})
public class UserAddressAudit implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "userame")
    private String userame;

    @Column(name = "type")
    private String type;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "country")
    private String country;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "audit_user")
    private String auditUser;

    @Column(name = "audit_date")
    @Temporal(TemporalType.DATE)
    private Date auditDate;

    public UserAddressAudit() {
    }

    public UserAddressAudit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserame() {
        return userame;
    }

    public void setUserame(String userame) {
        this.userame = userame;
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

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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
        if (!(object instanceof UserAddressAudit)) {
            return false;
        }
        UserAddressAudit other = (UserAddressAudit) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserAddressAudit[id=" + id + "]";
    }

}
