/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "event")
@NamedQueries({
    @NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = ?1"), 
    @NamedQuery(name = "Event.findByDate", query = "SELECT e FROM Event e WHERE e.date = ?1"), 
    @NamedQuery(name = "Event.findByType", query = "SELECT e FROM Event e WHERE e.type = ?1"), 
    @NamedQuery(name = "Event.findByDescript", query = "SELECT e FROM Event e WHERE e.descript = ?1"),
    @NamedQuery(name = "Event.findByStudent", query = "SELECT e FROM Event e WHERE e.student = ?1"),
    @NamedQuery(name = "Event.findByGroup", query = "SELECT e FROM Event e WHERE e.group1 = ?1"), 
    @NamedQuery(name = "Event.findByUniversity", query = "SELECT e FROM Event e WHERE e.university = ?1"), 
    @NamedQuery(name = "Event.findByCreateDate", query = "SELECT e FROM Event e WHERE e.createDate = ?1"), 
    @NamedQuery(name = "Event.findByCreateUser", query = "SELECT e FROM Event e WHERE e.createUser = ?1"),
    @NamedQuery(name = "Event.findByLastModifiedUser", query = "SELECT e FROM Event e WHERE e.lastModifiedUser = ?1"), 
    @NamedQuery(name = "Event.findByLastModifiedDate", query = "SELECT e FROM Event e WHERE e.lastModifiedDate = ?1")})
public class Event extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "date_", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "type_")
    private String type;
    @Column(name = "descript")
    private String descript;
    @JoinColumn(name = "university", referencedColumnName = "id")
    @ManyToOne
    private University university;
    @JoinColumn(name = "group_", referencedColumnName = "id")
    @ManyToOne
    private EmailGroup group1;
    @JoinColumn(name = "student", referencedColumnName = "id")
    @ManyToOne
    private Student student;
   
    public Event() {
    }

    public Event(Long id) {
        this.id = id;
    }

    public Event(Date date, String type) {
        
        this.date = date;
        this.type = type;
        
    }

    public Event(Long id, Date date) {
        this.id = id;
        this.date = date;
        
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public EmailGroup getGroup1() {
        return group1;
    }

    public void setGroup1(EmailGroup group1) {
        this.group1 = group1;
    }

    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.Event[id=" + id + "]";
    }

}
