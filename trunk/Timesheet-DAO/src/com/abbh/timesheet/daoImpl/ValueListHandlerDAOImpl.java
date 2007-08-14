/*
 * ValueListHandlerDAOImpl.java
 * 
 * Created on Aug 13, 2007, 10:21:04 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.daoImpl;

import com.abbhsoft.framework.valueListHandler.ValueListHandlerDAO;
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
 * @author shannan
 */
public class ValueListHandlerDAOImpl extends JpaTemplate  implements ValueListHandlerDAO {

    public ValueListHandlerDAOImpl() {
    }

    public Long getCount(final String ql, final Map<String, Object> params) {
        return (Long) execute(new JpaCallback() {
            public Object doInJpa(EntityManager em) throws PersistenceException {                
                Query query = em.createNamedQuery(ql);     
                Set<String> keys = params.keySet();
                for ( String key : keys ) {
                    query.setParameter(key, params.get(key));
                }                
                Long result = (Long) query.getSingleResult();
                return result;
            }
        });
    }

    
    public List find(final String ql, final Map<String, Object> params, final int min, final int max) {
        return (List) execute(new JpaCallback() {
            public Object doInJpa(EntityManager em) throws PersistenceException {                
                Query query = em.createNamedQuery(ql);     
                Set<String> keys = params.keySet();
                for ( String key : keys ) {
                    query.setParameter(key, params.get(key));
                }         
                query.setFirstResult(min);
                query.setMaxResults(max);
                List result = query.getResultList();
                return result;
            }
        });
    }

}
