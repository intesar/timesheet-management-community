/*
 * CompanyDAO.java
 * 
 * Created on Aug 18, 2007, 9:26:16 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.dao;

import com.abbh.timesheet.model.Company;

/**
 *
 * @author shannan
 */
public interface CompanyDAO extends GenericDAO<Company, Long> {

    public com.abbhsoft.framework.valueListHandler.ValueListHandler search(java.lang.String key);

}
