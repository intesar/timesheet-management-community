/*
 * CompanyDTO.java
 *
 * Created on Aug 14, 2007, 11:53:42 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.dto;

import java.io.Serializable;

/**
 *
 * @author shannan
 */
public class CompanyDTO implements Serializable {

    private Long id;
    private String name;
    private String city;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyDTO() {
    }

    @Override
    public String toString() {
        return super.toString();
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CompanyDTO other = (CompanyDTO) obj;
        if (this.name != other.name && (this.name == null || !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.name != null ? this.name.hashCode() : 0;
        return hash;
    }
}
