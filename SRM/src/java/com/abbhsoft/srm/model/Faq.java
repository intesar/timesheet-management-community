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
@Table(name = "faq")
@NamedQueries({@NamedQuery(name = "Faq.findById", query = "SELECT f FROM Faq f WHERE f.id = :id"), @NamedQuery(name = "Faq.findByQuestion", query = "SELECT f FROM Faq f WHERE f.question = :question"), @NamedQuery(name = "Faq.findByAnswer", query = "SELECT f FROM Faq f WHERE f.answer = :answer"), @NamedQuery(name = "Faq.findByTag", query = "SELECT f FROM Faq f WHERE f.tag = :tag"), @NamedQuery(name = "Faq.findByCreateUser", query = "SELECT f FROM Faq f WHERE f.createUser = :createUser"), @NamedQuery(name = "Faq.findByCreateDate", query = "SELECT f FROM Faq f WHERE f.createDate = :createDate"), @NamedQuery(name = "Faq.findByLastModifiedUser", query = "SELECT f FROM Faq f WHERE f.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Faq.findByLastModifiedDate", query = "SELECT f FROM Faq f WHERE f.lastModifiedDate = :lastModifiedDate")})
public class Faq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "question", nullable = false)
    private String question;
    @Column(name = "answer")
    private String answer;
    @Column(name = "tag")
    private String tag;
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
    @OneToMany(mappedBy = "faq")
    private Collection<StudentFaq> studentFaqCollection;

    public Faq() {
    }

    public Faq(Integer id) {
        this.id = id;
    }

    public Faq(Integer id, String question) {
        this.id = id;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public Collection<StudentFaq> getStudentFaqCollection() {
        return studentFaqCollection;
    }

    public void setStudentFaqCollection(Collection<StudentFaq> studentFaqCollection) {
        this.studentFaqCollection = studentFaqCollection;
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
        if (!(object instanceof Faq)) {
            return false;
        }
        Faq other = (Faq) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.Faq[id=" + id + "]";
    }

}
