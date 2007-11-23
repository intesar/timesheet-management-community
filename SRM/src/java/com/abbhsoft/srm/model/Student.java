/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.model;

import com.abbhsoft.srm.base.BaseModel;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@NamedQueries({
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = ?1"), 
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = ?1"), 
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = ?1"), 
    @NamedQuery(name = "Student.findByMi", query = "SELECT s FROM Student s WHERE s.mi = ?1"), 
    @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = ?1"), 
    @NamedQuery(name = "Student.findBySecondaryEmail", query = "SELECT s FROM Student s WHERE s.secondaryEmail = ?1"), 
    @NamedQuery(name = "Student.findByMobilePhone", query = "SELECT s FROM Student s WHERE s.mobilePhone = ?1"), 
    @NamedQuery(name = "Student.findByHomePhone", query = "SELECT s FROM Student s WHERE s.homePhone = ?1"), 
    @NamedQuery(name = "Student.findByFax", query = "SELECT s FROM Student s WHERE s.fax = ?1"), 
    @NamedQuery(name = "Student.findByOtherPhone", query = "SELECT s FROM Student s WHERE s.otherPhone = ?1"), 
    @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = ?1"), 
    @NamedQuery(name = "Student.findByEducation", query = "SELECT s FROM Student s WHERE s.education = ?1"), 
    @NamedQuery(name = "Student.findByVisaStatus", query = "SELECT s FROM Student s WHERE s.visaStatus = ?1"), 
    @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = ?1"), 
    @NamedQuery(name = "Student.findByAge", query = "SELECT s FROM Student s WHERE s.age = ?1"), 
    @NamedQuery(name = "Student.findByNationality", query = "SELECT s FROM Student s WHERE s.nationality = ?1"), 
    @NamedQuery(name = "Student.findByRefferedBy", query = "SELECT s FROM Student s WHERE s.refferedBy = ?1"), 
    @NamedQuery(name = "Student.findByExpectedStartDate", query = "SELECT s FROM Student s WHERE s.expectedStartDate = ?1"), 
    @NamedQuery(name = "Student.findByCreateUser", query = "SELECT s FROM Student s WHERE s.createUser = ?1"), 
    @NamedQuery(name = "Student.findByCreateDate", query = "SELECT s FROM Student s WHERE s.createDate = ?1"), 
    @NamedQuery(name = "Student.findByLastModifiedUser", query = "SELECT s FROM Student s WHERE s.lastModifiedUser = ?1"), 
    @NamedQuery(name = "Student.findByLastModifiedDate", query = "SELECT s FROM Student s WHERE s.lastModifiedDate = ?1"),
    @NamedQuery(name = "Student.findByLastModifiedDates", query = "SELECT s FROM Student s WHERE s.lastModifiedDate between ?1 and ?2"),
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s "),
    @NamedQuery(name = "Student.findAllEmails", query = "SELECT s.email FROM Student s "),
    @NamedQuery(name = "Student.findBySingleString", 
        query = "SELECT s FROM Student s WHERE " +
            "s.firstName like ?7 or " +
            "s.lastName like ?1 or s.email like ?2 or s.secondaryEmail like ?3 or" +
            //" or s.address.city like ?4 or s.address.state like ?5  "),
            " s.education like ?4 or s.visaStatus like ?5 " +
            " or s.nationality like ?6 "),
    @NamedQuery(name = "Student.findByFirstNameLastNameOrCityState", query = "SELECT s FROM Student s" +
    "   where (s.firstName like ?1 and s.lastName like ?2) or (s.address.city like ?3 and s.address.state like ?4)"),
    @NamedQuery(name ="Student.findByPhoneNumber", query = "SELECT s FROM Student s WHERE s.homePhone like ?1 or " +
    "s.mobilePhone like ?2 or s.fax like ?3 or s.otherPhone like ?4 or s.age like ?5")})
public class Student extends BaseModel implements java.io.Serializable {
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
    @JoinColumn(name = "address", referencedColumnName = "id")
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Address address;
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
    @Column(name="tag")
    private String tag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Query> queryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Event> eventCollection;

    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }
    @JoinColumn(name = "group_", referencedColumnName = "id")
    @ManyToOne
    private EmailGroup group1;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    

    public Collection<Query> getQueryCollection() {
        return queryCollection;
    }

    public void setQueryCollection(Collection<Query> queryCollection) {
        this.queryCollection = queryCollection;
    }

    public EmailGroup getGroup1() {
        return group1;
    }

    public void setGroup1(EmailGroup group1) {
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
        return firstName+" "+ lastName+ " "+email+" "+ this.mobilePhone;
    }

}
