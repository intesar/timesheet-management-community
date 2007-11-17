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
@NamedQueries({@NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = :id"), @NamedQuery(name = "Event.findByDate", query = "SELECT e FROM Event e WHERE e.date = :date"), @NamedQuery(name = "Event.findByType", query = "SELECT e FROM Event e WHERE e.type = :type"), @NamedQuery(name = "Event.findByDescript", query = "SELECT e FROM Event e WHERE e.descript = :descript"), @NamedQuery(name = "Event.findByStudent", query = "SELECT e FROM Event e WHERE e.student = :student"), @NamedQuery(name = "Event.findByGroup", query = "SELECT e FROM Event e WHERE e.group = :group"), @NamedQuery(name = "Event.findByUniversity", query = "SELECT e FROM Event e WHERE e.university = :university"), @NamedQuery(name = "Event.findByCreateDate", query = "SELECT e FROM Event e WHERE e.createDate = :createDate"), @NamedQuery(name = "Event.findByCreateUser", query = "SELECT e FROM Event e WHERE e.createUser = :createUser"), @NamedQuery(name = "Event.findByLastModifiedUser", query = "SELECT e FROM Event e WHERE e.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Event.findByLastModifiedDate", query = "SELECT e FROM Event e WHERE e.lastModifiedDate = :lastModifiedDate")})
public class Event extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "type")
    private String type;
    @Column(name = "descript")
    private String descript;
    @Column(name = "student", nullable = false)
    private String student;
    @Column(name = "group", nullable = false)
    private String group;
    @Column(name = "university")
    private String university;
   
    public Event() {
    }

    public Event(Long id) {
        this.id = id;
    }

    public Event(Long id, Date date, String student, String group) {
        this.id = id;
        this.date = date;
        this.student = student;
        this.group = group;
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

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
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
