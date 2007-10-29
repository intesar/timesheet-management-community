/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.Long;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "COURSE")
@NamedQueries({@NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"), @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"), @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c WHERE c.description = :description"), @NamedQuery(name = "Course.findByStateDate", query = "SELECT c FROM Course c WHERE c.stateDate = :stateDate"), @NamedQuery(name = "Course.findByCreateUser", query = "SELECT c FROM Course c WHERE c.createUser = :createUser"), @NamedQuery(name = "Course.findByCreateDate", query = "SELECT c FROM Course c WHERE c.createDate = :createDate"), @NamedQuery(name = "Course.findByLastModifiedUser", query = "SELECT c FROM Course c WHERE c.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Course.findByLastModifiedDate", query = "SELECT c FROM Course c WHERE c.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Course.findByVersionId", query = "SELECT c FROM Course c WHERE c.versionId = :versionId")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date stateDate;
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
    private Long versionId;
    @JoinTable(name = "COURSE_PREREQUISITE", joinColumns = {@JoinColumn(name = "COURSE", referencedColumnName = "ID")}, inverseJoinColumns = {@JoinColumn(name = "PREREQUISITE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Prerequisite> prerequisiteCollection;
    @JoinTable(name = "ENROLL", joinColumns = {@JoinColumn(name = "COURSE", referencedColumnName = "ID")}, inverseJoinColumns = {@JoinColumn(name = "TRAINEE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Trainees> traineeCollection;
    @JoinTable(name = "COURSE_PHONE", joinColumns = {@JoinColumn(name = "COURSE", referencedColumnName = "ID")}, inverseJoinColumns = {@JoinColumn(name = "PHONE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Phone> phoneCollection;
    @OneToMany(mappedBy = "course")
    private Collection<Class> classCollection;
    @JoinColumn(name = "LOCATION", referencedColumnName = "ID")
    @ManyToOne
    private Address location;

    public Course() {
    }

    public Course(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
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

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public Collection<Prerequisite> getPrerequisiteCollection() {
        return prerequisiteCollection;
    }

    public void setPrerequisiteCollection(Collection<Prerequisite> prerequisiteCollection) {
        this.prerequisiteCollection = prerequisiteCollection;
    }

    public Collection<Trainees> getTraineeCollection() {
        return traineeCollection;
    }

    public void setTraineeCollection(Collection<Trainees> traineeCollection) {
        this.traineeCollection = traineeCollection;
    }

    public Collection<Phone> getPhoneCollection() {
        return phoneCollection;
    }

    public void setPhoneCollection(Collection<Phone> phoneCollection) {
        this.phoneCollection = phoneCollection;
    }

    public Collection<Class> getClassCollection() {
        return classCollection;
    }

    public void setClassCollection(Collection<Class> classCollection) {
        this.classCollection = classCollection;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.Course[id=" + id + "]";
    }

}
