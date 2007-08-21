/*
 * Catagory.java
 * 
 * Created on Aug 21, 2007, 6:59:19 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author shannan
 */
@Entity
@Table(name = "catagory")
@NamedQueries({@NamedQuery(name = "Catagory.findById", query = "SELECT c FROM Catagory c WHERE c.id = :id"), @NamedQuery(name = "Catagory.findByName", query = "SELECT c FROM Catagory c WHERE c.name = :name"), @NamedQuery(name = "Catagory.findByTimings", query = "SELECT c FROM Catagory c WHERE c.timings = :timings")})
public class Catagory implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "timings")
    private String timings;
    @JoinTable(name = "item_catagory", joinColumns = {@JoinColumn(name = "catagory_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Item> itemIdCollection;

    public Catagory() {
    }

    public Catagory(Integer id) {
        this.id = id;
    }

    public Catagory(Integer id, String name) {
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

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public Collection<Item> getItemIdCollection() {
        return itemIdCollection;
    }

    public void setItemIdCollection(Collection<Item> itemIdCollection) {
        this.itemIdCollection = itemIdCollection;
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
if (!(object instanceof Catagory)) {
            return false;
        }
        Catagory other = (Catagory) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.ecommerce.model.Catagory[id=" + id + "]";
    }

}
