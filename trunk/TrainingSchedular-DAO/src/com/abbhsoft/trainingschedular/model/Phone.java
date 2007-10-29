/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.model;

import java.io.Serializable;
import java.lang.Long;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "PHONE")
@NamedQueries({@NamedQuery(name = "Phone.findById", query = "SELECT p FROM Phone p WHERE p.id = :id"), @NamedQuery(name = "Phone.findByType", query = "SELECT p FROM Phone p WHERE p.type = :type"), @NamedQuery(name = "Phone.findByPhoneNo", query = "SELECT p FROM Phone p WHERE p.phoneNo = :phoneNo"), @NamedQuery(name = "Phone.findByCreateUser", query = "SELECT p FROM Phone p WHERE p.createUser = :createUser"), @NamedQuery(name = "Phone.findByCreateDate", query = "SELECT p FROM Phone p WHERE p.createDate = :createDate"), @NamedQuery(name = "Phone.findByLastModifiedDate", query = "SELECT p FROM Phone p WHERE p.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Phone.findByLastModifiedUser", query = "SELECT p FROM Phone p WHERE p.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Phone.findByVersionId", query = "SELECT p FROM Phone p WHERE p.versionId = :versionId")})
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "PHONE_NO")
    private String phoneNo;
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
    private String versionId;
    @JoinTable(name = "TRAINEE_PHONE", joinColumns = {@JoinColumn(name = "PHONE", referencedColumnName = "ID")}, inverseJoinColumns = {@JoinColumn(name = "TRAINEE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Trainees> traineeCollection;
    @ManyToMany(mappedBy = "phoneCollection")
    private Collection<Course> courseCollection;

    public Phone() {
    }

    public Phone(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public Collection<Trainees> getTraineeCollection() {
        return traineeCollection;
    }

    public void setTraineeCollection(Collection<Trainees> traineeCollection) {
        this.traineeCollection = traineeCollection;
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
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.Phone[id=" + id + "]";
    }

}
