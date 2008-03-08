/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reno;

import java.util.Collection;
import javax.annotation.Resource;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;
import javax.transaction.UserTransaction;

/**
 *
 * @author intesar
 */
public class PercentageValuesController {
    private PercentageValues percentageValues = null;
    private DataModel model = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "RenoPU")
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public int batchSize = 20;
    public int firstItem = 0;

    public DataModel getDetailPercentageValuess() {
        return model;
    }

    public void setDetailPercentageValuess(Collection<PercentageValues> m) {
        model = new ListDataModel(new ArrayList(m));
    }

    public String destroyFromTask() {
        Task param = getTaskController().getTask();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getTaskController().setTask(em.find(Task.class, param.getId()));
        } finally {
            em.close();
        }
        return "task_detail";
    }

    private TaskController getTaskController() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (TaskController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "task");
    }

    public SelectItem[] getTaskCollectionAvailable() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select o from Task as o where o.percentageCompleted <> :param or o.percentageCompleted IS NULL");
            q.setParameter("param", percentageValues);
            List<Task> l = (List<Task>) q.getResultList();
            SelectItem[] select = new SelectItem[l.size()];
            int i = 0;
            for (Task x : l) {
                select[i++] = new SelectItem(x);
            }
            return select;
        } finally {
            em.close();
        }
    }
    public Task[] taskCollection = null;

    public Task[] getTaskCollectionToAdd() {
        return taskCollection;
    }

    public void setTaskCollectionToAdd(Task[] taskCollection) {
        this.taskCollection = taskCollection;
    }

    public String addTaskCollection() {
        if (taskCollection == null || taskCollection.length == 0) {
            addErrorMessage("You must select one or more tasks to add.");
            return null;
        }
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            for (Task entity : taskCollection) {
                entity.setPercentageCompleted(percentageValues);
                entity = em.merge(entity);
                percentageValues.getTaskCollection().add(entity);
            }
            percentageValues = em.merge(percentageValues);
            utx.commit();
            setPercentageValues(percentageValues);
            addSuccessMessage("Task successfully added.");
        } catch (Exception ex) {
            try {
                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                addErrorMessage(e.getLocalizedMessage());
            }
            return null;
        } finally {
            em.close();
        }
        return "percentageValues_detail";
    }

    public String removeTaskCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Task entity = (Task) getTaskController().getDetailTasks().getRowData();
            entity.setPercentageCompleted(null);
            entity = em.merge(entity);
            percentageValues.getTaskCollection().remove(entity);
            percentageValues = em.merge(percentageValues);
            utx.commit();
            setPercentageValues(percentageValues);
            addSuccessMessage("Task successfully removed.");
        } catch (Exception ex) {
            try {
                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                addErrorMessage(e.getLocalizedMessage());
            }
            return null;
        } finally {
            em.close();
        }
        return "percentageValues_detail";
    }

    public String createFromTaskSetup() {
        this.percentageValues = new reno.PercentageValues();
        EntityManager em = getEntityManager();
        try {
            if (percentageValues.getTaskCollection() == null) {
                percentageValues.setTaskCollection(new ArrayList());
            }
            percentageValues.getTaskCollection().add(em.find(Task.class, getTaskController().getTask().getId()));
        } finally {
            em.close();
        }
        return "percentageValues_create";
    }

    public String createFromTask() {
        create();
        getTaskController().setTask(percentageValues.getTaskCollection().iterator().next());
        return "task_detail";
    }

    public String destroyFromPayment() {
        Payment param = getPaymentController().getPayment();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getPaymentController().setPayment(em.find(Payment.class, param.getId()));
        } finally {
            em.close();
        }
        return "payment_detail";
    }

    private PaymentController getPaymentController() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (PaymentController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "payment");
    }

    public SelectItem[] getPaymentCollectionAvailable() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select o from Payment as o where o.percentageTaskCompleted <> :param or o.percentageTaskCompleted IS NULL");
            q.setParameter("param", percentageValues);
            List<Payment> l = (List<Payment>) q.getResultList();
            SelectItem[] select = new SelectItem[l.size()];
            int i = 0;
            for (Payment x : l) {
                select[i++] = new SelectItem(x);
            }
            return select;
        } finally {
            em.close();
        }
    }
    public Payment[] paymentCollection = null;

    public Payment[] getPaymentCollectionToAdd() {
        return paymentCollection;
    }

    public void setPaymentCollectionToAdd(Payment[] paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public String addPaymentCollection() {
        if (paymentCollection == null || paymentCollection.length == 0) {
            addErrorMessage("You must select one or more payments to add.");
            return null;
        }
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            for (Payment entity : paymentCollection) {
                entity.setPercentageTaskCompleted(percentageValues);
                entity = em.merge(entity);
                percentageValues.getPaymentCollection().add(entity);
            }
            percentageValues = em.merge(percentageValues);
            utx.commit();
            setPercentageValues(percentageValues);
            addSuccessMessage("Payment successfully added.");
        } catch (Exception ex) {
            try {
                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                addErrorMessage(e.getLocalizedMessage());
            }
            return null;
        } finally {
            em.close();
        }
        return "percentageValues_detail";
    }

    public String removePaymentCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Payment entity = (Payment) getPaymentController().getDetailPayments().getRowData();
            entity.setPercentageTaskCompleted(null);
            entity = em.merge(entity);
            percentageValues.getPaymentCollection().remove(entity);
            percentageValues = em.merge(percentageValues);
            utx.commit();
            setPercentageValues(percentageValues);
            addSuccessMessage("Payment successfully removed.");
        } catch (Exception ex) {
            try {
                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                addErrorMessage(e.getLocalizedMessage());
            }
            return null;
        } finally {
            em.close();
        }
        return "percentageValues_detail";
    }

    public String createFromPaymentSetup() {
        this.percentageValues = new reno.PercentageValues();
        EntityManager em = getEntityManager();
        try {
            if (percentageValues.getPaymentCollection() == null) {
                percentageValues.setPaymentCollection(new ArrayList());
            }
            percentageValues.getPaymentCollection().add(em.find(Payment.class, getPaymentController().getPayment().getId()));
        } finally {
            em.close();
        }
        return "percentageValues_create";
    }

    public String createFromPayment() {
        create();
        getPaymentController().setPayment(percentageValues.getPaymentCollection().iterator().next());
        return "payment_detail";
    }

    public PercentageValues getPercentageValues() {
        return percentageValues;
    }

    public void setPercentageValues(PercentageValues percentageValues) {
        this.percentageValues = percentageValues;
        getTaskController().setDetailTasks(percentageValues.getTaskCollection());
        getPaymentController().setDetailPayments(percentageValues.getPaymentCollection());
    }

    public String createSetup() {
        this.percentageValues = new reno.PercentageValues();
        if (percentageValues.getTaskCollection() == null) {
            percentageValues.setTaskCollection(new ArrayList<Task>());
        }
        if (percentageValues.getPaymentCollection() == null) {
            percentageValues.setPaymentCollection(new ArrayList<Payment>());
        }
        return "percentageValues_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(percentageValues);
            for (Task task : percentageValues.getTaskCollection()) {
                task = em.merge(task);
                task.setPercentageCompleted(percentageValues);
                task = em.merge(task);
            }
            for (Payment payment : percentageValues.getPaymentCollection()) {
                payment = em.merge(payment);
                payment.setPercentageTaskCompleted(percentageValues);
                payment = em.merge(payment);
            }
            utx.commit();
            addSuccessMessage("PercentageValues was successfully created.");
        } catch (Exception ex) {
            try {
                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                addErrorMessage(e.getLocalizedMessage());
            }
            return null;
        } finally {
            em.close();
        }
        return "percentageValues_list";
    }

    public String detailSetup() {
        setPercentageValuesFromRequestParam();
        return "percentageValues_detail";
    }

    public String editSetup() {
        setPercentageValuesFromRequestParam();
        return "percentageValues_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Collection<Task> tasksOld = em.find(reno.PercentageValues.class, percentageValues.getPercentageCode()).getTaskCollection();
            Collection<Payment> paymentsOld = em.find(reno.PercentageValues.class, percentageValues.getPercentageCode()).getPaymentCollection();
            percentageValues = em.merge(percentageValues);
            Collection<Task> tasksNew = percentageValues.getTaskCollection();
            for (Task taskNew : tasksNew) {
                taskNew.setPercentageCompleted(percentageValues);
                taskNew = em.merge(taskNew);
            }
            for (Task taskOld : tasksOld) {
                taskOld.setPercentageCompleted(null);
                taskOld = em.merge(taskOld);
            }
            Collection<Payment> paymentsNew = percentageValues.getPaymentCollection();
            for (Payment paymentNew : paymentsNew) {
                paymentNew.setPercentageTaskCompleted(percentageValues);
                paymentNew = em.merge(paymentNew);
            }
            for (Payment paymentOld : paymentsOld) {
                paymentOld.setPercentageTaskCompleted(null);
                paymentOld = em.merge(paymentOld);
            }
            utx.commit();
            addSuccessMessage("PercentageValues was successfully updated.");
        } catch (Exception ex) {
            try {
                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                addErrorMessage(e.getLocalizedMessage());
            }
            return null;
        } finally {
            em.close();
        }
        return "percentageValues_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            reno.PercentageValues percentageValues = getPercentageValuesFromRequestParam();
            percentageValues = em.merge(percentageValues);
            Collection<Task> tasks = percentageValues.getTaskCollection();
            for (Task task : tasks) {
                task = em.merge(task);
                task.setPercentageCompleted(null);
                task = em.merge(task);
            }
            Collection<Payment> payments = percentageValues.getPaymentCollection();
            for (Payment payment : payments) {
                payment = em.merge(payment);
                payment.setPercentageTaskCompleted(null);
                payment = em.merge(payment);
            }
            em.remove(percentageValues);
            utx.commit();
            addSuccessMessage("PercentageValues was successfully deleted.");
        } catch (Exception ex) {
            try {
                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                addErrorMessage(e.getLocalizedMessage());
            }
            return null;
        } finally {
            em.close();
        }
        return "percentageValues_list";
    }

    public PercentageValues getPercentageValuesFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            reno.PercentageValues o = (reno.PercentageValues) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setPercentageValuesFromRequestParam() {
        reno.PercentageValues percentageValues = getPercentageValuesFromRequestParam();
        setPercentageValues(percentageValues);
    }

    public DataModel getPercentageValuess() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from PercentageValues as o");
            q.setMaxResults(batchSize);
            q.setFirstResult(firstItem);
            model = new ListDataModel(q.getResultList());
            return model;
        } finally {
            em.close();
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("successInfo", facesMsg);
    }

    public PercentageValues findPercentageValues(Integer id) {
        EntityManager em = getEntityManager();
        try {
            reno.PercentageValues o = (reno.PercentageValues) em.find(reno.PercentageValues.class, id);
            return o;
        } finally {
            em.close();
        }
    }

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            int count = ((Long) em.createQuery("select count(o) from PercentageValues as o").getSingleResult()).intValue();
            return count;
        } finally {
            em.close();
        }
    }

    public int getFirstItem() {
        return firstItem;
    }

    public int getLastItem() {
        int size = getItemCount();
        return firstItem + batchSize > size ? size : firstItem + batchSize;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public String next() {
        if (firstItem + batchSize < getItemCount()) {
            firstItem += batchSize;
        }
        return "percentageValues_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "percentageValues_list";
    }

}
