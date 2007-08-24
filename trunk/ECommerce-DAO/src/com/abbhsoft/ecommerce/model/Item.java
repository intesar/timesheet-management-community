/*
 * Item.java
 * 
 * Created on Aug 21, 2007, 6:59:22 PM
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author shannan
 */
@Entity
@Table(name = "item")
@NamedQueries({@NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"), @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"), @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description"), @NamedQuery(name = "Item.findByIngredients", query = "SELECT i FROM Item i WHERE i.ingredients = :ingredients"), @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"), @NamedQuery(name = "Item.findByTax", query = "SELECT i FROM Item i WHERE i.tax = :tax"), @NamedQuery(name = "Item.findByIsEnabled", query = "SELECT i FROM Item i WHERE i.isEnabled = :isEnabled"), @NamedQuery(name = "Item.findByQuantityAvailable", query = "SELECT i FROM Item i WHERE i.quantityAvailable = :quantityAvailable")})
public class Item implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "price")
    private Double price;
    @Column(name = "tax")
    private Double tax;
    @Column(name = "is_enabled")
    private Short isEnabled;    
    @Column(name = "img_url")
    private String imgURL;
    @Column(name = "quantity_available")
    private Long quantityAvailable;
    @ManyToMany(mappedBy = "itemIdCollection")
    private Collection<Catagory> catagoryIdCollection;

    public Item() {
    }

    public Item(Long id) {
        this.id = id;
    }

    public Item(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Short getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Short isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Long getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Long quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Collection<Catagory> getCatagoryIdCollection() {
        return catagoryIdCollection;
    }

    public void setCatagoryIdCollection(Collection<Catagory> catagoryIdCollection) {
        this.catagoryIdCollection = catagoryIdCollection;
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
if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.ecommerce.model.Item[id=" + id + "]";
    }

}
