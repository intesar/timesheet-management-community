/*
 * Item.java
 * 
 * Created on Aug 20, 2007, 9:11:44 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "_item")
@NamedQueries({@NamedQuery(name = "Item.findByItemNo", query = "SELECT i FROM Item i WHERE i.itemNo = :itemNo"), @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"), @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description"), @NamedQuery(name = "Item.findByIngredients", query = "SELECT i FROM Item i WHERE i.ingredients = :ingredients"), @NamedQuery(name = "Item.findByQuantity", query = "SELECT i FROM Item i WHERE i.quantity = :quantity"), @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price")})
public class Item implements Serializable {
    @Id
    @Column(name = "item_no", nullable = false)
    private Integer itemNo;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "ingredients", nullable = false)
    private String ingredients;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "price", nullable = false)
    private double price;
    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<CatagoryItem> catagoryItemCollection;

    public Item() {
    }

    public Item(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Item(Integer itemNo, String name, String description, String ingredients, int quantity, double price, byte[] image) {
        this.itemNo = itemNo;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Collection<CatagoryItem> getCatagoryItemCollection() {
        return catagoryItemCollection;
    }

    public void setCatagoryItemCollection(Collection<CatagoryItem> catagoryItemCollection) {
        this.catagoryItemCollection = catagoryItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemNo != null ? itemNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if (this.itemNo != other.itemNo && (this.itemNo == null || !this.itemNo.equals(other.itemNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.ecommerce.model.Item[itemNo=" + itemNo + "]";
    }

}
