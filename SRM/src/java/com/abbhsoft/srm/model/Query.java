/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
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
@Table(name = "query")
@NamedQueries({
    @NamedQuery(name = "Query.findByMsg", query = "SELECT q FROM Query q WHERE q.msg = ?1"),
    @NamedQuery(name = "Query.findByCreateDate", query = "SELECT q FROM Query q WHERE q.createDate =?1"), 
    @NamedQuery(name = "Query.findByCreateUser", query = "SELECT q FROM Query q WHERE q.createUser = ?1"),
    @NamedQuery(name = "Query.findByLastModifiedUser", query = "SELECT q FROM Query q WHERE q.lastModifiedUser = ?1"), 
    @NamedQuery(name = "Query.findByLastModifiedDate", query = "SELECT q FROM Query q WHERE q.lastModifiedDate = ?1"), 
    @NamedQuery(name = "Query.findById", query = "SELECT q FROM Query q WHERE q.id = ?1")})
public class Query extends BaseModel implements java.io.Serializable  {
    private static final long serialVersionUID = 1L;
    @Column(name = "msg", nullable = false)
    private String msg;
   
    @JoinColumn(name = "student", referencedColumnName = "id")
    @ManyToOne
    private Student student;

    public Query() {
    }

    public Query(Long id) {
        this.id = id;
    }

    public Query(Long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
        if (!(object instanceof Query)) {
            return false;
        }
        Query other = (Query) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return msg;
    }

}
