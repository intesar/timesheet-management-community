/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "group")
@NamedQueries({@NamedQuery(name = "Group1.findById", query = "SELECT g FROM Group1 g WHERE g.id = :id"), @NamedQuery(name = "Group1.findByOwner", query = "SELECT g FROM Group1 g WHERE g.owner = :owner"), @NamedQuery(name = "Group1.findBySubscribeEmail", query = "SELECT g FROM Group1 g WHERE g.subscribeEmail = :subscribeEmail"), @NamedQuery(name = "Group1.findByGroupEmail", query = "SELECT g FROM Group1 g WHERE g.groupEmail = :groupEmail"), @NamedQuery(name = "Group1.findByUnsubscribeEmail", query = "SELECT g FROM Group1 g WHERE g.unsubscribeEmail = :unsubscribeEmail"), @NamedQuery(name = "Group1.findByCreateUser", query = "SELECT g FROM Group1 g WHERE g.createUser = :createUser"), @NamedQuery(name = "Group1.findByCreateDate", query = "SELECT g FROM Group1 g WHERE g.createDate = :createDate"), @NamedQuery(name = "Group1.findByLastModifiedUser", query = "SELECT g FROM Group1 g WHERE g.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Group1.findByLastModifiedDate", query = "SELECT g FROM Group1 g WHERE g.lastModifiedDate = :lastModifiedDate")})
public class Group1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "owner")
    private String owner;
    @Column(name = "subscribe_email")
    private String subscribeEmail;
    @Column(name = "group_email", nullable = false)
    private String groupEmail;
    @Column(name = "unsubscribe_email")
    private String unsubscribeEmail;
    @Column(name = "create_user")
    private Integer createUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "last_modified_user")
    private Integer lastModifiedUser;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
    @OneToMany(mappedBy = "group1")
    private Collection<Student> studentCollection;
    @JoinColumn(name = "university", referencedColumnName = "id")
    @ManyToOne
    private University university;

    public Group1() {
    }

    public Group1(Integer id) {
        this.id = id;
    }

    public Group1(Integer id, String groupEmail) {
        this.id = id;
        this.groupEmail = groupEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSubscribeEmail() {
        return subscribeEmail;
    }

    public void setSubscribeEmail(String subscribeEmail) {
        this.subscribeEmail = subscribeEmail;
    }

    public String getGroupEmail() {
        return groupEmail;
    }

    public void setGroupEmail(String groupEmail) {
        this.groupEmail = groupEmail;
    }

    public String getUnsubscribeEmail() {
        return unsubscribeEmail;
    }

    public void setUnsubscribeEmail(String unsubscribeEmail) {
        this.unsubscribeEmail = unsubscribeEmail;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(Integer lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
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
        if (!(object instanceof Group1)) {
            return false;
        }
        Group1 other = (Group1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.Group1[id=" + id + "]";
    }

}
