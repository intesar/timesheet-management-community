/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "USERS")
@NamedQueries({@NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"), @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"), @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"), @NamedQuery(name = "Users.findByEMaiil", query = "SELECT u FROM Users u WHERE u.eMaiil = :eMaiil"), @NamedQuery(name = "Users.findByCreateDate", query = "SELECT u FROM Users u WHERE u.createDate = :createDate"), @NamedQuery(name = "Users.findByCreateUser", query = "SELECT u FROM Users u WHERE u.createUser = :createUser"), @NamedQuery(name = "Users.findByLastModiifiedDate", query = "SELECT u FROM Users u WHERE u.lastModiifiedDate = :lastModiifiedDate"), @NamedQuery(name = "Users.findByLastModiifiedUser", query = "SELECT u FROM Users u WHERE u.lastModiifiedUser = :lastModiifiedUser"), @NamedQuery(name = "Users.findByVersionId", query = "SELECT u FROM Users u WHERE u.versionId = :versionId")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private BigDecimal id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "E_MAIIL")
    private String eMaiil;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "CREATE_USER")
    private String createUser;
    @Column(name = "LAST_MODIIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastModiifiedDate;
    @Column(name = "LAST_MODIIFIED_USER")
    private String lastModiifiedUser;
    @Column(name = "VERSION_ID")
    private BigInteger versionId;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<Course> courseCollection;
    @JoinColumn(name = "ADDRESS", referencedColumnName = "ID")
    @ManyToOne
    private Address address;
    @JoinColumn(name = "PHONE_NO", referencedColumnName = "IID")
    @ManyToOne
    private Phone phoneNo;

    public Users() {
    }

    public Users(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEMaiil() {
        return eMaiil;
    }

    public void setEMaiil(String eMaiil) {
        this.eMaiil = eMaiil;
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

    public Date getLastModiifiedDate() {
        return lastModiifiedDate;
    }

    public void setLastModiifiedDate(Date lastModiifiedDate) {
        this.lastModiifiedDate = lastModiifiedDate;
    }

    public String getLastModiifiedUser() {
        return lastModiifiedUser;
    }

    public void setLastModiifiedUser(String lastModiifiedUser) {
        this.lastModiifiedUser = lastModiifiedUser;
    }

    public BigInteger getVersionId() {
        return versionId;
    }

    public void setVersionId(BigInteger versionId) {
        this.versionId = versionId;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Phone phoneNo) {
        this.phoneNo = phoneNo;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.Users[id=" + id + "]";
    }

}
