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
@Table(name = "key_value")
@NamedQueries({@NamedQuery(name = "KeyValue.findById", query = "SELECT k FROM KeyValue k WHERE k.id = :id"), @NamedQuery(name = "KeyValue.findByKey", query = "SELECT k FROM KeyValue k WHERE k.key = :key"), @NamedQuery(name = "KeyValue.findByValue", query = "SELECT k FROM KeyValue k WHERE k.value = :value"), @NamedQuery(name = "KeyValue.findByDescriptIon", query = "SELECT k FROM KeyValue k WHERE k.descriptIon = :descriptIon"), @NamedQuery(name = "KeyValue.findByCreateUser", query = "SELECT k FROM KeyValue k WHERE k.createUser = :createUser"), @NamedQuery(name = "KeyValue.findByCreateDate", query = "SELECT k FROM KeyValue k WHERE k.createDate = :createDate"), @NamedQuery(name = "KeyValue.findByLastModifiedUser", query = "SELECT k FROM KeyValue k WHERE k.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "KeyValue.findByLastModifiedDate", query = "SELECT k FROM KeyValue k WHERE k.lastModifiedDate = :lastModifiedDate")})
public class KeyValue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "key", nullable = false)
    private String key;
    @Column(name = "value", nullable = false)
    private String value;
    @Column(name = "descriptIon")
    private String descriptIon;
    @Column(name = "create_user")
    private String createUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "last_modified_user")
    private String lastModifiedUser;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    public KeyValue() {
    }

    public KeyValue(Integer id) {
        this.id = id;
    }

    public KeyValue(Integer id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescriptIon() {
        return descriptIon;
    }

    public void setDescriptIon(String descriptIon) {
        this.descriptIon = descriptIon;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KeyValue)) {
            return false;
        }
        KeyValue other = (KeyValue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.KeyValue[id=" + id + "]";
    }

}
