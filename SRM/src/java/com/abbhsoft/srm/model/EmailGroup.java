/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "email_group")
@NamedQueries({
    @NamedQuery(name = "EmailGroup.findById", query = "SELECT g FROM EmailGroup g WHERE g.id = ?1"), 
    @NamedQuery(name = "EmailGroup.findByOwner", query = "SELECT g FROM EmailGroup g WHERE g.owner = ?1"),
    @NamedQuery(name = "EmailGroup.findBySubscribeEmail", query = "SELECT g FROM EmailGroup g WHERE g.subscribeEmail = ?1"), 
    @NamedQuery(name = "EmailGroup.findByGroupEmail", query = "SELECT g FROM EmailGroup g WHERE g.groupEmail = ?1"), 
    @NamedQuery(name = "EmailGroup.findByUnsubscribeEmail", query = "SELECT g FROM EmailGroup g WHERE g.unsubscribeEmail = ?1"),
    @NamedQuery(name = "EmailGroup.findByCreateUser", query = "SELECT g FROM EmailGroup g WHERE g.createUser = ?1"), 
    @NamedQuery(name = "EmailGroup.findByCreateDate", query = "SELECT g FROM EmailGroup g WHERE g.createDate = ?1"), 
    @NamedQuery(name = "EmailGroup.findByLastModifiedUser", query = "SELECT g FROM EmailGroup g WHERE g.lastModifiedUser = ?1"),
    @NamedQuery(name = "EmailGroup.findByLastModifiedDate", query = "SELECT g FROM EmailGroup g WHERE g.lastModifiedDate = ?1"),
    @NamedQuery(name = "EmailGroup.findByEventDates", query = "SELECT g FROM EmailGroup g WHERE g.lastModifiedDate between ?1 and ?2"),
    @NamedQuery(name = "EmailGroup.findAll", query = "SELECT g FROM EmailGroup g "),
    @NamedQuery(name = "EmailGroup.findByEmails", query = "SELECT g FROM EmailGroup g " +
    "   where g.owner like ?1 or g.subscribeEmail like ?2 or g.groupEmail like ?3 or g.unsubscribeEmail like ?4")})
public class EmailGroup extends BaseModel implements java.io.Serializable  {
    private static final long serialVersionUID = 1L;
   
    @Column(name = "owner")
    private String owner;
    @Column(name = "subscribe_email")
    private String subscribeEmail;
    @Column(name = "group_email", nullable = false)
    private String groupEmail;
    @Column(name = "unsubscribe_email")
    private String unsubscribeEmail;
    @JoinColumn(name = "university", referencedColumnName = "id")
    @ManyToOne
    private University university;
    @OneToMany(mappedBy = "group1")
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "group1")
    private Collection<Event> eventCollection;

    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }
    public EmailGroup() {
    }

    public EmailGroup(Long id) {
        this.id = id;
    }

    public EmailGroup(Long id, String groupEmail) {
        this.id = id;
        this.groupEmail = groupEmail;
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
        if (!(object instanceof EmailGroup)) {
            return false;
        }
        EmailGroup other = (EmailGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return owner+" "+subscribeEmail+" "+unsubscribeEmail+" "+university;
    }

}