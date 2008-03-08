/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reno;

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
@Table(name = "priority_types")
@NamedQueries({@NamedQuery(name = "PriorityTypes.findByPriorityCode", query = "SELECT p FROM PriorityTypes p WHERE p.priorityCode = :priorityCode")})
public class PriorityTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "priority_code", nullable = false)
    private String priorityCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priority")
    private Collection<Task> taskCollection;

    public PriorityTypes() {
    }

    public PriorityTypes(String priorityCode) {
        this.priorityCode = priorityCode;
    }

    public String getPriorityCode() {
        return priorityCode;
    }

    public void setPriorityCode(String priorityCode) {
        this.priorityCode = priorityCode;
    }

    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (priorityCode != null ? priorityCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PriorityTypes)) {
            return false;
        }
        PriorityTypes other = (PriorityTypes) object;
        if ((this.priorityCode == null && other.priorityCode != null) || (this.priorityCode != null && !this.priorityCode.equals(other.priorityCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return priorityCode;
    }

}
