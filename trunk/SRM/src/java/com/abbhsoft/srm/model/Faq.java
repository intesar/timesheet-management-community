/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "faq")
@NamedQueries({
    @NamedQuery(name = "Faq.findById", query = "SELECT f FROM Faq f WHERE f.id = ?1"),
    @NamedQuery(name = "Faq.findByQuestion", query = "SELECT f FROM Faq f WHERE f.question = ?1"), 
    @NamedQuery(name = "Faq.findByAnswer", query = "SELECT f FROM Faq f WHERE f.answer = ?1"), 
    @NamedQuery(name = "Faq.findByTag", query = "SELECT f FROM Faq f WHERE f.tag = ?1"),
    @NamedQuery(name = "Faq.findByCreateUser", query = "SELECT f FROM Faq f WHERE f.createUser = ?1"), 
    @NamedQuery(name = "Faq.findByCreateDate", query = "SELECT f FROM Faq f WHERE f.createDate = ?1"), 
    @NamedQuery(name = "Faq.findByLastModifiedUser", query = "SELECT f FROM Faq f WHERE f.lastModifiedUser = ?1"),
    @NamedQuery(name = "Faq.findByLastModifiedDate", query = "SELECT f FROM Faq f WHERE f.lastModifiedDate = ?1")})
public class Faq extends BaseModel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "question", nullable = false)
    private String question;
    @Column(name = "answer")
    private String answer;
    @Column(name = "tag")
    private String tag;
    @OneToMany(mappedBy = "faq")
    private Collection<StudentFaq> studentFaqCollection;

    public Faq() {
    }

    public Faq(Long id) {
        this.id = id;
    }

    public Faq(Long id, String question) {
        this.id = id;
        this.question = question;
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
        return question+" "+ answer+" "+ tag;
    }

}
