/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "student_faq")
@NamedQueries({
    @NamedQuery(name = "StudentFaq.findByStudent", query = "SELECT s FROM StudentFaq s WHERE s.student = ?1"), 
    @NamedQuery(name = "StudentFaq.findByConvincedRate", query = "SELECT s FROM StudentFaq s WHERE s.convincedRate = ?1"), 
    @NamedQuery(name = "StudentFaq.findByCreateUser", query = "SELECT s FROM StudentFaq s WHERE s.createUser = ?1"), 
    @NamedQuery(name = "StudentFaq.findByCreateDate", query = "SELECT s FROM StudentFaq s WHERE s.createDate =?1"),
    @NamedQuery(name = "StudentFaq.findByLastModifiedDate", query = "SELECT s FROM StudentFaq s WHERE s.lastModifiedDate = ?1"), 
    @NamedQuery(name = "StudentFaq.findByLastModifiedUser", query = "SELECT s FROM StudentFaq s WHERE s.lastModifiedUser = ?1")})
public class StudentFaq extends BaseModel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
  
   
    @Column(name = "convinced_rate")
    private String convincedRate;
    
    @JoinColumn(name = "faq", referencedColumnName = "id")
    @ManyToOne
    private Faq faq;
    @JoinColumn(name = "student", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne
    private Student student1;

    public StudentFaq() {
    }

    public StudentFaq(Long id) {
        this.id = id;
    }
    public String getConvincedRate() {
        return convincedRate;
    }

    public void setConvincedRate(String convincedRate) {
        this.convincedRate = convincedRate;
    }

    public Faq getFaq() {
        return faq;
    }

    public void setFaq(Faq faq) {
        this.faq = faq;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
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
        if (!(object instanceof StudentFaq)) {
            return false;
        }
        StudentFaq other = (StudentFaq) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.StudentFaq[student=" + id + "]";
    }

}
