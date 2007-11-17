/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
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
@Table(name = "key_value")
@NamedQueries({@NamedQuery(name = "KeyValue.findById", query = "SELECT k FROM KeyValue k WHERE k.id = ?1"), @NamedQuery(name = "KeyValue.findByKey", query = "SELECT k FROM KeyValue k WHERE k.key = ?1"), @NamedQuery(name = "KeyValue.findByValue", query = "SELECT k FROM KeyValue k WHERE k.value = ?1"), @NamedQuery(name = "KeyValue.findByDescriptIon", query = "SELECT k FROM KeyValue k WHERE k.descriptIon = ?1"), @NamedQuery(name = "KeyValue.findByCreateUser", query = "SELECT k FROM KeyValue k WHERE k.createUser = ?1"), @NamedQuery(name = "KeyValue.findByCreateDate", query = "SELECT k FROM KeyValue k WHERE k.createDate = ?1"), @NamedQuery(name = "KeyValue.findByLastModifiedUser", query = "SELECT k FROM KeyValue k WHERE k.lastModifiedUser = ?1"), @NamedQuery(name = "KeyValue.findByLastModifiedDate", query = "SELECT k FROM KeyValue k WHERE k.lastModifiedDate = ?1")})
public class KeyValue extends BaseModel {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "key", nullable = false)
    private String key;
    @Column(name = "value", nullable = false)
    private String value;
    @Column(name = "descriptIon")
    private String descriptIon;

    public KeyValue() {
    }

    public KeyValue(Long id) {
        this.id = id;
    }

    public KeyValue(Long id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
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
