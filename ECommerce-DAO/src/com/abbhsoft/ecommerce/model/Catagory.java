/*
 * Catagory.java
 * 
 * Created on Aug 20, 2007, 9:11:42 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "catagory")
@NamedQueries({@NamedQuery(name = "Catagory.findByCatagoryName", query = "SELECT c FROM Catagory c WHERE c.catagoryName = :catagoryName"), @NamedQuery(name = "Catagory.findByTimings", query = "SELECT c FROM Catagory c WHERE c.timings = :timings")})
public class Catagory implements Serializable {
    @Id
    @Column(name = "catagory_name", nullable = false)
    private String catagoryName;
    @Column(name = "timings", nullable = false)
    private String timings;

    public Catagory() {
    }

    public Catagory(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public Catagory(String catagoryName, String timings) {
        this.catagoryName = catagoryName;
        this.timings = timings;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catagoryName != null ? catagoryName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof Catagory)) {
            return false;
        }
        Catagory other = (Catagory) object;
        if (this.catagoryName != other.catagoryName && (this.catagoryName == null || !this.catagoryName.equals(other.catagoryName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.ecommerce.model.Catagory[catagoryName=" + catagoryName + "]";
    }

}
