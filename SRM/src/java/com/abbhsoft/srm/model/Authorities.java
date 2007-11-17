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
@Table(name = "authorities")
@NamedQueries({@NamedQuery(name = "Authorities.findByLastModifiedUser", query = "SELECT a FROM Authorities a WHERE a.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Authorities.findByLastModifiedDate", query = "SELECT a FROM Authorities a WHERE a.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Authorities.findByCreateUser", query = "SELECT a FROM Authorities a WHERE a.createUser = :createUser"), @NamedQuery(name = "Authorities.findByCreateDate", query = "SELECT a FROM Authorities a WHERE a.createDate = :createDate"), @NamedQuery(name = "Authorities.findById", query = "SELECT a FROM Authorities a WHERE a.id = :id"), @NamedQuery(name = "Authorities.findByAuthority", query = "SELECT a FROM Authorities a WHERE a.authority = :authority"), @NamedQuery(name = "Authorities.findByUsername", query = "SELECT a FROM Authorities a WHERE a.username = :username")})
public class Authorities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "last_modified_user")
    private Integer lastModifiedUser;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
    @Column(name = "create_user")
    private Integer createUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "authority", nullable = false)
    private String authority;
    @Column(name = "username", nullable = false)
    private String username;

    public Authorities() {
    }

    public Authorities(Integer id) {
        this.id = id;
    }

    public Authorities(Integer id, String authority, String username) {
        this.id = id;
        this.authority = authority;
        this.username = username;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        if (!(object instanceof Authorities)) {
            return false;
        }
        Authorities other = (Authorities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.Authorities[id=" + id + "]";
    }

}
