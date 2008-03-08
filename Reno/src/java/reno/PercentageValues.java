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
@Table(name = "percentage_values")
@NamedQueries({@NamedQuery(name = "PercentageValues.findByPercentageCode", query = "SELECT p FROM PercentageValues p WHERE p.percentageCode = :percentageCode")})
public class PercentageValues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "percentage_code", nullable = false)
    private Integer percentageCode;
    @OneToMany(mappedBy = "percentageCompleted")
    private Collection<Task> taskCollection;
    @OneToMany(mappedBy = "percentageTaskCompleted")
    private Collection<Payment> paymentCollection;

    public PercentageValues() {
    }

    public PercentageValues(Integer percentageCode) {
        this.percentageCode = percentageCode;
    }

    public Integer getPercentageCode() {
        return percentageCode;
    }

    public void setPercentageCode(Integer percentageCode) {
        this.percentageCode = percentageCode;
    }

    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
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
        hash += (percentageCode != null ? percentageCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PercentageValues)) {
            return false;
        }
        PercentageValues other = (PercentageValues) object;
        if ((this.percentageCode == null && other.percentageCode != null) || (this.percentageCode != null && !this.percentageCode.equals(other.percentageCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return percentageCode.toString();
    }

}
