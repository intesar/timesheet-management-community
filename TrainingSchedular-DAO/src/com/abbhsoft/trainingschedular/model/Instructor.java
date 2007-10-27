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
@Table(name = "INSTRUCTOR")
@NamedQueries({@NamedQuery(name = "Instructor1.findById", query = "SELECT i FROM Instructor1 i WHERE i.id = :id"), @NamedQuery(name = "Instructor1.findByFirstName", query = "SELECT i FROM Instructor1 i WHERE i.firstName = :firstName"), @NamedQuery(name = "Instructor1.findByLastName", query = "SELECT i FROM Instructor1 i WHERE i.lastName = :lastName"), @NamedQuery(name = "Instructor1.findByEmaiil", query = "SELECT i FROM Instructor1 i WHERE i.emaiil = :emaiil"), @NamedQuery(name = "Instructor1.findByCreateDate", query = "SELECT i FROM Instructor1 i WHERE i.createDate = :createDate"), @NamedQuery(name = "Instructor1.findByCreateUser", query = "SELECT i FROM Instructor1 i WHERE i.createUser = :createUser"), @NamedQuery(name = "Instructor1.findByLastModiifiedDate", query = "SELECT i FROM Instructor1 i WHERE i.lastModiifiedDate = :lastModiifiedDate"), @NamedQuery(name = "Instructor1.findByLastModiifiedUser", query = "SELECT i FROM Instructor1 i WHERE i.lastModiifiedUser = :lastModiifiedUser"), @NamedQuery(name = "Instructor1.findByVersionId", query = "SELECT i FROM Instructor1 i WHERE i.versionId = :versionId")})
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private BigDecimal id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIIL")
    private String emaiil;
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
    @OneToMany(mappedBy = "instructor")
    private Collection<CourseClass> courseClassCollection;
    @JoinColumn(name = "ADDRESS", referencedColumnName = "ID")
    @ManyToOne
    private Address address;
    @JoinColumn(name = "PHONE", referencedColumnName = "IID")
    @ManyToOne
    private Phone phone;

    public Instructor() {
    }

    public Instructor(BigDecimal id) {
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

    public String getEmaiil() {
        return emaiil;
    }

    public void setEmaiil(String emaiil) {
        this.emaiil = emaiil;
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

    public Collection<CourseClass> getCourseClassCollection() {
        return courseClassCollection;
    }

    public void setCourseClassCollection(Collection<CourseClass> courseClassCollection) {
        this.courseClassCollection = courseClassCollection;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
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
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.Instructor1[id=" + id + "]";
    }

}
