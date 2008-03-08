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
public class UsersController {
    private Users users = null;
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

    public DataModel getDetailUserss() {
        return model;
    }

    public void setDetailUserss(Collection<Users> m) {
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
            Query q = em.createQuery("select o from Project as o where o.managerId <> :param or o.managerId IS NULL");
            q.setParameter("param", users);
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
                entity.setManagerId(users);
                entity = em.merge(entity);
                users.getProjectCollection().add(entity);
            }
            users = em.merge(users);
            utx.commit();
            setUsers(users);
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
        return "users_detail";
    }

    public String removeProjectCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Project entity = (Project) getProjectController().getDetailProjects().getRowData();
            entity.setManagerId(null);
            entity = em.merge(entity);
            users.getProjectCollection().remove(entity);
            users = em.merge(users);
            utx.commit();
            setUsers(users);
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
        return "users_detail";
    }

    public String createFromProjectSetup() {
        this.users = new reno.Users();
        EntityManager em = getEntityManager();
        try {
            if (users.getProjectCollection() == null) {
                users.setProjectCollection(new ArrayList());
            }
            users.getProjectCollection().add(em.find(Project.class, getProjectController().getProject().getId()));
        } finally {
            em.close();
        }
        return "users_create";
    }

    public String createFromProject() {
        create();
        getProjectController().setProject(users.getProjectCollection().iterator().next());
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
            Query q = em.createQuery("select o from Payment as o where o.paidToUser <> :param or o.paidToUser IS NULL");
            q.setParameter("param", users);
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
                entity.setPaidToUser(users);
                entity = em.merge(entity);
                users.getPaymentCollection().add(entity);
            }
            users = em.merge(users);
            utx.commit();
            setUsers(users);
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
        return "users_detail";
    }

    public String removePaymentCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Payment entity = (Payment) getPaymentController().getDetailPayments().getRowData();
            entity.setPaidToUser(null);
            entity = em.merge(entity);
            users.getPaymentCollection().remove(entity);
            users = em.merge(users);
            utx.commit();
            setUsers(users);
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
        return "users_detail";
    }

    public String createFromPaymentSetup() {
        this.users = new reno.Users();
        EntityManager em = getEntityManager();
        try {
            if (users.getPaymentCollection() == null) {
                users.setPaymentCollection(new ArrayList());
            }
            users.getPaymentCollection().add(em.find(Payment.class, getPaymentController().getPayment().getId()));
        } finally {
            em.close();
        }
        return "users_create";
    }

    public String createFromPayment() {
        create();
        getPaymentController().setPayment(users.getPaymentCollection().iterator().next());
        return "payment_detail";
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
        getProjectController().setDetailProjects(users.getProjectCollection());
        getPaymentController().setDetailPayments(users.getPaymentCollection());
    }

    public String createSetup() {
        this.users = new reno.Users();
        if (users.getProjectCollection() == null) {
            users.setProjectCollection(new ArrayList<Project>());
        }
        if (users.getPaymentCollection() == null) {
            users.setPaymentCollection(new ArrayList<Payment>());
        }
        return "users_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(users);
            for (Project project : users.getProjectCollection()) {
                project = em.merge(project);
                project.setManagerId(users);
                project = em.merge(project);
            }
            for (Payment payment : users.getPaymentCollection()) {
                payment = em.merge(payment);
                payment.setPaidToUser(users);
                payment = em.merge(payment);
            }
            utx.commit();
            addSuccessMessage("Users was successfully created.");
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
        return "users_list";
    }

    public String detailSetup() {
        setUsersFromRequestParam();
        return "users_detail";
    }

    public String editSetup() {
        setUsersFromRequestParam();
        return "users_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Collection<Project> projectsOld = em.find(reno.Users.class, users.getId()).getProjectCollection();
            Collection<Payment> paymentsOld = em.find(reno.Users.class, users.getId()).getPaymentCollection();
            users = em.merge(users);
            Collection<Project> projectsNew = users.getProjectCollection();
            for (Project projectNew : projectsNew) {
                projectNew.setManagerId(users);
                projectNew = em.merge(projectNew);
            }
            for (Project projectOld : projectsOld) {
                projectOld.setManagerId(null);
                projectOld = em.merge(projectOld);
            }
            Collection<Payment> paymentsNew = users.getPaymentCollection();
            for (Payment paymentNew : paymentsNew) {
                paymentNew.setPaidToUser(users);
                paymentNew = em.merge(paymentNew);
            }
            for (Payment paymentOld : paymentsOld) {
                paymentOld.setPaidToUser(null);
                paymentOld = em.merge(paymentOld);
            }
            utx.commit();
            addSuccessMessage("Users was successfully updated.");
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
        return "users_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            reno.Users users = getUsersFromRequestParam();
            users = em.merge(users);
            Collection<Project> projects = users.getProjectCollection();
            for (Project project : projects) {
                project = em.merge(project);
                project.setManagerId(null);
                project = em.merge(project);
            }
            Collection<Payment> payments = users.getPaymentCollection();
            for (Payment payment : payments) {
                payment = em.merge(payment);
                payment.setPaidToUser(null);
                payment = em.merge(payment);
            }
            em.remove(users);
            utx.commit();
            addSuccessMessage("Users was successfully deleted.");
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
        return "users_list";
    }

    public Users getUsersFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            reno.Users o = (reno.Users) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setUsersFromRequestParam() {
        reno.Users users = getUsersFromRequestParam();
        setUsers(users);
    }

    public DataModel getUserss() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Users as o");
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

    public Users findUsers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            reno.Users o = (reno.Users) em.find(reno.Users.class, id);
            return o;
        } finally {
            em.close();
        }
    }

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            int count = ((Long) em.createQuery("select count(o) from Users as o").getSingleResult()).intValue();
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
        return "users_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "users_list";
    }

}
