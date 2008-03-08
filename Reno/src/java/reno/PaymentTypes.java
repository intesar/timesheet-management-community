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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "payment_types")
@NamedQueries({@NamedQuery(name = "PaymentTypes.findByCode", query = "SELECT p FROM PaymentTypes p WHERE p.code = :code"), @NamedQuery(name = "PaymentTypes.findByDescription", query = "SELECT p FROM PaymentTypes p WHERE p.description = :description")})
public class PaymentTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToMany(mappedBy = "paymentType")
    private Collection<Payment> paymentCollection;

    public PaymentTypes() {
    }

    public PaymentTypes(String code) {
        this.code = code;
    }

    public PaymentTypes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentTypes)) {
            return false;
        }
        PaymentTypes other = (PaymentTypes) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code ;
    }

}
