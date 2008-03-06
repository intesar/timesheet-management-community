/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cm;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "priority_types")
@NamedQueries({@NamedQuery(name = "PriorityTypes.findById", query = "SELECT p FROM PriorityTypes p WHERE p.id = :id"), @NamedQuery(name = "PriorityTypes.findByPriorityCode", query = "SELECT p FROM PriorityTypes p WHERE p.priorityCode = :priorityCode")})
public class PriorityTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "priority_code", nullable = false)
    private String priorityCode;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "priorityTypes")
    private Task task;

    public PriorityTypes() {
    }

    public PriorityTypes(Integer id) {
        this.id = id;
    }

    public PriorityTypes(Integer id, String priorityCode) {
        this.id = id;
        this.priorityCode = priorityCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriorityCode() {
        return priorityCode;
    }

    public void setPriorityCode(String priorityCode) {
        this.priorityCode = priorityCode;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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
        if (!(object instanceof PriorityTypes)) {
            return false;
        }
        PriorityTypes other = (PriorityTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       return this.priorityCode;
    }

}
