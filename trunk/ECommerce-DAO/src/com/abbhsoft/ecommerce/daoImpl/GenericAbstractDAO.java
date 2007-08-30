/*
 * GenericAbstractDAO.java
 *
 * Created on Aug 12, 2007, 4:06:13 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.daoImpl;

import com.abbhsoft.ecommerce.dao.GenericDAO;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;

/**
 *
 * @param T
 * @param Pk
 * @author shannan
 */
public abstract class GenericAbstractDAO<T, Pk extends Serializable> extends JpaTemplate implements GenericDAO<T, Pk> {

    private final Class clazz;

    public GenericAbstractDAO(Class clazz) {
        this.clazz = clazz;
    }

    public void save(final T instance) {
        this.persist(instance);
    }

    @SuppressWarnings(value = "unchecked")
    public T findById(Pk pk) {
        return (T) this.find(clazz, pk);
    }

    private String getClassName() {
        return clazz.getName().replace("com.abbhsoft.ecommerce.model.", "");
    }

    @SuppressWarnings(value = "unchecked")
    public Collection<T> findAll() {

        final String ql = " select o from " + this.getClassName() + " as o where o.isEnabled = true ";
        return (Collection<T>) execute(new JpaCallback() {
            public Object doInJpa(EntityManager em) throws PersistenceException {                
                Query query = em.createQuery(ql);                
                List result = query.getResultList();
                return result;
            }
        });
    }

    @SuppressWarnings(value = "unchecked")
    public Collection<T> findByProperty(final String property, final Object value) {
        return (Collection<T>) execute(new JpaCallback() {
            public Object doInJpa(EntityManager em) throws PersistenceException {
                String ql = "select e from Address as e where e." + property + " = :" + property;
                Query query = em.createQuery(ql);
                query.setParameter(property, value);
                List result = query.getResultList();
                return result;
            }
        });
    }

    @SuppressWarnings(value = "unchecked")
    public Collection<T> findBySQL(final String sql, final Map<String, Object> params) {
        return (Collection<T>) execute(new JpaCallback() {
            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createNativeQuery(sql);
                Set<String> keys = params.keySet();
                for ( String key : keys ) {
                query.setParameter(key, params.get(key));
                }
                List result = query.getResultList();
                return result;
            }
        });
    }

    @SuppressWarnings(value = "unchecked")
    public Collection<T> findByJPAQL(final String sql, final Map<String, Object> params) {
        return (Collection<T>) execute(new JpaCallback() {
            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery(sql);
                Set<String> keys = params.keySet();
                for ( String key : keys ) {
                query.setParameter(key, params.get(key));
                }
                List result = query.getResultList();
                return result;
            }
        });
    }
}
