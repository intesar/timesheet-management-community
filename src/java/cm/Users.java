/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cm;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "users")
@NamedQueries({@NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"), @NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname = :firstname"), @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname"), @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"), @NamedQuery(name = "Users.findByOfficePhone", query = "SELECT u FROM Users u WHERE u.officePhone = :officePhone"), @NamedQuery(name = "Users.findByMobilePhone", query = "SELECT u FROM Users u WHERE u.mobilePhone = :mobilePhone"), @NamedQuery(name = "Users.findByFax", query = "SELECT u FROM Users u WHERE u.fax = :fax"), @NamedQuery(name = "Users.findByOtherPhone", query = "SELECT u FROM Users u WHERE u.otherPhone = :otherPhone")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "firstname", nullable = false)
    private String firstname;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "office_phone")
    private String officePhone;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "other_phone")
    private String otherPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserInvestment> userInvestmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "managerId")
    private Collection<Project> projectCollection;
    @OneToMany(mappedBy = "paidTo")
    private Collection<Payment> paymentCollection;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
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

    public Collection<UserInvestment> getUserInvestmentCollection() {
        return userInvestmentCollection;
    }

    public void setUserInvestmentCollection(Collection<UserInvestment> userInvestmentCollection) {
        this.userInvestmentCollection = userInvestmentCollection;
    }

    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         return this.firstname + " " + this.lastname;
    }

}
