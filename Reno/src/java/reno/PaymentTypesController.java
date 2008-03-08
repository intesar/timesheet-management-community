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
public class PaymentTypesController {
    private PaymentTypes paymentTypes = null;
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

    public DataModel getDetailPaymentTypess() {
        return model;
    }

    public void setDetailPaymentTypess(Collection<PaymentTypes> m) {
        model = new ListDataModel(new ArrayList(m));
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
            Query q = em.createQuery("select o from Payment as o where o.paymentType <> :param or o.paymentType IS NULL");
            q.setParameter("param", paymentTypes);
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
                entity.setPaymentType(paymentTypes);
                entity = em.merge(entity);
                paymentTypes.getPaymentCollection().add(entity);
            }
            paymentTypes = em.merge(paymentTypes);
            utx.commit();
            setPaymentTypes(paymentTypes);
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
        return "paymentTypes_detail";
    }

    public String removePaymentCollection() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Payment entity = (Payment) getPaymentController().getDetailPayments().getRowData();
            entity.setPaymentType(null);
            entity = em.merge(entity);
            paymentTypes.getPaymentCollection().remove(entity);
            paymentTypes = em.merge(paymentTypes);
            utx.commit();
            setPaymentTypes(paymentTypes);
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
        return "paymentTypes_detail";
    }

    public String createFromPaymentSetup() {
        this.paymentTypes = new reno.PaymentTypes();
        EntityManager em = getEntityManager();
        try {
            if (paymentTypes.getPaymentCollection() == null) {
                paymentTypes.setPaymentCollection(new ArrayList());
            }
            paymentTypes.getPaymentCollection().add(em.find(Payment.class, getPaymentController().getPayment().getId()));
        } finally {
            em.close();
        }
        return "paymentTypes_create";
    }

    public String createFromPayment() {
        create();
        getPaymentController().setPayment(paymentTypes.getPaymentCollection().iterator().next());
        return "payment_detail";
    }

    public PaymentTypes getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(PaymentTypes paymentTypes) {
        this.paymentTypes = paymentTypes;
        getPaymentController().setDetailPayments(paymentTypes.getPaymentCollection());
    }

    public String createSetup() {
        this.paymentTypes = new reno.PaymentTypes();
        if (paymentTypes.getPaymentCollection() == null) {
            paymentTypes.setPaymentCollection(new ArrayList<Payment>());
        }
        return "paymentTypes_create";
    }

    public String create() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            em.persist(paymentTypes);
            for (Payment payment : paymentTypes.getPaymentCollection()) {
                payment = em.merge(payment);
                payment.setPaymentType(paymentTypes);
                payment = em.merge(payment);
            }
            utx.commit();
            addSuccessMessage("PaymentTypes was successfully created.");
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
        return "paymentTypes_list";
    }

    public String detailSetup() {
        setPaymentTypesFromRequestParam();
        return "paymentTypes_detail";
    }

    public String editSetup() {
        setPaymentTypesFromRequestParam();
        return "paymentTypes_edit";
    }

    public String edit() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            Collection<Payment> paymentsOld = em.find(reno.PaymentTypes.class, paymentTypes.getCode()).getPaymentCollection();
            paymentTypes = em.merge(paymentTypes);
            Collection<Payment> paymentsNew = paymentTypes.getPaymentCollection();
            for (Payment paymentNew : paymentsNew) {
                paymentNew.setPaymentType(paymentTypes);
                paymentNew = em.merge(paymentNew);
            }
            for (Payment paymentOld : paymentsOld) {
                paymentOld.setPaymentType(null);
                paymentOld = em.merge(paymentOld);
            }
            utx.commit();
            addSuccessMessage("PaymentTypes was successfully updated.");
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
        return "paymentTypes_list";
    }

    public String destroy() {
        EntityManager em = getEntityManager();
        try {
            utx.begin();
            reno.PaymentTypes paymentTypes = getPaymentTypesFromRequestParam();
            paymentTypes = em.merge(paymentTypes);
            Collection<Payment> payments = paymentTypes.getPaymentCollection();
            for (Payment payment : payments) {
                payment = em.merge(payment);
                payment.setPaymentType(null);
                payment = em.merge(payment);
            }
            em.remove(paymentTypes);
            utx.commit();
            addSuccessMessage("PaymentTypes was successfully deleted.");
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
        return "paymentTypes_list";
    }

    public PaymentTypes getPaymentTypesFromRequestParam() {
        EntityManager em = getEntityManager();
        try {
            reno.PaymentTypes o = (reno.PaymentTypes) model.getRowData();
            o = em.merge(o);
            return o;
        } finally {
            em.close();
        }
    }

    public void setPaymentTypesFromRequestParam() {
        reno.PaymentTypes paymentTypes = getPaymentTypesFromRequestParam();
        setPaymentTypes(paymentTypes);
    }

    public DataModel getPaymentTypess() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from PaymentTypes as o");
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

    public PaymentTypes findPaymentTypes(String id) {
        EntityManager em = getEntityManager();
        try {
            reno.PaymentTypes o = (reno.PaymentTypes) em.find(reno.PaymentTypes.class, id);
            return o;
        } finally {
            em.close();
        }
    }

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            int count = ((Long) em.createQuery("select count(o) from PaymentTypes as o").getSingleResult()).intValue();
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
        return "paymentTypes_list";
    }

    public String prev() {
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
        return "paymentTypes_list";
    }

}
