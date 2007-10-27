/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author mdshannan
 */
@Entity
@Table(name = "COURSE_CLASS")
@NamedQueries({@NamedQuery(name = "CourseClass.findById", query = "SELECT c FROM CourseClass c WHERE c.id = :id"), @NamedQuery(name = "CourseClass.findByDescription", query = "SELECT c FROM CourseClass c WHERE c.description = :description"), @NamedQuery(name = "CourseClass.findByDuration", query = "SELECT c FROM CourseClass c WHERE c.duration = :duration"), @NamedQuery(name = "CourseClass.findByCreateDate", query = "SELECT c FROM CourseClass c WHERE c.createDate = :createDate"), @NamedQuery(name = "CourseClass.findByCreateUser", query = "SELECT c FROM CourseClass c WHERE c.createUser = :createUser"), @NamedQuery(name = "CourseClass.findByLastModiifiedDate", query = "SELECT c FROM CourseClass c WHERE c.lastModiifiedDate = :lastModiifiedDate"), @NamedQuery(name = "CourseClass.findByLastModiifiedUser", query = "SELECT c FROM CourseClass c WHERE c.lastModiifiedUser = :lastModiifiedUser"), @NamedQuery(name = "CourseClass.findByVersionId", query = "SELECT c FROM CourseClass c WHERE c.versionId = :versionId"), @NamedQuery(name = "CourseClass.findByName", query = "SELECT c FROM CourseClass c WHERE c.name = :name")})
public class CourseClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private BigDecimal id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DURATION")
    private String duration;
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
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "INSTRUCTOR", referencedColumnName = "ID")
    @ManyToOne
    private Instructor instructor;

    public CourseClass() {
    }

    public CourseClass(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
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
        if (!(object instanceof CourseClass)) {
            return false;
        }
        CourseClass other = (CourseClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.CourseClass[id=" + id + "]";
    }

}
