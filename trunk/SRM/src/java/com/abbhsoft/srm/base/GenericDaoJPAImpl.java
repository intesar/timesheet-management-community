package com.abbhsoft.srm.base;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;


/**
 * Hibernate implementation of GenericDao. A typesafe implementation of CRUD and finder methods
 * based on Hibernate and Spring AOP. The finders are implemented through the executeFinder method.
 * Normally called by the FinderIntroductionInterceptor.
 *
 * @author pmellqvist
 * @see http://www-128.ibm.com/developerworks/java/library/j-genericdao.html
 */
public class GenericDaoJPAImpl<T, PK extends Serializable> extends JpaTemplate implements GenericDao<T, PK>, FinderExecutor {

    static final Log logger = LogFactory.getLog(GenericDaoJPAImpl.class);
    // default FinderNamingStrategy can be overriden in Spring config

    private FinderNamingStrategy namingStrategy = new SimpleFinderNamingStrategy();
    private Class<T> type;
    // ****************************** ctors ******************************

    public GenericDaoJPAImpl(Class<T> type) {
        this.type = type;
    }
    // ****************************** methods ******************************

    @SuppressWarnings(value = "unchecked")
    public PK create(T o) {
        this.persist(o);
        return null;
    }

    @SuppressWarnings(value = "unchecked")
    public T read(PK id) {
        System.out.println(type);
        return this.find(type, id);
    }

    public void update(T o) {
        System.out.println(" Inside update ");
        this.merge(o);
    }

    public void delete(T o) {
        System.out.println(" Inside Delete ");
        this.remove(o);

    }

    public List<T> findByCreateUser(Long userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> findByCreateDate(Date createDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> findByLastModiiedUser(Long userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> findByLastModifiedDate(Date lastModifiedDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    public List<T> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
//        final String ql = " select o from Catagory o where o.isEnabled = 1 ";
//        return (List<T>) execute(new JpaCallback() {
//
//                    public Object doInJpa(EntityManager em) throws PersistenceException {
//                        Query query = em.createQuery(ql);
//                        List result = query.getResultList();
//                        return result;
//                    }
//                });
    }

    @SuppressWarnings(value = "unchecked")
    public List<T> executeFinder(Method method, final Object[] queryArgs) {
        return prepareQuery(method, queryArgs);

    }

    

    @SuppressWarnings(value = "unchecked")
    public Iterator<T> iterateFinder(Method method, final Object[] queryArgs) {
        return null;
    }

    private List prepareQuery(final Method method, final Object[] queryArgs) {
        final String queryName = getNamingStrategy().queryNameFromMethod(type, method);
        return (List) execute(new JpaCallback() {

                    public Object doInJpa(EntityManager em) throws PersistenceException {
                        Query namedQuery = em.createNamedQuery(queryName);

                        setPositionalParams(queryArgs, namedQuery);
                        return namedQuery.getResultList();
                    }
                });
    }

    private void setPositionalParams(Object[] queryArgs, Query namedQuery) {
        // Set parameter. Use custom Hibernate Type if necessary
        if (queryArgs != null) {
            for (int i = 1; i <= queryArgs.length; i++) {
                Object arg = queryArgs[i - 1];

                namedQuery.setParameter(i, arg);
            }
        }
    }

    //    private void setNamedParams(String[] namedParameters, Object[] queryArgs, Query namedQuery) {
//        // Set parameter. Use custom Hibernate Type if necessary
//        if (queryArgs != null) {
//            for (int i = 0; i < queryArgs.length; i++) {
//                Object arg = queryArgs[i];
//
//                if (arg instanceof Collection) {
//                    namedQuery.setParameterList(namedParameters[i], (Collection) arg);
//                } else {
//                    namedQuery.setParameter(namedParameters[i], arg);
//                }
//            }
//        }
//    }
    // ****************************** getters & setters ******************************

    public FinderNamingStrategy getNamingStrategy() {
        return namingStrategy;
    }

    public void setNamingStrategy(FinderNamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }
}