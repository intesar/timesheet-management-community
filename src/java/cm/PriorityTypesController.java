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
public class PriorityTypesController {
    private PriorityTypes priorityTypes = null;
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

    public DataModel getDetailPriorityTypess() {
        return model;
    }

    public void setDetailPriorityTypess(Collection<PriorityTypes> m) {
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
        this.priorityTypes = new cm.PriorityTypes();
        EntityManager em = getEntityManager();
        try {
            priorityTypes.setTask(em.find(Task.class, getTaskController().getTask().getId()));
        } finally {
            em.close();
        }
        return "priorityTypes_create";
    }

    public String createFromTask() {
        create();
        getTaskController().setTask(priorityTypes.getTask());
        return "task_detail";
    }

    public PriorityTypes getPriorityTypes() {
        return priorityTypes;
    }

    public void setPriorityTypes(PriorityTypes priorityTypes) {
        this.priorityTypes = priorityTypes;
    }

    public String createSetup() {
        this.priorityTypes = new cm.PriorityTypes();
        return "priorityTypes_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(priorityTypes);
            Task task = priorityTypes.getTask();
            if (task != null) {
                task = em.merge(task);
                task.setPriorityTypes(priorityTypes);
                task = em.merge(task);
            }
            utx.commit();
            addSuccessMessage("PriorityTypes was successfully created.");
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
        return "priorityTypes_list";
    }

    public String detailSetup() {
        setPriorityTypesFromRequestParam();
        return "priorityTypes_detail";
    }

    public String editSetup() {
        setPriorityTypesFromRequestParam();
        return "priorityTypes_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Task taskOld = em.find(cm.PriorityTypes.class, priorityTypes.getId()).getTask();
            priorityTypes = em.merge(priorityTypes);
            Task taskNew = priorityTypes.getTask();
            if (taskNew != null) {
                taskNew.setPriorityTypes(priorityTypes);
                taskNew = em.merge(taskNew);
            }
            if (taskOld != null) {
                taskOld.setPriorityTypes(null);
                taskOld = em.merge(taskOld);
            }
            utx.commit();
            addSuccessMessage("PriorityTypes was successfully updated.");
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
        return "priorityTypes_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            cm.PriorityTypes priorityTypes = getPriorityTypesFromRequestParam();
            priorityTypes = em.merge(priorityTypes);
            Task task = priorityTypes.getTask();
            if (task != null) {
                task = em.merge(task);
                task.setPriorityTypes(null);
                task = em.merge(task);
            }
            em.remove(priorityTypes);
            utx.commit();
            addSuccessMessage("PriorityTypes was successfully deleted.");
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
        return "priorityTypes_list";
    }

    public PriorityTypes getPriorityTypesFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            cm.PriorityTypes o = (cm.PriorityTypes) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setPriorityTypesFromRequestParam() {
        cm.PriorityTypes priorityTypes = getPriorityTypesFromRequestParam();
        setPriorityTypes(priorityTypes);
    }

    public DataModel getPriorityTypess() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from PriorityTypes as o");
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

    public PriorityTypes findPriorityTypes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            cm.PriorityTypes o = (cm.PriorityTypes) em.find(cm.PriorityTypes.class, id);
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

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            int count = ((Long) em.createQuery("select count(o) from PriorityTypes as o").getSingleResult()).intValue();
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
        return "priorityTypes_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "priorityTypes_list";
    }

}
