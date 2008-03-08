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
public class BusinessCompanyController {
    private BusinessCompany businessCompany = null;
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

    public DataModel getDetailBusinessCompanys() {
        return model;
    }

    public void setDetailBusinessCompanys(Collection<BusinessCompany> m) {
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

    public String createFromProjectSetup() {
        this.businessCompany = new reno.BusinessCompany();
        EntityManager em = getEntityManager();
        try {
            businessCompany.setProject(em.find(Project.class, getProjectController().getProject().getId()));
        } finally {
            em.close();
        }
        return "businessCompany_create";
    }

    public String createFromProject() {
        create();
        getProjectController().setProject(businessCompany.getProject());
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
            Query q = em.createQuery("select o from Payment as o where o.paidToBusiness <> :param or o.paidToBusiness IS NULL");
            q.setParameter("param", businessCompany);
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
                entity.setPaidToBusiness(businessCompany);
                entity = em.merge(entity);
                businessCompany.getPaymentCollection().add(entity);
            }
            businessCompany = em.merge(businessCompany);
            utx.commit();
            setBusinessCompany(businessCompany);
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
        return "businessCompany_detail";
    }

    public String removePaymentCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Payment entity = (Payment) getPaymentController().getDetailPayments().getRowData();
            entity.setPaidToBusiness(null);
            entity = em.merge(entity);
            businessCompany.getPaymentCollection().remove(entity);
            businessCompany = em.merge(businessCompany);
            utx.commit();
            setBusinessCompany(businessCompany);
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
        return "businessCompany_detail";
    }

    public String createFromPaymentSetup() {
        this.businessCompany = new reno.BusinessCompany();
        EntityManager em = getEntityManager();
        try {
            if (businessCompany.getPaymentCollection() == null) {
                businessCompany.setPaymentCollection(new ArrayList());
            }
            businessCompany.getPaymentCollection().add(em.find(Payment.class, getPaymentController().getPayment().getId()));
        } finally {
            em.close();
        }
        return "businessCompany_create";
    }

    public String createFromPayment() {
        create();
        getPaymentController().setPayment(businessCompany.getPaymentCollection().iterator().next());
        return "payment_detail";
    }

    public BusinessCompany getBusinessCompany() {
        return businessCompany;
    }

    public void setBusinessCompany(BusinessCompany businessCompany) {
        this.businessCompany = businessCompany;
        getPaymentController().setDetailPayments(businessCompany.getPaymentCollection());
    }

    public String createSetup() {
        this.businessCompany = new reno.BusinessCompany();
        if (businessCompany.getPaymentCollection() == null) {
            businessCompany.setPaymentCollection(new ArrayList<Payment>());
        }
        return "businessCompany_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(businessCompany);
            Project project = businessCompany.getProject();
            if (project != null) {
                project = em.merge(project);
                project.getBusinessCompanyCollection().add(businessCompany);
                project = em.merge(project);
            }
            for (Payment payment : businessCompany.getPaymentCollection()) {
                payment = em.merge(payment);
                payment.setPaidToBusiness(businessCompany);
                payment = em.merge(payment);
            }
            utx.commit();
            addSuccessMessage("BusinessCompany was successfully created.");
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
        return "businessCompany_list";
    }

    public String detailSetup() {
        setBusinessCompanyFromRequestParam();
        return "businessCompany_detail";
    }

    public String editSetup() {
        setBusinessCompanyFromRequestParam();
        return "businessCompany_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Project projectOld = em.find(reno.BusinessCompany.class, businessCompany.getId()).getProject();
            Collection<Payment> paymentsOld = em.find(reno.BusinessCompany.class, businessCompany.getId()).getPaymentCollection();
            businessCompany = em.merge(businessCompany);
            Project projectNew = businessCompany.getProject();
            if (projectNew != null) {
                projectNew.getBusinessCompanyCollection().add(businessCompany);
                projectNew = em.merge(projectNew);
            }
            if (projectOld != null) {
                projectOld.getBusinessCompanyCollection().remove(businessCompany);
                projectOld = em.merge(projectOld);
            }
            Collection<Payment> paymentsNew = businessCompany.getPaymentCollection();
            for (Payment paymentNew : paymentsNew) {
                paymentNew.setPaidToBusiness(businessCompany);
                paymentNew = em.merge(paymentNew);
            }
            for (Payment paymentOld : paymentsOld) {
                paymentOld.setPaidToBusiness(null);
                paymentOld = em.merge(paymentOld);
            }
            utx.commit();
            addSuccessMessage("BusinessCompany was successfully updated.");
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
        return "businessCompany_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            reno.BusinessCompany businessCompany = getBusinessCompanyFromRequestParam();
            businessCompany = em.merge(businessCompany);
            Project project = businessCompany.getProject();
            if (project != null) {
                project = em.merge(project);
                project.getBusinessCompanyCollection().remove(businessCompany);
                project = em.merge(project);
            }
            Collection<Payment> payments = businessCompany.getPaymentCollection();
            for (Payment payment : payments) {
                payment = em.merge(payment);
                payment.setPaidToBusiness(null);
                payment = em.merge(payment);
            }
            em.remove(businessCompany);
            utx.commit();
            addSuccessMessage("BusinessCompany was successfully deleted.");
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
        return "businessCompany_list";
    }

    public BusinessCompany getBusinessCompanyFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            reno.BusinessCompany o = (reno.BusinessCompany) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setBusinessCompanyFromRequestParam() {
        reno.BusinessCompany businessCompany = getBusinessCompanyFromRequestParam();
        setBusinessCompany(businessCompany);
    }

    public DataModel getBusinessCompanys() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from BusinessCompany as o");
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

    public BusinessCompany findBusinessCompany(Integer id) {
        EntityManager em = getEntityManager();
        try {
            reno.BusinessCompany o = (reno.BusinessCompany) em.find(reno.BusinessCompany.class, id);
            return o;
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
            int count = ((Long) em.createQuery("select count(o) from BusinessCompany as o").getSingleResult()).intValue();
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
        return "businessCompany_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "businessCompany_list";
    }

}
