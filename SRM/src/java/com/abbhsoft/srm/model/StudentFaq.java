/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "student_faq")
@NamedQueries({@NamedQuery(name = "StudentFaq.findByStudent", query = "SELECT s FROM StudentFaq s WHERE s.student = :student"), @NamedQuery(name = "StudentFaq.findByConvincedRate", query = "SELECT s FROM StudentFaq s WHERE s.convincedRate = :convincedRate"), @NamedQuery(name = "StudentFaq.findByCreateUser", query = "SELECT s FROM StudentFaq s WHERE s.createUser = :createUser"), @NamedQuery(name = "StudentFaq.findByCreateDate", query = "SELECT s FROM StudentFaq s WHERE s.createDate = :createDate"), @NamedQuery(name = "StudentFaq.findByLastModifiedDate", query = "SELECT s FROM StudentFaq s WHERE s.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "StudentFaq.findByLastModifiedUser", query = "SELECT s FROM StudentFaq s WHERE s.lastModifiedUser = :lastModifiedUser")})
public class StudentFaq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "student", nullable = false)
    private Integer student;
    @Column(name = "convinced_rate")
    private String convincedRate;
    @Column(name = "create_user")
    private Integer createUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
    @Column(name = "last_modified_user")
    private Integer lastModifiedUser;
    @JoinColumn(name = "faq", referencedColumnName = "id")
    @ManyToOne
    private Faq faq;
    @JoinColumn(name = "student", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne
    private Student student1;

    public StudentFaq() {
    }

    public StudentFaq(Integer student) {
        this.student = student;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public String getConvincedRate() {
        return convincedRate;
    }

    public void setConvincedRate(String convincedRate) {
        this.convincedRate = convincedRate;
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

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(Integer lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
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
        hash += (student != null ? student.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentFaq)) {
            return false;
        }
        StudentFaq other = (StudentFaq) object;
        if ((this.student == null && other.student != null) || (this.student != null && !this.student.equals(other.student))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.StudentFaq[student=" + student + "]";
    }

}
