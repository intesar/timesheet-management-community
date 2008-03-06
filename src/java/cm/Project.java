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
@Table(name = "project")
@NamedQueries({@NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p WHERE p.id = :id"), @NamedQuery(name = "Project.findByTitle", query = "SELECT p FROM Project p WHERE p.title = :title"), @NamedQuery(name = "Project.findByEstimatedBudget", query = "SELECT p FROM Project p WHERE p.estimatedBudget = :estimatedBudget"), @NamedQuery(name = "Project.findByEstimatedStartDate", query = "SELECT p FROM Project p WHERE p.estimatedStartDate = :estimatedStartDate"), @NamedQuery(name = "Project.findByEstimatedFinishDate", query = "SELECT p FROM Project p WHERE p.estimatedFinishDate = :estimatedFinishDate"), @NamedQuery(name = "Project.findByCurrentBalance", query = "SELECT p FROM Project p WHERE p.currentBalance = :currentBalance"), @NamedQuery(name = "Project.findByInvestedAmount", query = "SELECT p FROM Project p WHERE p.investedAmount = :investedAmount")})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "estimated_budget")
    private Double estimatedBudget;
    @Column(name = "estimated_start_date")
    private String estimatedStartDate;
    @Column(name = "estimated_finish_date")
    private String estimatedFinishDate;
    @Column(name = "current_balance")
    private Double currentBalance;
    @Column(name = "invested_amount")
    private Double investedAmount;
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @ManyToOne
    private Users managerId;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private StatusCodes status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<Task> taskCollection;

    public Project() {
    }

    public Project(Integer id) {
        this.id = id;
    }

    public Project(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(Double estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }

    public String getEstimatedStartDate() {
        return estimatedStartDate;
    }

    public void setEstimatedStartDate(String estimatedStartDate) {
        this.estimatedStartDate = estimatedStartDate;
    }

    public String getEstimatedFinishDate() {
        return estimatedFinishDate;
    }

    public void setEstimatedFinishDate(String estimatedFinishDate) {
        this.estimatedFinishDate = estimatedFinishDate;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Double getInvestedAmount() {
        return investedAmount;
    }

    public void setInvestedAmount(Double investedAmount) {
        this.investedAmount = investedAmount;
    }

    public Users getManagerId() {
        return managerId;
    }

    public void setManagerId(Users managerId) {
        this.managerId = managerId;
    }

    public StatusCodes getStatus() {
        return status;
    }

    public void setStatus(StatusCodes status) {
        this.status = status;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.title + " " + this.status;
    }

}
