/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "PHONE")
@NamedQueries({@NamedQuery(name = "Phone1.findByIid", query = "SELECT p FROM Phone1 p WHERE p.iid = :iid"), @NamedQuery(name = "Phone1.findByType", query = "SELECT p FROM Phone1 p WHERE p.type = :type"), @NamedQuery(name = "Phone1.findByNo", query = "SELECT p FROM Phone1 p WHERE p.no = :no"), @NamedQuery(name = "Phone1.findByCreateDate", query = "SELECT p FROM Phone1 p WHERE p.createDate = :createDate"), @NamedQuery(name = "Phone1.findByCreateUser", query = "SELECT p FROM Phone1 p WHERE p.createUser = :createUser"), @NamedQuery(name = "Phone1.findByLastModiifiedDate", query = "SELECT p FROM Phone1 p WHERE p.lastModiifiedDate = :lastModiifiedDate"), @NamedQuery(name = "Phone1.findByLastModiifiedUser", query = "SELECT p FROM Phone1 p WHERE p.lastModiifiedUser = :lastModiifiedUser"), @NamedQuery(name = "Phone1.findByVersionId", query = "SELECT p FROM Phone1 p WHERE p.versionId = :versionId")})
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IID", nullable = false)
    private BigDecimal iid;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "NO", nullable = false)
    private String no;
    @Column(name = "CREATE_ DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "CREATE_USER")
    private String createUser;
    @Column(name = "LAST_MODIIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastModiifiedDate;
    @Column(name = "LAST_MODIIFIED_USER")
    private String lastModiifiedUser;
    @Column(name = "VERSION_ID")
    private BigInteger versionId;
    @OneToMany(mappedBy = "phone")
    private Collection<Instructor> instructor1Collection;

    public Phone() {
    }

    public Phone(BigDecimal iid) {
        this.iid = iid;
    }

    public Phone(BigDecimal iid, String no) {
        this.iid = iid;
        this.no = no;
    }

    public BigDecimal getIid() {
        return iid;
    }

    public void setIid(BigDecimal iid) {
        this.iid = iid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getLastModiifiedDate() {
        return lastModiifiedDate;
    }

    public void setLastModiifiedDate(Date lastModiifiedDate) {
        this.lastModiifiedDate = lastModiifiedDate;
    }

    public String getLastModiifiedUser() {
        return lastModiifiedUser;
    }

    public void setLastModiifiedUser(String lastModiifiedUser) {
        this.lastModiifiedUser = lastModiifiedUser;
    }

    public BigInteger getVersionId() {
        return versionId;
    }

    public void setVersionId(BigInteger versionId) {
        this.versionId = versionId;
    }

    public Collection<Instructor> getInstructor1Collection() {
        return instructor1Collection;
    }

    public void setInstructor1Collection(Collection<Instructor> instructor1Collection) {
        this.instructor1Collection = instructor1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iid != null ? iid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.iid == null && other.iid != null) || (this.iid != null && !this.iid.equals(other.iid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.trainingschedular.model.Phone1[iid=" + iid + "]";
    }

}
