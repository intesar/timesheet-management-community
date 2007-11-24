/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.base;

/**
 *
 * @author Intesar.Mohammed
 */
import java.io.Serializable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Base class for all persisitent domain objects.
 * 
 * @author afernando
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;
    @Column(name = "create_user")
    protected Long createUser;
    @Column(name = "is_enable")
    protected Long isEnable;
    @Version
    @Column(name = "version_id")    
    protected Long versionId;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    protected Date createDate;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    protected Date lastModifiedDate;
    @Column(name = "last_modified_user")
    protected Long lastModifiedUser;
    // ****************************** ctors ******************************

    protected BaseModel() {
    // for hibernate
    }

    // ****************************** methods ******************************

    public String getKey() {
        return Long.toString(id);
    }

    // ****************************** getter & setters ******************************

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(Long lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Long getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Long isEnable) {
        this.isEnable = isEnable;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }
}
