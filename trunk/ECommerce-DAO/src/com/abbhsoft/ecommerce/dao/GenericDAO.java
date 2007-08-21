/*
 * GenericDAO.java
 * 
 * Created on Aug 12, 2007, 4:03:00 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.dao;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @param T 
 * @param Pk 
 * @author shannan
 */
public interface GenericDAO<T, Pk> {

    /**
     * 
     * @param newInstance 
     */
    public abstract void save ( T newInstance);
    
    /**
     * 
     * @param pk 
     * @return 
     */
    public abstract T findById ( Pk pk );
    /**
     * 
     * @return 
     */
    public abstract Collection<T> findAll();
    
    /**
     * 
     * @param property 
     * @param value 
     * @return 
     */
    public abstract Collection<T> findByProperty(final String property, final Object value);
    
    /**
     * 
     * @param sql 
     * @param params 
     * @return 
     */
    public Collection<T> findBySQL(final String sql, final Map<String, Object> params);
    
}
