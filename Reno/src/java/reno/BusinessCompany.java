/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reno;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "business_company")
@NamedQueries({@NamedQuery(name = "BusinessCompany.findById", query = "SELECT b FROM BusinessCompany b WHERE b.id = :id"), @NamedQuery(name = "BusinessCompany.findByName", query = "SELECT b FROM BusinessCompany b WHERE b.name = :name"), @NamedQuery(name = "BusinessCompany.findByOfficePhone", query = "SELECT b FROM BusinessCompany b WHERE b.officePhone = :officePhone"), @NamedQuery(name = "BusinessCompany.findByFax", query = "SELECT b FROM BusinessCompany b WHERE b.fax = :fax"), @NamedQuery(name = "BusinessCompany.findByMobilePhone", query = "SELECT b FROM BusinessCompany b WHERE b.mobilePhone = :mobilePhone")})
public class BusinessCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "office_phone")
    private String officePhone;
    @Column(name = "fax")
    private String fax;
    @Lob
    @Column(name = "address")
    private String address;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @JoinColumn(name = "project", referencedColumnName = "id")
    @ManyToOne
    private Project project;
    @OneToMany(mappedBy = "paidToBusiness")
    private Collection<Payment> paymentCollection;

    public BusinessCompany() {
    }

    public BusinessCompany(Integer id) {
        this.id = id;
    }

    public BusinessCompany(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
        if (!(object instanceof BusinessCompany)) {
            return false;
        }
        BusinessCompany other = (BusinessCompany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
