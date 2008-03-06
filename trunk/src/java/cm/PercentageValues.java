/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cm;

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
@NamedQueries({@NamedQuery(name = "PercentageValues.findById", query = "SELECT p FROM PercentageValues p WHERE p.id = :id"), @NamedQuery(name = "PercentageValues.findByPercentageCode", query = "SELECT p FROM PercentageValues p WHERE p.percentageCode = :percentageCode")})
public class PercentageValues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "percentage_code", nullable = false)
    private int percentageCode;
    @OneToMany(mappedBy = "percentageCompleted")
    private Collection<Task> taskCollection;
    @OneToMany(mappedBy = "percentageTaskCompleted")
    private Collection<Payment> paymentCollection;

    public PercentageValues() {
    }

    public PercentageValues(Integer id) {
        this.id = id;
    }

    public PercentageValues(Integer id, int percentageCode) {
        this.id = id;
        this.percentageCode = percentageCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPercentageCode() {
        return percentageCode;
    }

    public void setPercentageCode(int percentageCode) {
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PercentageValues)) {
            return false;
        }
        PercentageValues other = (PercentageValues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.percentageCode +"";
    }

}
