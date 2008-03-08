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
public class PriorityTypesController {
    private PriorityTypes priorityTypes = null;
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

    public SelectItem[] getTaskCollectionAvailable() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select o from Task as o where o.priority <> :param or o.priority IS NULL");
            q.setParameter("param", priorityTypes);
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
                entity.setPriority(priorityTypes);
                entity = em.merge(entity);
                priorityTypes.getTaskCollection().add(entity);
            }
            priorityTypes = em.merge(priorityTypes);
            utx.commit();
            setPriorityTypes(priorityTypes);
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
        return "priorityTypes_detail";
    }

    public String removeTaskCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Task entity = (Task) getTaskController().getDetailTasks().getRowData();
            entity.setPriority(null);
            entity = em.merge(entity);
            priorityTypes.getTaskCollection().remove(entity);
            priorityTypes = em.merge(priorityTypes);
            utx.commit();
            setPriorityTypes(priorityTypes);
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
        return "priorityTypes_detail";
    }

    public String createFromTaskSetup() {
        this.priorityTypes = new reno.PriorityTypes();
        EntityManager em = getEntityManager();
        try {
            if (priorityTypes.getTaskCollection() == null) {
                priorityTypes.setTaskCollection(new ArrayList());
            }
            priorityTypes.getTaskCollection().add(em.find(Task.class, getTaskController().getTask().getId()));
        } finally {
            em.close();
        }
        return "priorityTypes_create";
    }

    public String createFromTask() {
        create();
        getTaskController().setTask(priorityTypes.getTaskCollection().iterator().next());
        return "task_detail";
    }

    public PriorityTypes getPriorityTypes() {
        return priorityTypes;
    }

    public void setPriorityTypes(PriorityTypes priorityTypes) {
        this.priorityTypes = priorityTypes;
        getTaskController().setDetailTasks(priorityTypes.getTaskCollection());
    }

    public String createSetup() {
        this.priorityTypes = new reno.PriorityTypes();
        if (priorityTypes.getTaskCollection() == null) {
            priorityTypes.setTaskCollection(new ArrayList<Task>());
        }
        return "priorityTypes_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(priorityTypes);
            for (Task task : priorityTypes.getTaskCollection()) {
                task = em.merge(task);
                task.setPriority(priorityTypes);
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
            Collection<Task> tasksOld = em.find(reno.PriorityTypes.class, priorityTypes.getPriorityCode()).getTaskCollection();
            priorityTypes = em.merge(priorityTypes);
            Collection<Task> tasksNew = priorityTypes.getTaskCollection();
            for (Task taskNew : tasksNew) {
                taskNew.setPriority(priorityTypes);
                taskNew = em.merge(taskNew);
            }
            for (Task taskOld : tasksOld) {
                taskOld.setPriority(null);
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
            reno.PriorityTypes priorityTypes = getPriorityTypesFromRequestParam();
            priorityTypes = em.merge(priorityTypes);
            Collection<Task> tasks = priorityTypes.getTaskCollection();
            for (Task task : tasks) {
                task = em.merge(task);
                task.setPriority(null);
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
            reno.PriorityTypes o = (reno.PriorityTypes) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setPriorityTypesFromRequestParam() {
        reno.PriorityTypes priorityTypes = getPriorityTypesFromRequestParam();
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

    public PriorityTypes findPriorityTypes(String id) {
        EntityManager em = getEntityManager();
        try {
            reno.PriorityTypes o = (reno.PriorityTypes) em.find(reno.PriorityTypes.class, id);
            return o;
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
