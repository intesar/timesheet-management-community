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
@Table(name = "PREREQUISITE")
@NamedQueries({@NamedQuery(name = "Prerequisite.findById", query = "SELECT p FROM Prerequisite p WHERE p.id = :id"), @NamedQuery(name = "Prerequisite.findByName", query = "SELECT p FROM Prerequisite p WHERE p.name = :name"), @NamedQuery(name = "Prerequisite.findByDescription", query = "SELECT p FROM Prerequisite p WHERE p.description = :description"), @NamedQuery(name = "Prerequisite.findByCreateUser", query = "SELECT p FROM Prerequisite p WHERE p.createUser = :createUser"), @NamedQuery(name = "Prerequisite.findByCreateDate", query = "SELECT p FROM Prerequisite p WHERE p.createDate = :createDate"), @NamedQuery(name = "Prerequisite.findByLastModifiedDate", query = "SELECT p FROM Prerequisite p WHERE p.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Prerequisite.findByLastModifiedUser", query = "SELECT p FROM Prerequisite p WHERE p.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Prerequisite.findByVersionId", query = "SELECT p FROM Prerequisite p WHERE p.versionId = :versionId")})
public class Prerequisite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private BigDecimal id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
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
    @ManyToMany(mappedBy = "prerequisiteCollection")
    private Collection<Course> courseCollection;

    public Prerequisite() {
    }

    public Prerequisite(BigDecimal id) {
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
        if (!(object instanceof Prerequisite)) {
            return false;
        }
        Prerequisite other = (Prerequisite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.Prerequisite[id=" + id + "]";
    }

}
