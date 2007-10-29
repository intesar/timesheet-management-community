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
@Table(name = "CLASS")
@NamedQueries({@NamedQuery(name = "Class.findById", query = "SELECT c FROM Class c WHERE c.id = :id"), @NamedQuery(name = "Class.findByTopic", query = "SELECT c FROM Class c WHERE c.topic = :topic"), @NamedQuery(name = "Class.findByClassNo", query = "SELECT c FROM Class c WHERE c.classNo = :classNo"), @NamedQuery(name = "Class.findByDescription", query = "SELECT c FROM Class c WHERE c.description = :description"), @NamedQuery(name = "Class.findByClassDate", query = "SELECT c FROM Class c WHERE c.classDate = :classDate"), @NamedQuery(name = "Class.findByDuration", query = "SELECT c FROM Class c WHERE c.duration = :duration"), @NamedQuery(name = "Class.findByInstructor", query = "SELECT c FROM Class c WHERE c.instructor = :instructor"), @NamedQuery(name = "Class.findByStatus", query = "SELECT c FROM Class c WHERE c.status = :status"), @NamedQuery(name = "Class.findByCreateUser", query = "SELECT c FROM Class c WHERE c.createUser = :createUser"), @NamedQuery(name = "Class.findByCreateDate", query = "SELECT c FROM Class c WHERE c.createDate = :createDate"), @NamedQuery(name = "Class.findByLastModifiedUser", query = "SELECT c FROM Class c WHERE c.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Class.findByLastModifiedDate", query = "SELECT c FROM Class c WHERE c.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Class.findByVersionId", query = "SELECT c FROM Class c WHERE c.versionId = :versionId")})
public class Class implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private BigDecimal id;
    @Column(name = "TOPIC")
    private String topic;
    @Column(name = "CLASS_NO")
    private BigInteger classNo;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CLASS_DATE")
    @Temporal(TemporalType.DATE)
    private Date classDate;
    @Column(name = "DURATION")
    private BigInteger duration;
    @Column(name = "INSTRUCTOR")
    private String instructor;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CREATE_USER")
    private String createUser;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "LAST_MODIFIED_USER")
    private String lastModifiedUser;
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
    @Column(name = "VERSION_ID")
    private BigInteger versionId;
    @JoinColumn(name = "COURSE", referencedColumnName = "ID")
    @ManyToOne
    private Course course;

    public Class() {
    }

    public Class(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public BigInteger getClassNo() {
        return classNo;
    }

    public void setClassNo(BigInteger classNo) {
        this.classNo = classNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getClassDate() {
        return classDate;
    }

    public void setClassDate(Date classDate) {
        this.classDate = classDate;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public BigInteger getVersionId() {
        return versionId;
    }

    public void setVersionId(BigInteger versionId) {
        this.versionId = versionId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
        if (!(object instanceof Class)) {
            return false;
        }
        Class other = (Class) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.Class[id=" + id + "]";
    }

}
