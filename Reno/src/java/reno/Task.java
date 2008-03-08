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
@Table(name = "task")
@NamedQueries({@NamedQuery(name = "Task.findById", query = "SELECT t FROM Task t WHERE t.id = :id"), @NamedQuery(name = "Task.findByTitle", query = "SELECT t FROM Task t WHERE t.title = :title"), @NamedQuery(name = "Task.findByStartDate", query = "SELECT t FROM Task t WHERE t.startDate = :startDate"), @NamedQuery(name = "Task.findByEndDate", query = "SELECT t FROM Task t WHERE t.endDate = :endDate"), @NamedQuery(name = "Task.findByPlannedCompletionDate", query = "SELECT t FROM Task t WHERE t.plannedCompletionDate = :plannedCompletionDate"), @NamedQuery(name = "Task.findByCompletionDate", query = "SELECT t FROM Task t WHERE t.completionDate = :completionDate"), @NamedQuery(name = "Task.findByAllotedAmount", query = "SELECT t FROM Task t WHERE t.allotedAmount = :allotedAmount"), @NamedQuery(name = "Task.findByFinishDate", query = "SELECT t FROM Task t WHERE t.finishDate = :finishDate")})
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "planned_completion_date")
    private String plannedCompletionDate;
    @Column(name = "completion_date")
    private String completionDate;
    @Column(name = "alloted_amount")
    private Double allotedAmount;
    @Column(name = "finish_date")
    private String finishDate;
    @JoinColumn(name = "priority", referencedColumnName = "priority_code")
    @ManyToOne
    private PriorityTypes priority;
    @JoinColumn(name = "percentage_completed", referencedColumnName = "percentage_code")
    @ManyToOne
    private PercentageValues percentageCompleted;
    @JoinColumn(name = "status", referencedColumnName = "code")
    @ManyToOne
    private StatusCodes status;
    @JoinColumn(name = "project", referencedColumnName = "id")
    @ManyToOne
    private Project project;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private Collection<Payment> paymentCollection;

    public Task() {
    }

    public Task(Integer id) {
        this.id = id;
    }

    public Task(Integer id, String title) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPlannedCompletionDate() {
        return plannedCompletionDate;
    }

    public void setPlannedCompletionDate(String plannedCompletionDate) {
        this.plannedCompletionDate = plannedCompletionDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public Double getAllotedAmount() {
        return allotedAmount;
    }

    public void setAllotedAmount(Double allotedAmount) {
        this.allotedAmount = allotedAmount;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public PriorityTypes getPriority() {
        return priority;
    }

    public void setPriority(PriorityTypes priority) {
        this.priority = priority;
    }

    public PercentageValues getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(PercentageValues percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }

    public StatusCodes getStatus() {
        return status;
    }

    public void setStatus(StatusCodes status) {
        this.status = status;
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
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.title;
    }

}
