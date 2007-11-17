/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdshannan
 */
@Entity
@Table(name = "student")
@NamedQueries({@NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"), @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"), @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName"), @NamedQuery(name = "Student.findByMi", query = "SELECT s FROM Student s WHERE s.mi = :mi"), @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email"), @NamedQuery(name = "Student.findBySecondaryEmail", query = "SELECT s FROM Student s WHERE s.secondaryEmail = :secondaryEmail"), @NamedQuery(name = "Student.findByMobilePhone", query = "SELECT s FROM Student s WHERE s.mobilePhone = :mobilePhone"), @NamedQuery(name = "Student.findByHomePhone", query = "SELECT s FROM Student s WHERE s.homePhone = :homePhone"), @NamedQuery(name = "Student.findByFax", query = "SELECT s FROM Student s WHERE s.fax = :fax"), @NamedQuery(name = "Student.findByOtherPhone", query = "SELECT s FROM Student s WHERE s.otherPhone = :otherPhone"), @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address"), @NamedQuery(name = "Student.findByEducation", query = "SELECT s FROM Student s WHERE s.education = :education"), @NamedQuery(name = "Student.findByVisaStatus", query = "SELECT s FROM Student s WHERE s.visaStatus = :visaStatus"), @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender"), @NamedQuery(name = "Student.findByAge", query = "SELECT s FROM Student s WHERE s.age = :age"), @NamedQuery(name = "Student.findByNationality", query = "SELECT s FROM Student s WHERE s.nationality = :nationality"), @NamedQuery(name = "Student.findByRefferedBy", query = "SELECT s FROM Student s WHERE s.refferedBy = :refferedBy"), @NamedQuery(name = "Student.findByExpectedStartDate", query = "SELECT s FROM Student s WHERE s.expectedStartDate = :expectedStartDate"), @NamedQuery(name = "Student.findByCreateUser", query = "SELECT s FROM Student s WHERE s.createUser = :createUser"), @NamedQuery(name = "Student.findByCreateDate", query = "SELECT s FROM Student s WHERE s.createDate = :createDate"), @NamedQuery(name = "Student.findByLastModifiedUser", query = "SELECT s FROM Student s WHERE s.lastModifiedUser = :lastModifiedUser"), @NamedQuery(name = "Student.findByLastModifiedDate", query = "SELECT s FROM Student s WHERE s.lastModifiedDate = :lastModifiedDate")})
public class Student extends BaseModel {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "mi")
    private String mi;
    @Column(name = "email")
    private String email;
    @Column(name = "secondary_email")
    private String secondaryEmail;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "home_phone")
    private String homePhone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "other_phone")
    private String otherPhone;
    @Column(name = "address")
    private String address;
    @Column(name = "education")
    private String education;
    @Column(name = "visa_status")
    private String visaStatus;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private String age;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "reffered_by")
    private String refferedBy;
    @Column(name = "expected_start_date")
    @Temporal(TemporalType.DATE)
    private Date expectedStartDate;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Query> queryCollection;
    @JoinColumn(name = "group", referencedColumnName = "id")
    @ManyToOne
    private Group1 group1;
    @JoinColumn(name = "university", referencedColumnName = "id")
    @ManyToOne
    private University university;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student1")
    private StudentFaq studentFaq;

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(Long id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }
  public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRefferedBy() {
        return refferedBy;
    }

    public void setRefferedBy(String refferedBy) {
        this.refferedBy = refferedBy;
    }

    public Date getExpectedStartDate() {
        return expectedStartDate;
    }

    public void setExpectedStartDate(Date expectedStartDate) {
        this.expectedStartDate = expectedStartDate;
    }
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Collection<Query> getQueryCollection() {
        return queryCollection;
    }

    public void setQueryCollection(Collection<Query> queryCollection) {
        this.queryCollection = queryCollection;
    }

    public Group1 getGroup1() {
        return group1;
    }

    public void setGroup1(Group1 group1) {
        this.group1 = group1;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public StudentFaq getStudentFaq() {
        return studentFaq;
    }

    public void setStudentFaq(StudentFaq studentFaq) {
        this.studentFaq = studentFaq;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbhsoft.srm.model.Student[id=" + id + "]";
    }

}
