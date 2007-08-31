/*
 * ItemContents1.java
 * 
 * Created on Aug 31, 2007, 11:03:22 AM
 * 
 *  All code belongs to Abbt organization any use of this code without
 *  permission or licence is subject to fine and procecution
 */

package com.abbhsoft.ecommerce.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Intesar.Mohammed
 */
@Entity
@Table(name = "item_contents")
@NamedQueries({@NamedQuery(name = "ItemContents.findById", query = "SELECT i FROM ItemContents i WHERE i.id = :id"), @NamedQuery(name = "ItemContents.findByContent", query = "SELECT i FROM ItemContents i WHERE i.content = :content")})
public class ItemContents implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "content", nullable = false)
    private String content;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne
    private Item itemId;

    public ItemContents() {
    }

    public ItemContents(Long id) {
        this.id = id;
    }

    public ItemContents(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
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
if (!(object instanceof ItemContents)) {
            return false;
        }
        ItemContents other = (ItemContents) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[id=" + id + "]";
    }

}
