/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "payment")
@NamedQueries({@NamedQuery(name = "Payment.findById", query = "SELECT p FROM Payment p WHERE p.id = :id"), @NamedQuery(name = "Payment.findByAmount", query = "SELECT p FROM Payment p WHERE p.amount = :amount"), @NamedQuery(name = "Payment.findByPaymentDate", query = "SELECT p FROM Payment p WHERE p.paymentDate = :paymentDate")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "amount", nullable = false)
    private double amount;
    @Column(name = "payment_date")
    private String paymentDate;
    @Lob
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "task", referencedColumnName = "id")
    @ManyToOne
    private Task task;
    @JoinColumn(name = "paid_to", referencedColumnName = "id")
    @ManyToOne
    private Users paidTo;
    @JoinColumn(name = "payment_type", referencedColumnName = "id")
    @ManyToOne
    private PaymentTypes paymentType;
    @JoinColumn(name = "percentage_task_completed", referencedColumnName = "id")
    @ManyToOne
    private PercentageValues percentageTaskCompleted;

    public Payment() {
    }

    public Payment(Integer id) {
        this.id = id;
    }

    public Payment(Integer id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Users getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(Users paidTo) {
        this.paidTo = paidTo;
    }

    public PaymentTypes getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypes paymentType) {
        this.paymentType = paymentType;
    }

    public PercentageValues getPercentageTaskCompleted() {
        return percentageTaskCompleted;
    }

    public void setPercentageTaskCompleted(PercentageValues percentageTaskCompleted) {
        this.percentageTaskCompleted = percentageTaskCompleted;
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
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         return this.paidTo.getFirstname() + " " + this.paidTo.getLastname() + " " +
                this.amount;
    }

}
