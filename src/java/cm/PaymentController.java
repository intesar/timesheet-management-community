/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cm;

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
public class PaymentController {
    private Payment payment = null;
    private DataModel model = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "WebApplication15PU")
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public int batchSize = 20;
    public int firstItem = 0;

    public DataModel getDetailPayments() {
        return model;
    }

    public void setDetailPayments(Collection<Payment> m) {
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

    public String createFromTaskSetup() {
        this.payment = new cm.Payment();
        EntityManager em = getEntityManager();
        try {
            payment.setTask(em.find(Task.class, getTaskController().getTask().getId()));
        } finally {
            em.close();
        }
        return "payment_create";
    }

    public String createFromTask() {
        create();
        getTaskController().setTask(payment.getTask());
        return "task_detail";
    }

    public String destroyFromUsers() {
        Users param = getUsersController().getUsers();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getUsersController().setUsers(em.find(Users.class, param.getId()));
        } finally {
            em.close();
        }
        return "users_detail";
    }

    private UsersController getUsersController() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (UsersController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "users");
    }

    public String createFromUsersSetup() {
        this.payment = new cm.Payment();
        EntityManager em = getEntityManager();
        try {
            payment.setPaidTo(em.find(Users.class, getUsersController().getUsers().getId()));
        } finally {
            em.close();
        }
        return "payment_create";
    }

    public String createFromUsers() {
        create();
        getUsersController().setUsers(payment.getPaidTo());
        return "users_detail";
    }

    public String destroyFromPaymentTypes() {
        PaymentTypes param = getPaymentTypesController().getPaymentTypes();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getPaymentTypesController().setPaymentTypes(em.find(PaymentTypes.class, param.getId()));
        } finally {
            em.close();
        }
        return "paymentTypes_detail";
    }

    private PaymentTypesController getPaymentTypesController() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (PaymentTypesController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "paymentTypes");
    }

    public String createFromPaymentTypesSetup() {
        this.payment = new cm.Payment();
        EntityManager em = getEntityManager();
        try {
            payment.setPaymentType(em.find(PaymentTypes.class, getPaymentTypesController().getPaymentTypes().getId()));
        } finally {
            em.close();
        }
        return "payment_create";
    }

    public String createFromPaymentTypes() {
        create();
        getPaymentTypesController().setPaymentTypes(payment.getPaymentType());
        return "paymentTypes_detail";
    }

    public String destroyFromPercentageValues() {
        PercentageValues param = getPercentageValuesController().getPercentageValues();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getPercentageValuesController().setPercentageValues(em.find(PercentageValues.class, param.getId()));
        } finally {
            em.close();
        }
        return "percentageValues_detail";
    }

    private PercentageValuesController getPercentageValuesController() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (PercentageValuesController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "percentageValues");
    }

    public String createFromPercentageValuesSetup() {
        this.payment = new cm.Payment();
        EntityManager em = getEntityManager();
        try {
            payment.setPercentageTaskCompleted(em.find(PercentageValues.class, getPercentageValuesController().getPercentageValues().getId()));
        } finally {
            em.close();
        }
        return "payment_create";
    }

    public String createFromPercentageValues() {
        create();
        getPercentageValuesController().setPercentageValues(payment.getPercentageTaskCompleted());
        return "percentageValues_detail";
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String createSetup() {
        this.payment = new cm.Payment();
        return "payment_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(payment);
            Task task = payment.getTask();
            if (task != null) {
                task = em.merge(task);
                task.getPaymentCollection().add(payment);
                task = em.merge(task);
            }
            Users users = payment.getPaidTo();
            if (users != null) {
                users = em.merge(users);
                users.getPaymentCollection().add(payment);
                users = em.merge(users);
            }
            PaymentTypes paymentTypes = payment.getPaymentType();
            if (paymentTypes != null) {
                paymentTypes = em.merge(paymentTypes);
                paymentTypes.getPaymentCollection().add(payment);
                paymentTypes = em.merge(paymentTypes);
            }
            PercentageValues percentageValues = payment.getPercentageTaskCompleted();
            if (percentageValues != null) {
                percentageValues = em.merge(percentageValues);
                percentageValues.getPaymentCollection().add(payment);
                percentageValues = em.merge(percentageValues);
            }
            utx.commit();
            addSuccessMessage("Payment was successfully created.");
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
        return "payment_list";
    }

    public String detailSetup() {
        setPaymentFromRequestParam();
        return "payment_detail";
    }

    public String editSetup() {
        setPaymentFromRequestParam();
        return "payment_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Task taskOld = em.find(cm.Payment.class, payment.getId()).getTask();
            Users paidToOld = em.find(cm.Payment.class, payment.getId()).getPaidTo();
            PaymentTypes paymentTypeOld = em.find(cm.Payment.class, payment.getId()).getPaymentType();
            PercentageValues percentageTaskCompletedOld = em.find(cm.Payment.class, payment.getId()).getPercentageTaskCompleted();
            payment = em.merge(payment);
            Task taskNew = payment.getTask();
            if (taskNew != null) {
                taskNew.getPaymentCollection().add(payment);
                taskNew = em.merge(taskNew);
            }
            if (taskOld != null) {
                taskOld.getPaymentCollection().remove(payment);
                taskOld = em.merge(taskOld);
            }
            Users paidToNew = payment.getPaidTo();
            if (paidToNew != null) {
                paidToNew.getPaymentCollection().add(payment);
                paidToNew = em.merge(paidToNew);
            }
            if (paidToOld != null) {
                paidToOld.getPaymentCollection().remove(payment);
                paidToOld = em.merge(paidToOld);
            }
            PaymentTypes paymentTypeNew = payment.getPaymentType();
            if (paymentTypeNew != null) {
                paymentTypeNew.getPaymentCollection().add(payment);
                paymentTypeNew = em.merge(paymentTypeNew);
            }
            if (paymentTypeOld != null) {
                paymentTypeOld.getPaymentCollection().remove(payment);
                paymentTypeOld = em.merge(paymentTypeOld);
            }
            PercentageValues percentageTaskCompletedNew = payment.getPercentageTaskCompleted();
            if (percentageTaskCompletedNew != null) {
                percentageTaskCompletedNew.getPaymentCollection().add(payment);
                percentageTaskCompletedNew = em.merge(percentageTaskCompletedNew);
            }
            if (percentageTaskCompletedOld != null) {
                percentageTaskCompletedOld.getPaymentCollection().remove(payment);
                percentageTaskCompletedOld = em.merge(percentageTaskCompletedOld);
            }
            utx.commit();
            addSuccessMessage("Payment was successfully updated.");
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
        return "payment_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            cm.Payment payment = getPaymentFromRequestParam();
            payment = em.merge(payment);
            Task task = payment.getTask();
            if (task != null) {
                task = em.merge(task);
                task.getPaymentCollection().remove(payment);
                task = em.merge(task);
            }
            Users users = payment.getPaidTo();
            if (users != null) {
                users = em.merge(users);
                users.getPaymentCollection().remove(payment);
                users = em.merge(users);
            }
            PaymentTypes paymentTypes = payment.getPaymentType();
            if (paymentTypes != null) {
                paymentTypes = em.merge(paymentTypes);
                paymentTypes.getPaymentCollection().remove(payment);
                paymentTypes = em.merge(paymentTypes);
            }
            PercentageValues percentageValues = payment.getPercentageTaskCompleted();
            if (percentageValues != null) {
                percentageValues = em.merge(percentageValues);
                percentageValues.getPaymentCollection().remove(payment);
                percentageValues = em.merge(percentageValues);
            }
            em.remove(payment);
            utx.commit();
            addSuccessMessage("Payment was successfully deleted.");
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
        return "payment_list";
    }

    public Payment getPaymentFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            cm.Payment o = (cm.Payment) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setPaymentFromRequestParam() {
        cm.Payment payment = getPaymentFromRequestParam();
        setPayment(payment);
    }

    public DataModel getPayments() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Payment as o");
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

    public Payment findPayment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            cm.Payment o = (cm.Payment) em.find(cm.Payment.class, id);
            return o;
        } finally {
            em.close();
        }
    }

    public SelectItem[] getTasks() {
        EntityManager em = getEntityManager();
        try {
            List<Task> l = (List<Task>) em.createQuery("select o from Task as o").getResultList();
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

    public SelectItem[] getPaidTos() {
        EntityManager em = getEntityManager();
        try {
            List<Users> l = (List<Users>) em.createQuery("select o from Users as o").getResultList();
            SelectItem[] select = new SelectItem[l.size()];
            int i = 0;
            for (Users x : l) {
                select[i++] = new SelectItem(x);
            }
            return select;
        } finally {
            em.close();
        }
    }

    public SelectItem[] getPaymentTypes() {
        EntityManager em = getEntityManager();
        try {
            List<PaymentTypes> l = (List<PaymentTypes>) em.createQuery("select o from PaymentTypes as o").getResultList();
            SelectItem[] select = new SelectItem[l.size()];
            int i = 0;
            for (PaymentTypes x : l) {
                select[i++] = new SelectItem(x);
            }
            return select;
        } finally {
            em.close();
        }
    }

    public SelectItem[] getPercentageTaskCompleteds() {
        EntityManager em = getEntityManager();
        try {
            List<PercentageValues> l = (List<PercentageValues>) em.createQuery("select o from PercentageValues as o").getResultList();
            SelectItem[] select = new SelectItem[l.size()];
            int i = 0;
            for (PercentageValues x : l) {
                select[i++] = new SelectItem(x);
            }
            return select;
        } finally {
            em.close();
        }
    }

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            int count = ((Long) em.createQuery("select count(o) from Payment as o").getSingleResult()).intValue();
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
        return "payment_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "payment_list";
    }

}
