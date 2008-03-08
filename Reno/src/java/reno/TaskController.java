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
public class TaskController {
    private Task task = null;
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

    public DataModel getDetailTasks() {
        return model;
    }

    public void setDetailTasks(Collection<Task> m) {
        model = new ListDataModel(new ArrayList(m));
    }

    public String destroyFromPriorityTypes() {
        PriorityTypes param = getPriorityTypesController().getPriorityTypes();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getPriorityTypesController().setPriorityTypes(em.find(PriorityTypes.class, param.getPriorityCode()));
        } finally {
            em.close();
        }
        return "priorityTypes_detail";
    }

    private PriorityTypesController getPriorityTypesController() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (PriorityTypesController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "priorityTypes");
    }

    public String createFromPriorityTypesSetup() {
        this.task = new reno.Task();
        EntityManager em = getEntityManager();
        try {
            task.setPriority(em.find(PriorityTypes.class, getPriorityTypesController().getPriorityTypes().getPriorityCode()));
        } finally {
            em.close();
        }
        return "task_create";
    }

    public String createFromPriorityTypes() {
        create();
        getPriorityTypesController().setPriorityTypes(task.getPriority());
        return "priorityTypes_detail";
    }

    public String destroyFromPercentageValues() {
        PercentageValues param = getPercentageValuesController().getPercentageValues();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getPercentageValuesController().setPercentageValues(em.find(PercentageValues.class, param.getPercentageCode()));
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
        this.task = new reno.Task();
        EntityManager em = getEntityManager();
        try {
            task.setPercentageCompleted(em.find(PercentageValues.class, getPercentageValuesController().getPercentageValues().getPercentageCode()));
        } finally {
            em.close();
        }
        return "task_create";
    }

    public String createFromPercentageValues() {
        create();
        getPercentageValuesController().setPercentageValues(task.getPercentageCompleted());
        return "percentageValues_detail";
    }

    public String destroyFromStatusCodes() {
        StatusCodes param = getStatusCodesController().getStatusCodes();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getStatusCodesController().setStatusCodes(em.find(StatusCodes.class, param.getCode()));
        } finally {
            em.close();
        }
        return "statusCodes_detail";
    }

    private StatusCodesController getStatusCodesController() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (StatusCodesController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "statusCodes");
    }

    public String createFromStatusCodesSetup() {
        this.task = new reno.Task();
        EntityManager em = getEntityManager();
        try {
            task.setStatus(em.find(StatusCodes.class, getStatusCodesController().getStatusCodes().getCode()));
        } finally {
            em.close();
        }
        return "task_create";
    }

    public String createFromStatusCodes() {
        create();
        getStatusCodesController().setStatusCodes(task.getStatus());
        return "statusCodes_detail";
    }

    public String destroyFromProject() {
        Project param = getProjectController().getProject();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getProjectController().setProject(em.find(Project.class, param.getId()));
        } finally {
            em.close();
        }
        return "project_detail";
    }

    private ProjectController getProjectController() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (ProjectController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "project");
    }

    public String createFromProjectSetup() {
        this.task = new reno.Task();
        EntityManager em = getEntityManager();
        try {
            task.setProject(em.find(Project.class, getProjectController().getProject().getId()));
        } finally {
            em.close();
        }
        return "task_create";
    }

    public String createFromProject() {
        create();
        getProjectController().setProject(task.getProject());
        return "project_detail";
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
            Query q = em.createQuery("select o from Payment as o where o.task <> :param or o.task IS NULL");
            q.setParameter("param", task);
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
                entity.setTask(task);
                entity = em.merge(entity);
                task.getPaymentCollection().add(entity);
            }
            task = em.merge(task);
            utx.commit();
            setTask(task);
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
        return "task_detail";
    }

    public String removePaymentCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Payment entity = (Payment) getPaymentController().getDetailPayments().getRowData();
            entity.setTask(null);
            entity = em.merge(entity);
            task.getPaymentCollection().remove(entity);
            task = em.merge(task);
            utx.commit();
            setTask(task);
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
        return "task_detail";
    }

    public String createFromPaymentSetup() {
        this.task = new reno.Task();
        EntityManager em = getEntityManager();
        try {
            if (task.getPaymentCollection() == null) {
                task.setPaymentCollection(new ArrayList());
            }
            task.getPaymentCollection().add(em.find(Payment.class, getPaymentController().getPayment().getId()));
        } finally {
            em.close();
        }
        return "task_create";
    }

    public String createFromPayment() {
        create();
        getPaymentController().setPayment(task.getPaymentCollection().iterator().next());
        return "payment_detail";
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
        getPaymentController().setDetailPayments(task.getPaymentCollection());
    }

    public String createSetup() {
        this.task = new reno.Task();
        if (task.getPaymentCollection() == null) {
            task.setPaymentCollection(new ArrayList<Payment>());
        }
        return "task_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(task);
            PriorityTypes priorityTypes = task.getPriority();
            if (priorityTypes != null) {
                priorityTypes = em.merge(priorityTypes);
                priorityTypes.getTaskCollection().add(task);
                priorityTypes = em.merge(priorityTypes);
            }
            PercentageValues percentageValues = task.getPercentageCompleted();
            if (percentageValues != null) {
                percentageValues = em.merge(percentageValues);
                percentageValues.getTaskCollection().add(task);
                percentageValues = em.merge(percentageValues);
            }
            StatusCodes statusCodes = task.getStatus();
            if (statusCodes != null) {
                statusCodes = em.merge(statusCodes);
                statusCodes.getTaskCollection().add(task);
                statusCodes = em.merge(statusCodes);
            }
            Project project = task.getProject();
            if (project != null) {
                project = em.merge(project);
                project.getTaskCollection().add(task);
                project = em.merge(project);
            }
            for (Payment payment : task.getPaymentCollection()) {
                payment = em.merge(payment);
                payment.setTask(task);
                payment = em.merge(payment);
            }
            utx.commit();
            addSuccessMessage("Task was successfully created.");
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
        return "task_list";
    }

    public String detailSetup() {
        setTaskFromRequestParam();
        return "task_detail";
    }

    public String editSetup() {
        setTaskFromRequestParam();
        return "task_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            PriorityTypes priorityOld = em.find(reno.Task.class, task.getId()).getPriority();
            PercentageValues percentageCompletedOld = em.find(reno.Task.class, task.getId()).getPercentageCompleted();
            StatusCodes statusOld = em.find(reno.Task.class, task.getId()).getStatus();
            Project projectOld = em.find(reno.Task.class, task.getId()).getProject();
            Collection<Payment> paymentsOld = em.find(reno.Task.class, task.getId()).getPaymentCollection();
            task = em.merge(task);
            PriorityTypes priorityNew = task.getPriority();
            if (priorityNew != null) {
                priorityNew.getTaskCollection().add(task);
                priorityNew = em.merge(priorityNew);
            }
            if (priorityOld != null) {
                priorityOld.getTaskCollection().remove(task);
                priorityOld = em.merge(priorityOld);
            }
            PercentageValues percentageCompletedNew = task.getPercentageCompleted();
            if (percentageCompletedNew != null) {
                percentageCompletedNew.getTaskCollection().add(task);
                percentageCompletedNew = em.merge(percentageCompletedNew);
            }
            if (percentageCompletedOld != null) {
                percentageCompletedOld.getTaskCollection().remove(task);
                percentageCompletedOld = em.merge(percentageCompletedOld);
            }
            StatusCodes statusNew = task.getStatus();
            if (statusNew != null) {
                statusNew.getTaskCollection().add(task);
                statusNew = em.merge(statusNew);
            }
            if (statusOld != null) {
                statusOld.getTaskCollection().remove(task);
                statusOld = em.merge(statusOld);
            }
            Project projectNew = task.getProject();
            if (projectNew != null) {
                projectNew.getTaskCollection().add(task);
                projectNew = em.merge(projectNew);
            }
            if (projectOld != null) {
                projectOld.getTaskCollection().remove(task);
                projectOld = em.merge(projectOld);
            }
            Collection<Payment> paymentsNew = task.getPaymentCollection();
            for (Payment paymentNew : paymentsNew) {
                paymentNew.setTask(task);
                paymentNew = em.merge(paymentNew);
            }
            for (Payment paymentOld : paymentsOld) {
                paymentOld.setTask(null);
                paymentOld = em.merge(paymentOld);
            }
            utx.commit();
            addSuccessMessage("Task was successfully updated.");
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
        return "task_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            reno.Task task = getTaskFromRequestParam();
            task = em.merge(task);
            PriorityTypes priorityTypes = task.getPriority();
            if (priorityTypes != null) {
                priorityTypes = em.merge(priorityTypes);
                priorityTypes.getTaskCollection().remove(task);
                priorityTypes = em.merge(priorityTypes);
            }
            PercentageValues percentageValues = task.getPercentageCompleted();
            if (percentageValues != null) {
                percentageValues = em.merge(percentageValues);
                percentageValues.getTaskCollection().remove(task);
                percentageValues = em.merge(percentageValues);
            }
            StatusCodes statusCodes = task.getStatus();
            if (statusCodes != null) {
                statusCodes = em.merge(statusCodes);
                statusCodes.getTaskCollection().remove(task);
                statusCodes = em.merge(statusCodes);
            }
            Project project = task.getProject();
            if (project != null) {
                project = em.merge(project);
                project.getTaskCollection().remove(task);
                project = em.merge(project);
            }
            Collection<Payment> payments = task.getPaymentCollection();
            for (Payment payment : payments) {
                payment = em.merge(payment);
                payment.setTask(null);
                payment = em.merge(payment);
            }
            em.remove(task);
            utx.commit();
            addSuccessMessage("Task was successfully deleted.");
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
        return "task_list";
    }

    public Task getTaskFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            reno.Task o = (reno.Task) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setTaskFromRequestParam() {
        reno.Task task = getTaskFromRequestParam();
        setTask(task);
    }

    public DataModel getTasks() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Task as o");
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

    public Task findTask(Integer id) {
        EntityManager em = getEntityManager();
        try {
            reno.Task o = (reno.Task) em.find(reno.Task.class, id);
            return o;
        } finally {
            em.close();
        }
    }

    public SelectItem[] getPrioritys() {
        EntityManager em = getEntityManager();
        try {
            List<PriorityTypes> l = (List<PriorityTypes>) em.createQuery("select o from PriorityTypes as o").getResultList();
            SelectItem[] select = new SelectItem[l.size()];
            int i = 0;
            for (PriorityTypes x : l) {
                select[i++] = new SelectItem(x);
            }
            return select;
        } finally {
            em.close();
        }
    }

    public SelectItem[] getPercentageCompleteds() {
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

    public SelectItem[] getStatuss() {
        EntityManager em = getEntityManager();
        try {
            List<StatusCodes> l = (List<StatusCodes>) em.createQuery("select o from StatusCodes as o").getResultList();
            SelectItem[] select = new SelectItem[l.size()];
            int i = 0;
            for (StatusCodes x : l) {
                select[i++] = new SelectItem(x);
            }
            return select;
        } finally {
            em.close();
        }
    }

    public SelectItem[] getProjects() {
        EntityManager em = getEntityManager();
        try {
            List<Project> l = (List<Project>) em.createQuery("select o from Project as o").getResultList();
            SelectItem[] select = new SelectItem[l.size()];
            int i = 0;
            for (Project x : l) {
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
            int count = ((Long) em.createQuery("select count(o) from Task as o").getSingleResult()).intValue();
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
        return "task_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "task_list";
    }

}
