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
public class StatusCodesController {
    private StatusCodes statusCodes = null;
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

    public DataModel getDetailStatusCodess() {
        return model;
    }

    public void setDetailStatusCodess(Collection<StatusCodes> m) {
        model = new ListDataModel(new ArrayList(m));
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

    public SelectItem[] getProjectCollectionAvailable() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select o from Project as o where o.status <> :param or o.status IS NULL");
            q.setParameter("param", statusCodes);
            List<Project> l = (List<Project>) q.getResultList();
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
    public Project[] projectCollection = null;

    public Project[] getProjectCollectionToAdd() {
        return projectCollection;
    }

    public void setProjectCollectionToAdd(Project[] projectCollection) {
        this.projectCollection = projectCollection;
    }

    public String addProjectCollection() {
        if (projectCollection == null || projectCollection.length == 0) {
            addErrorMessage("You must select one or more projects to add.");
            return null;
        }
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            for (Project entity : projectCollection) {
                entity.setStatus(statusCodes);
                entity = em.merge(entity);
                statusCodes.getProjectCollection().add(entity);
            }
            statusCodes = em.merge(statusCodes);
            utx.commit();
            setStatusCodes(statusCodes);
            addSuccessMessage("Project successfully added.");
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
        return "statusCodes_detail";
    }

    public String removeProjectCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Project entity = (Project) getProjectController().getDetailProjects().getRowData();
            entity.setStatus(null);
            entity = em.merge(entity);
            statusCodes.getProjectCollection().remove(entity);
            statusCodes = em.merge(statusCodes);
            utx.commit();
            setStatusCodes(statusCodes);
            addSuccessMessage("Project successfully removed.");
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
        return "statusCodes_detail";
    }

    public String createFromProjectSetup() {
        this.statusCodes = new reno.StatusCodes();
        EntityManager em = getEntityManager();
        try {
            if (statusCodes.getProjectCollection() == null) {
                statusCodes.setProjectCollection(new ArrayList());
            }
            statusCodes.getProjectCollection().add(em.find(Project.class, getProjectController().getProject().getId()));
        } finally {
            em.close();
        }
        return "statusCodes_create";
    }

    public String createFromProject() {
        create();
        getProjectController().setProject(statusCodes.getProjectCollection().iterator().next());
        return "project_detail";
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
            Query q = em.createQuery("select o from Task as o where o.status <> :param or o.status IS NULL");
            q.setParameter("param", statusCodes);
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
                entity.setStatus(statusCodes);
                entity = em.merge(entity);
                statusCodes.getTaskCollection().add(entity);
            }
            statusCodes = em.merge(statusCodes);
            utx.commit();
            setStatusCodes(statusCodes);
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
        return "statusCodes_detail";
    }

    public String removeTaskCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Task entity = (Task) getTaskController().getDetailTasks().getRowData();
            entity.setStatus(null);
            entity = em.merge(entity);
            statusCodes.getTaskCollection().remove(entity);
            statusCodes = em.merge(statusCodes);
            utx.commit();
            setStatusCodes(statusCodes);
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
        return "statusCodes_detail";
    }

    public String createFromTaskSetup() {
        this.statusCodes = new reno.StatusCodes();
        EntityManager em = getEntityManager();
        try {
            if (statusCodes.getTaskCollection() == null) {
                statusCodes.setTaskCollection(new ArrayList());
            }
            statusCodes.getTaskCollection().add(em.find(Task.class, getTaskController().getTask().getId()));
        } finally {
            em.close();
        }
        return "statusCodes_create";
    }

    public String createFromTask() {
        create();
        getTaskController().setTask(statusCodes.getTaskCollection().iterator().next());
        return "task_detail";
    }

    public StatusCodes getStatusCodes() {
        return statusCodes;
    }

    public void setStatusCodes(StatusCodes statusCodes) {
        this.statusCodes = statusCodes;
        getProjectController().setDetailProjects(statusCodes.getProjectCollection());
        getTaskController().setDetailTasks(statusCodes.getTaskCollection());
    }

    public String createSetup() {
        this.statusCodes = new reno.StatusCodes();
        if (statusCodes.getProjectCollection() == null) {
            statusCodes.setProjectCollection(new ArrayList<Project>());
        }
        if (statusCodes.getTaskCollection() == null) {
            statusCodes.setTaskCollection(new ArrayList<Task>());
        }
        return "statusCodes_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(statusCodes);
            for (Project project : statusCodes.getProjectCollection()) {
                project = em.merge(project);
                project.setStatus(statusCodes);
                project = em.merge(project);
            }
            for (Task task : statusCodes.getTaskCollection()) {
                task = em.merge(task);
                task.setStatus(statusCodes);
                task = em.merge(task);
            }
            utx.commit();
            addSuccessMessage("StatusCodes was successfully created.");
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
        return "statusCodes_list";
    }

    public String detailSetup() {
        setStatusCodesFromRequestParam();
        return "statusCodes_detail";
    }

    public String editSetup() {
        setStatusCodesFromRequestParam();
        return "statusCodes_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Collection<Project> projectsOld = em.find(reno.StatusCodes.class, statusCodes.getCode()).getProjectCollection();
            Collection<Task> tasksOld = em.find(reno.StatusCodes.class, statusCodes.getCode()).getTaskCollection();
            statusCodes = em.merge(statusCodes);
            Collection<Project> projectsNew = statusCodes.getProjectCollection();
            for (Project projectNew : projectsNew) {
                projectNew.setStatus(statusCodes);
                projectNew = em.merge(projectNew);
            }
            for (Project projectOld : projectsOld) {
                projectOld.setStatus(null);
                projectOld = em.merge(projectOld);
            }
            Collection<Task> tasksNew = statusCodes.getTaskCollection();
            for (Task taskNew : tasksNew) {
                taskNew.setStatus(statusCodes);
                taskNew = em.merge(taskNew);
            }
            for (Task taskOld : tasksOld) {
                taskOld.setStatus(null);
                taskOld = em.merge(taskOld);
            }
            utx.commit();
            addSuccessMessage("StatusCodes was successfully updated.");
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
        return "statusCodes_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            reno.StatusCodes statusCodes = getStatusCodesFromRequestParam();
            statusCodes = em.merge(statusCodes);
            Collection<Project> projects = statusCodes.getProjectCollection();
            for (Project project : projects) {
                project = em.merge(project);
                project.setStatus(null);
                project = em.merge(project);
            }
            Collection<Task> tasks = statusCodes.getTaskCollection();
            for (Task task : tasks) {
                task = em.merge(task);
                task.setStatus(null);
                task = em.merge(task);
            }
            em.remove(statusCodes);
            utx.commit();
            addSuccessMessage("StatusCodes was successfully deleted.");
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
        return "statusCodes_list";
    }

    public StatusCodes getStatusCodesFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            reno.StatusCodes o = (reno.StatusCodes) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setStatusCodesFromRequestParam() {
        reno.StatusCodes statusCodes = getStatusCodesFromRequestParam();
        setStatusCodes(statusCodes);
    }

    public DataModel getStatusCodess() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from StatusCodes as o");
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

    public StatusCodes findStatusCodes(String id) {
        EntityManager em = getEntityManager();
        try {
            reno.StatusCodes o = (reno.StatusCodes) em.find(reno.StatusCodes.class, id);
            return o;
        } finally {
            em.close();
        }
    }

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            int count = ((Long) em.createQuery("select count(o) from StatusCodes as o").getSingleResult()).intValue();
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
        return "statusCodes_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "statusCodes_list";
    }

}
