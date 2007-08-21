/*
 * CatagoryItem.java
 * 
 * Created on Aug 20, 2007, 9:11:44 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "catagory_item")
@NamedQueries({@NamedQuery(name = "CatagoryItem.findByItemNo", query = "SELECT c FROM CatagoryItem c WHERE c.catagoryItemPK.itemNo = :itemNo"), @NamedQuery(name = "CatagoryItem.findByCatagoryName", query = "SELECT c FROM CatagoryItem c WHERE c.catagoryItemPK.catagoryName = :catagoryName")})
public class CatagoryItem implements Serializable {
    @EmbeddedId
    protected CatagoryItemPK catagoryItemPK;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "catagoryItem1")
    private CatagoryItem catagoryItem;
    @JoinColumns({@JoinColumn(name = "item_no", referencedColumnName = "item_no", insertable = false, updatable = false), @JoinColumn(name = "catagory_name", referencedColumnName = "catagory_name", insertable = false, updatable = false)})
    @OneToOne
    private CatagoryItem catagoryItem1;
    @JoinColumn(name = "item_no", referencedColumnName = "item_no", insertable = false, updatable = false)
    @ManyToOne
    private Item item;

    public CatagoryItem() {
    }

    public CatagoryItem(CatagoryItemPK catagoryItemPK) {
        this.catagoryItemPK = catagoryItemPK;
    }

    public CatagoryItem(int itemNo, String catagoryName) {
        this.catagoryItemPK = new CatagoryItemPK(itemNo, catagoryName);
    }

    public CatagoryItemPK getCatagoryItemPK() {
        return catagoryItemPK;
    }

    public void setCatagoryItemPK(CatagoryItemPK catagoryItemPK) {
        this.catagoryItemPK = catagoryItemPK;
    }

    public CatagoryItem getCatagoryItem() {
        return catagoryItem;
    }

    public void setCatagoryItem(CatagoryItem catagoryItem) {
        this.catagoryItem = catagoryItem;
    }

    public CatagoryItem getCatagoryItem1() {
        return catagoryItem1;
    }

    public void setCatagoryItem1(CatagoryItem catagoryItem1) {
        this.catagoryItem1 = catagoryItem1;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catagoryItemPK != null ? catagoryItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof CatagoryItem)) {
            return false;
        }
        CatagoryItem other = (CatagoryItem) object;
        if (this.catagoryItemPK != other.catagoryItemPK && (this.catagoryItemPK == null || !this.catagoryItemPK.equals(other.catagoryItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.ecommerce.model.CatagoryItem[catagoryItemPK=" + catagoryItemPK + "]";
    }

}
