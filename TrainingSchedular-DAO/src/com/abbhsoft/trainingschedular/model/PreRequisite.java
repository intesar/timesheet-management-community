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
@Table(name = "PRE_REQUISITE")
@NamedQueries({@NamedQuery(name = "PreRequisite.findById", query = "SELECT p FROM PreRequisite p WHERE p.id = :id"), @NamedQuery(name = "PreRequisite.findByName", query = "SELECT p FROM PreRequisite p WHERE p.name = :name"), @NamedQuery(name = "PreRequisite.findByDescription", query = "SELECT p FROM PreRequisite p WHERE p.description = :description"), @NamedQuery(name = "PreRequisite.findByLastModiifiedDate", query = "SELECT p FROM PreRequisite p WHERE p.lastModiifiedDate = :lastModiifiedDate"), @NamedQuery(name = "PreRequisite.findByCreateUser", query = "SELECT p FROM PreRequisite p WHERE p.createUser = :createUser"), @NamedQuery(name = "PreRequisite.findByVersionId", query = "SELECT p FROM PreRequisite p WHERE p.versionId = :versionId"), @NamedQuery(name = "PreRequisite.findByLastModiifiedUser", query = "SELECT p FROM PreRequisite p WHERE p.lastModiifiedUser = :lastModiifiedUser"), @NamedQuery(name = "PreRequisite.findByCreateDate", query = "SELECT p FROM PreRequisite p WHERE p.createDate = :createDate")})
public class PreRequisite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private BigDecimal id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "LAST_MODIIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastModiifiedDate;
    @Column(name = "CREATE_USER")
    private String createUser;
    @Column(name = "VERSION_ID")
    private BigInteger versionId;
    @Column(name = "LAST_MODIIFIED_USER")
    private String lastModiifiedUser;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @ManyToMany(mappedBy = "preRequisiteCollection")
    private Collection<Course> courseCollection;

    public PreRequisite() {
    }

    public PreRequisite(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public Date getLastModiifiedDate() {
        return lastModiifiedDate;
    }

    public void setLastModiifiedDate(Date lastModiifiedDate) {
        this.lastModiifiedDate = lastModiifiedDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public BigInteger getVersionId() {
        return versionId;
    }

    public void setVersionId(BigInteger versionId) {
        this.versionId = versionId;
    }

    public String getLastModiifiedUser() {
        return lastModiifiedUser;
    }

    public void setLastModiifiedUser(String lastModiifiedUser) {
        this.lastModiifiedUser = lastModiifiedUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        if (!(object instanceof PreRequisite)) {
            return false;
        }
        PreRequisite other = (PreRequisite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.PreRequisite[id=" + id + "]";
    }

}
