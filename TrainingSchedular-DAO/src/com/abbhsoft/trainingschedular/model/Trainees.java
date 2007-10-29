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
import javax.persistence.ManyToMany;
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
@Table(name = "TRAINEES")
@NamedQueries({@NamedQuery(name = "Trainees.findById", query = "SELECT t FROM Trainees t WHERE t.id = :id"), @NamedQuery(name = "Trainees.findByFirstName", query = "SELECT t FROM Trainees t WHERE t.firstName = :firstName"), @NamedQuery(name = "Trainees.findByLastName", query = "SELECT t FROM Trainees t WHERE t.lastName = :lastName"), @NamedQuery(name = "Trainees.findByMi", query = "SELECT t FROM Trainees t WHERE t.mi = :mi"), @NamedQuery(name = "Trainees.findByEmail", query = "SELECT t FROM Trainees t WHERE t.email = :email"), @NamedQuery(name = "Trainees.findByComments", query = "SELECT t FROM Trainees t WHERE t.comments = :comments"), @NamedQuery(name = "Trainees.findByMobilePhone", query = "SELECT t FROM Trainees t WHERE t.mobilePhone = :mobilePhone"), @NamedQuery(name = "Trainees.findByHomePhone", query = "SELECT t FROM Trainees t WHERE t.homePhone = :homePhone"), @NamedQuery(name = "Trainees.findByCreateUser", query = "SELECT t FROM Trainees t WHERE t.createUser = :createUser"), @NamedQuery(name = "Trainees.findByCreateDate", query = "SELECT t FROM Trainees t WHERE t.createDate = :createDate"), @NamedQuery(name = "Trainees.findByLastModifiedDate", query = "SELECT t FROM Trainees t WHERE t.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Trainees.findByLastModifiedUser", query = "SELECT t FROM Trainees t WHERE t.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Trainees.findByVersionId", query = "SELECT t FROM Trainees t WHERE t.versionId = :versionId")})
public class Trainees implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private BigDecimal id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "MI")
    private String mi;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;
    @Column(name = "HOME_PHONE")
    private String homePhone;
    @Column(name = "CREATE_USER")
    private String createUser;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
    @Column(name = "LAST_MODIFIED_USER")
    private String lastModifiedUser;
    @Column(name = "VERSION_ID")
    private BigInteger versionId;
    @ManyToMany(mappedBy = "traineeCollection")
    private Collection<Phone> phoneCollection;
    @ManyToMany(mappedBy = "traineeCollection")
    private Collection<Course> courseCollection;

    public Trainees() {
    }

    public Trainees(BigDecimal id) {
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

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public BigInteger getVersionId() {
        return versionId;
    }

    public void setVersionId(BigInteger versionId) {
        this.versionId = versionId;
    }

    public Collection<Phone> getPhoneCollection() {
        return phoneCollection;
    }

    public void setPhoneCollection(Collection<Phone> phoneCollection) {
        this.phoneCollection = phoneCollection;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
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
        if (!(object instanceof Trainees)) {
            return false;
        }
        Trainees other = (Trainees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.Trainees[id=" + id + "]";
    }

}
