/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "authority")
@NamedQueries({
    @NamedQuery(name = "Authority.findById", query = "SELECT a FROM Authority a WHERE a.id = ?1"), 
    @NamedQuery(name = "Authority.findByAuthority", query = "SELECT a FROM Authority a WHERE a.authority = ?1"), 
    @NamedQuery(name = "Authority.findByDescription", query = "SELECT a FROM Authority a WHERE a.description = ?1")})
public class Authority extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Column(name = "authority", nullable = false)
    private String authority;
    @Column(name = "description")
    private String description;

    public Authority() {
    }

    public Authority(Long id) {
        this.id = id;
    }

    public Authority(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Authority)) {
            return false;
        }
        Authority other = (Authority) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return authority + " " + description ;
    }

}
