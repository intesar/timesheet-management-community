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
@Table(name = "query")
@NamedQueries({@NamedQuery(name = "Query.findByMsg", query = "SELECT q FROM Query q WHERE q.msg = :msg"), @NamedQuery(name = "Query.findByCreateDate", query = "SELECT q FROM Query q WHERE q.createDate = :createDate"), @NamedQuery(name = "Query.findByCreateUser", query = "SELECT q FROM Query q WHERE q.createUser = :createUser"), @NamedQuery(name = "Query.findByLastModifiedUser", query = "SELECT q FROM Query q WHERE q.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Query.findByLastModifiedDate", query = "SELECT q FROM Query q WHERE q.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Query.findById", query = "SELECT q FROM Query q WHERE q.id = :id")})
public class Query implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "msg", nullable = false)
    private String msg;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "create_user")
    private Integer createUser;
    @Column(name = "last_modified_user")
    private Integer lastModifiedUser;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "student", referencedColumnName = "id")
    @ManyToOne
    private Student student;

    public Query() {
    }

    public Query(Integer id) {
        this.id = id;
    }

    public Query(Integer id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "com.abbhsoft.srm.model.Query[id=" + id + "]";
    }

}
