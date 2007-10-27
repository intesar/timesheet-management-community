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
import javax.persistence.JoinTable;
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
@Table(name = "COURSE")
@NamedQueries({@NamedQuery(name = "Course.findByIid", query = "SELECT c FROM Course c WHERE c.iid = :iid"), @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"), @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c WHERE c.description = :description"), @NamedQuery(name = "Course.findByStartDate", query = "SELECT c FROM Course c WHERE c.startDate = :startDate"), @NamedQuery(name = "Course.findByCreateDate", query = "SELECT c FROM Course c WHERE c.createDate = :createDate"), @NamedQuery(name = "Course.findByCreateUser", query = "SELECT c FROM Course c WHERE c.createUser = :createUser"), @NamedQuery(name = "Course.findByLastModiifiedDate", query = "SELECT c FROM Course c WHERE c.lastModiifiedDate = :lastModiifiedDate"), @NamedQuery(name = "Course.findByLastModiifiiedUser", query = "SELECT c FROM Course c WHERE c.lastModiifiiedUser = :lastModiifiiedUser"), @NamedQuery(name = "Course.findByVersionId", query = "SELECT c FROM Course c WHERE c.versionId = :versionId")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IID", nullable = false)
    private BigDecimal iid;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "CREATE_USER")
    private String createUser;
    @Column(name = "LAST_MODIIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastModiifiedDate;
    @Column(name = "LAST_MODIIFIIED_USER")
    private String lastModiifiiedUser;
    @Column(name = "VERSION_ID")
    private BigInteger versionId;
    @JoinTable(name = "COURSE_PREREQUISITE", joinColumns = {@JoinColumn(name = "COURSE", referencedColumnName = "IID")}, inverseJoinColumns = {@JoinColumn(name = "PRE_REQUISITE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<PreRequisite> preRequisiteCollection;
    @JoinTable(name = "ENROLLMENT", joinColumns = {@JoinColumn(name = "COURSE", referencedColumnName = "IID")}, inverseJoinColumns = {@JoinColumn(name = "USER", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Users> userCollection;
    @JoinColumn(name = "ADDRESS", referencedColumnName = "ID")
    @ManyToOne
    private Address address;
    @JoinTable(name = "COURSE_CLASS", joinColumns = {@JoinColumn(name = "COURSE", referencedColumnName = "IID")}, inverseJoinColumns = {@JoinColumn(name = "PRE_REQUISITE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<CourseClass> courseClassCollection;

    public Course() {
    }

    public Collection<CourseClass> getCourseClassCollection() {
        return courseClassCollection;
    }

    public void setCourseClassCollection(Collection<CourseClass> courseClassCollection) {
        this.courseClassCollection = courseClassCollection;
    }

    public Course(BigDecimal iid) {
        this.iid = iid;
    }

    public BigDecimal getIid() {
        return iid;
    }

    public void setIid(BigDecimal iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public String getLastModiifiiedUser() {
        return lastModiifiiedUser;
    }

    public void setLastModiifiiedUser(String lastModiifiiedUser) {
        this.lastModiifiiedUser = lastModiifiiedUser;
    }

    public BigInteger getVersionId() {
        return versionId;
    }

    public void setVersionId(BigInteger versionId) {
        this.versionId = versionId;
    }

    public Collection<PreRequisite> getPreRequisiteCollection() {
        return preRequisiteCollection;
    }

    public void setPreRequisiteCollection(Collection<PreRequisite> preRequisiteCollection) {
        this.preRequisiteCollection = preRequisiteCollection;
    }

    public Collection<Users> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<Users> userCollection) {
        this.userCollection = userCollection;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iid != null ? iid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.iid == null && other.iid != null) || (this.iid != null && !this.iid.equals(other.iid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.Course[iid=" + iid + "]";
    }

}
