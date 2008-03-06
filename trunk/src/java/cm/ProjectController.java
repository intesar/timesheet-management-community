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
public class ProjectController {
    private Project project = null;
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

    public DataModel getDetailProjects() {
        return model;
    }

    public void setDetailProjects(Collection<Project> m) {
        model = new ListDataModel(new ArrayList(m));
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
        this.project = new cm.Project();
        EntityManager em = getEntityManager();
        try {
            project.setManagerId(em.find(Users.class, getUsersController().getUsers().getId()));
        } finally {
            em.close();
        }
        return "project_create";
    }

    public String createFromUsers() {
        create();
        getUsersController().setUsers(project.getManagerId());
        return "users_detail";
    }

    public String destroyFromStatusCodes() {
        StatusCodes param = getStatusCodesController().getStatusCodes();
        destroy();
        EntityManager em = getEntityManager();
        try {
            getStatusCodesController().setStatusCodes(em.find(StatusCodes.class, param.getId()));
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
        this.project = new cm.Project();
        EntityManager em = getEntityManager();
        try {
            project.setStatus(em.find(StatusCodes.class, getStatusCodesController().getStatusCodes().getId()));
        } finally {
            em.close();
        }
        return "project_create";
    }

    public String createFromStatusCodes() {
        create();
        getStatusCodesController().setStatusCodes(project.getStatus());
        return "statusCodes_detail";
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
            Query q = em.createQuery("select o from Task as o where o.project <> :param or o.project IS NULL");
            q.setParameter("param", project);
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
                entity.setProject(project);
                entity = em.merge(entity);
                project.getTaskCollection().add(entity);
            }
            project = em.merge(project);
            utx.commit();
            setProject(project);
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
        return "project_detail";
    }

    public String removeTaskCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Task entity = (Task) getTaskController().getDetailTasks().getRowData();
            entity.setProject(null);
            entity = em.merge(entity);
            project.getTaskCollection().remove(entity);
            project = em.merge(project);
            utx.commit();
            setProject(project);
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
        return "project_detail";
    }

    public String createFromTaskSetup() {
        this.project = new cm.Project();
        EntityManager em = getEntityManager();
        try {
            if (project.getTaskCollection() == null) {
                project.setTaskCollection(new ArrayList());
            }
            project.getTaskCollection().add(em.find(Task.class, getTaskController().getTask().getId()));
        } finally {
            em.close();
        }
        return "project_create";
    }

    public String createFromTask() {
        create();
        getTaskController().setTask(project.getTaskCollection().iterator().next());
        return "task_detail";
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
        getTaskController().setDetailTasks(project.getTaskCollection());
    }

    public String createSetup() {
        this.project = new cm.Project();
        if (project.getTaskCollection() == null) {
            project.setTaskCollection(new ArrayList<Task>());
        }
        return "project_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(project);
            Users users = project.getManagerId();
            if (users != null) {
                users = em.merge(users);
                users.getProjectCollection().add(project);
                users = em.merge(users);
            }
            StatusCodes statusCodes = project.getStatus();
            if (statusCodes != null) {
                statusCodes = em.merge(statusCodes);
                statusCodes.getProjectCollection().add(project);
                statusCodes = em.merge(statusCodes);
            }
            for (Task task : project.getTaskCollection()) {
                task = em.merge(task);
                task.setProject(project);
                task = em.merge(task);
            }
            utx.commit();
            addSuccessMessage("Project was successfully created.");
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
        return "project_list";
    }

    public String detailSetup() {
        setProjectFromRequestParam();
        return "project_detail";
    }

    public String editSetup() {
        setProjectFromRequestParam();
        return "project_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Users managerIdOld = em.find(cm.Project.class, project.getId()).getManagerId();
            StatusCodes statusOld = em.find(cm.Project.class, project.getId()).getStatus();
            Collection<Task> tasksOld = em.find(cm.Project.class, project.getId()).getTaskCollection();
            project = em.merge(project);
            Users managerIdNew = project.getManagerId();
            if (managerIdNew != null) {
                managerIdNew.getProjectCollection().add(project);
                managerIdNew = em.merge(managerIdNew);
            }
            if (managerIdOld != null) {
                managerIdOld.getProjectCollection().remove(project);
                managerIdOld = em.merge(managerIdOld);
            }
            StatusCodes statusNew = project.getStatus();
            if (statusNew != null) {
                statusNew.getProjectCollection().add(project);
                statusNew = em.merge(statusNew);
            }
            if (statusOld != null) {
                statusOld.getProjectCollection().remove(project);
                statusOld = em.merge(statusOld);
            }
            Collection<Task> tasksNew = project.getTaskCollection();
            for (Task taskNew : tasksNew) {
                taskNew.setProject(project);
                taskNew = em.merge(taskNew);
            }
            for (Task taskOld : tasksOld) {
                taskOld.setProject(null);
                taskOld = em.merge(taskOld);
            }
            utx.commit();
            addSuccessMessage("Project was successfully updated.");
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
        return "project_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            cm.Project project = getProjectFromRequestParam();
            project = em.merge(project);
            Users users = project.getManagerId();
            if (users != null) {
                users = em.merge(users);
                users.getProjectCollection().remove(project);
                users = em.merge(users);
            }
            StatusCodes statusCodes = project.getStatus();
            if (statusCodes != null) {
                statusCodes = em.merge(statusCodes);
                statusCodes.getProjectCollection().remove(project);
                statusCodes = em.merge(statusCodes);
            }
            Collection<Task> tasks = project.getTaskCollection();
            for (Task task : tasks) {
                task = em.merge(task);
                task.setProject(null);
                task = em.merge(task);
            }
            em.remove(project);
            utx.commit();
            addSuccessMessage("Project was successfully deleted.");
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
        return "project_list";
    }

    public Project getProjectFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            cm.Project o = (cm.Project) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setProjectFromRequestParam() {
        cm.Project project = getProjectFromRequestParam();
        setProject(project);
    }

    public DataModel getProjects() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Project as o");
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

    public Project findProject(Integer id) {
        EntityManager em = getEntityManager();
        try {
            cm.Project o = (cm.Project) em.find(cm.Project.class, id);
            return o;
        } finally {
            em.close();
        }
    }

    public SelectItem[] getManagerIds() {
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

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            int count = ((Long) em.createQuery("select count(o) from Project as o").getSingleResult()).intValue();
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
        return "project_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "project_list";
    }

}
