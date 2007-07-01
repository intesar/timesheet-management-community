/*
 * UserLoginIpAudit.java
 * 
 * Created on Jul 1, 2007, 7:12:02 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "user_login_ip_audit")
@NamedQueries({@NamedQuery(name = "UserLoginIpAudit.findByUsername", query = "SELECT u FROM UserLoginIpAudit u WHERE u.username = :username"), @NamedQuery(name = "UserLoginIpAudit.findByLoginIp", query = "SELECT u FROM UserLoginIpAudit u WHERE u.loginIp = :loginIp"), @NamedQuery(name = "UserLoginIpAudit.findByAuditDate", query = "SELECT u FROM UserLoginIpAudit u WHERE u.auditDate = :auditDate"), @NamedQuery(name = "UserLoginIpAudit.findById", query = "SELECT u FROM UserLoginIpAudit u WHERE u.id = :id")})
public class UserLoginIpAudit implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "login_ip")
    private String loginIp;

    @Column(name = "audit_date")
    @Temporal(TemporalType.DATE)
    private Date auditDate;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    public UserLoginIpAudit() {
    }

    public UserLoginIpAudit(Integer id) {
        this.id = id;
    }

    public UserLoginIpAudit(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof UserLoginIpAudit)) {
            return false;
        }
        UserLoginIpAudit other = (UserLoginIpAudit) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.UserLoginIpAudit[id=" + id + "]";
    }

}
