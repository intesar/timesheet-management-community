/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "campus")
@NamedQueries({
    @NamedQuery(name = "Campus.findById", query = "SELECT c FROM Campus c WHERE c.id = ?1"), 
    @NamedQuery(name = "Campus.findByName", query = "SELECT c FROM Campus c WHERE c.name = ?1"), 
    @NamedQuery(name = "Campus.findByCreateUser", query = "SELECT c FROM Campus c WHERE c.createUser = ?1"), 
    @NamedQuery(name = "Campus.findByCreateDate", query = "SELECT c FROM Campus c WHERE c.createDate = ?1"),
    @NamedQuery(name = "Campus.findByLastModifiedUser", query = "SELECT c FROM Campus c WHERE c.lastModifiedUser = ?1"), 
    @NamedQuery(name = "Campus.findByLastModifiedDate", query = "SELECT c FROM Campus c WHERE c.lastModifiedDate = ?1"),
    @NamedQuery(name = "Campus.findByLastModifiedDates", query = "SELECT c FROM Campus c WHERE  c.lastModifiedDate between ?1 and ?2"),
    @NamedQuery(name = "Campus.findAll", query = "SELECT c FROM Campus c ")})
public class Campus extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "name", nullable = false)
    private String name;
    @JoinColumn(name = "address", referencedColumnName = "id")
    @ManyToOne
    private Address address;
    @JoinColumn(name = "university", referencedColumnName = "id")
    @ManyToOne
    private University university;

    public Campus() {
    }

    public Campus(Long id) {
        this.id = id;
    }

    public Campus(Long id, String name) {
        this.id = id;
        this.name = name;
    }
public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return name+" "+address+""+university;
    }

}
