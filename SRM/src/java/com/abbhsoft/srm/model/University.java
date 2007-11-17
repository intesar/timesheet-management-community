/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "university")
@NamedQueries({@NamedQuery(name = "University.findById", query = "SELECT u FROM University u WHERE u.id = :?1"), @NamedQuery(name = "University.findByName", query = "SELECT u FROM University u WHERE u.name = :?1"), @NamedQuery(name = "University.findByCreateUser", query = "SELECT u FROM University u WHERE u.createUser = :?1"), @NamedQuery(name = "University.findByCreateDate", query = "SELECT u FROM University u WHERE u.createDate = :?1"), @NamedQuery(name = "University.findByLastModifiedUser", query = "SELECT u FROM University u WHERE u.lastModifiedUser = :?1"), @NamedQuery(name = "University.findByLastModifiedDate", query = "SELECT u FROM University u WHERE u.lastModifiedDate = :?1")})
public class University extends BaseModel {
    private static final long serialVersionUID = 1L;
   
    @Column(name = "name", nullable = false)
    private String name;
   
    @OneToMany(mappedBy = "university")
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "university")
    private Collection<Group1> group1Collection;
    @OneToMany(mappedBy = "university")
    private Collection<Campus> campusCollection;

    public University() {
    }

    public University(Long id) {
        this.id = id;
    }

    public University(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public Collection<Group1> getGroup1Collection() {
        return group1Collection;
    }

    public void setGroup1Collection(Collection<Group1> group1Collection) {
        this.group1Collection = group1Collection;
    }

    public Collection<Campus> getCampusCollection() {
        return campusCollection;
    }

    public void setCampusCollection(Collection<Campus> campusCollection) {
        this.campusCollection = campusCollection;
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
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.University[id=" + id + "]";
    }

}
