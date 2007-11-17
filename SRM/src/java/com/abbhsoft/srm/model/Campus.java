/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import java.io.Serializable;
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
@Table(name = "campus")
@NamedQueries({@NamedQuery(name = "Campus.findById", query = "SELECT c FROM Campus c WHERE c.id = :id"), @NamedQuery(name = "Campus.findByName", query = "SELECT c FROM Campus c WHERE c.name = :name"), @NamedQuery(name = "Campus.findByCreateUser", query = "SELECT c FROM Campus c WHERE c.createUser = :createUser"), @NamedQuery(name = "Campus.findByCreateDate", query = "SELECT c FROM Campus c WHERE c.createDate = :createDate"), @NamedQuery(name = "Campus.findByLastModifiedUser", query = "SELECT c FROM Campus c WHERE c.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Campus.findByLastModifiedDate", query = "SELECT c FROM Campus c WHERE c.lastModifiedDate = :lastModifiedDate")})
public class Campus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "create_user")
    private Integer createUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "last_modified_user")
    private Integer lastModifiedUser;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
    @JoinColumn(name = "address", referencedColumnName = "id")
    @ManyToOne
    private Address address;
    @JoinColumn(name = "university", referencedColumnName = "id")
    @ManyToOne
    private University university;

    public Campus() {
    }

    public Campus(Integer id) {
        this.id = id;
    }

    public Campus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(Integer lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
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
        if (!(object instanceof Campus)) {
            return false;
        }
        Campus other = (Campus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.Campus[id=" + id + "]";
    }

}
