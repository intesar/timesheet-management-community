/*
 * CatagoryItemPK.java
 * 
 * Created on Aug 20, 2007, 9:11:44 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Mohammed Hamed
 */
@Embeddable
public class CatagoryItemPK implements Serializable {
    @Column(name = "item_no", nullable = false)
    private int itemNo;
    @Column(name = "catagory_name", nullable = false)
    private String catagoryName;

    public CatagoryItemPK() {
    }

    public CatagoryItemPK(int itemNo, String catagoryName) {
        this.itemNo = itemNo;
        this.catagoryName = catagoryName;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) itemNo;
        hash += (catagoryName != null ? catagoryName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof CatagoryItemPK)) {
            return false;
        }
        CatagoryItemPK other = (CatagoryItemPK) object;
        if (this.itemNo != other.itemNo) {
            return false;
        }
        if (this.catagoryName != other.catagoryName && (this.catagoryName == null || !this.catagoryName.equals(other.catagoryName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.ecommerce.model.CatagoryItemPK[itemNo=" + itemNo + ", catagoryName=" + catagoryName + "]";
    }

}
