/*
 * GenericDAO.java
 * 
 * Created on Aug 12, 2007, 4:03:00 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.dao;

import java.util.Collection;

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
    void save ( T newInstance);
    
    /**
     * 
     * @param property 
     * @param value 
     * @return 
     */
    Collection<T> findByProperty(final String property, final Object value);
    
}
