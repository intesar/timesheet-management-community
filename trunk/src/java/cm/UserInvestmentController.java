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
public class UserInvestmentController {
    private UserInvestment userInvestment = null;
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

    public DataModel getDetailUserInvestments() {
        return model;
    }

    public void setDetailUserInvestments(Collection<UserInvestment> m) {
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
        this.userInvestment = new cm.UserInvestment();
        EntityManager em = getEntityManager();
        try {
            userInvestment.setUserId(em.find(Users.class, getUsersController().getUsers().getId()));
        } finally {
            em.close();
        }
        return "userInvestment_create";
    }

    public String createFromUsers() {
        create();
        getUsersController().setUsers(userInvestment.getUserId());
        return "users_detail";
    }

    public UserInvestment getUserInvestment() {
        return userInvestment;
    }

    public void setUserInvestment(UserInvestment userInvestment) {
        this.userInvestment = userInvestment;
    }

    public String createSetup() {
        this.userInvestment = new cm.UserInvestment();
        return "userInvestment_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(userInvestment);
            Users users = userInvestment.getUserId();
            if (users != null) {
                users = em.merge(users);
                users.getUserInvestmentCollection().add(userInvestment);
                users = em.merge(users);
            }
            utx.commit();
            addSuccessMessage("UserInvestment was successfully created.");
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
        return "userInvestment_list";
    }

    public String detailSetup() {
        setUserInvestmentFromRequestParam();
        return "userInvestment_detail";
    }

    public String editSetup() {
        setUserInvestmentFromRequestParam();
        return "userInvestment_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Users userIdOld = em.find(cm.UserInvestment.class, userInvestment.getId()).getUserId();
            userInvestment = em.merge(userInvestment);
            Users userIdNew = userInvestment.getUserId();
            if (userIdNew != null) {
                userIdNew.getUserInvestmentCollection().add(userInvestment);
                userIdNew = em.merge(userIdNew);
            }
            if (userIdOld != null) {
                userIdOld.getUserInvestmentCollection().remove(userInvestment);
                userIdOld = em.merge(userIdOld);
            }
            utx.commit();
            addSuccessMessage("UserInvestment was successfully updated.");
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
        return "userInvestment_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            cm.UserInvestment userInvestment = getUserInvestmentFromRequestParam();
            userInvestment = em.merge(userInvestment);
            Users users = userInvestment.getUserId();
            if (users != null) {
                users = em.merge(users);
                users.getUserInvestmentCollection().remove(userInvestment);
                users = em.merge(users);
            }
            em.remove(userInvestment);
            utx.commit();
            addSuccessMessage("UserInvestment was successfully deleted.");
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
        return "userInvestment_list";
    }

    public UserInvestment getUserInvestmentFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            cm.UserInvestment o = (cm.UserInvestment) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setUserInvestmentFromRequestParam() {
        cm.UserInvestment userInvestment = getUserInvestmentFromRequestParam();
        setUserInvestment(userInvestment);
    }

    public DataModel getUserInvestments() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from UserInvestment as o");
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

    public UserInvestment findUserInvestment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            cm.UserInvestment o = (cm.UserInvestment) em.find(cm.UserInvestment.class, id);
            return o;
        } finally {
            em.close();
        }
    }

    public SelectItem[] getUserIds() {
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

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            int count = ((Long) em.createQuery("select count(o) from UserInvestment as o").getSingleResult()).intValue();
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
        return "userInvestment_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "userInvestment_list";
    }

}
