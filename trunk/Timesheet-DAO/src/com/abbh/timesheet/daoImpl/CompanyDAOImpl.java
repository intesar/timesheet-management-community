/*
 * CompanyDAOImpl.java
 *
 * Created on Aug 18, 2007, 8:59:03 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.daoImpl;

import com.abbh.timesheet.dao.CompanyDAO;
import com.abbh.timesheet.model.Company;
import com.abbhsoft.framework.valueListHandler.ValueListHandlerDAO;
import com.abbhsoft.framework.valueListHandler.ValueListHandlerFactory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author shannan
 */
public class CompanyDAOImpl extends GenericAbstractDAO<Company, Long> implements CompanyDAO {

    public CompanyDAOImpl() {
        super(Company.class);
    }

    public com.abbhsoft.framework.valueListHandler.ValueListHandler search(String key) {
        Map<String, Object> params = new HashMap<String, Object>();
        Long id = null;
        try {
            id = Long.parseLong(key);
        } catch (RuntimeException re) {
            id = new Long(0);
        }
        params.put("id", id);
        params.put("name", "%" + key + "%");
        params.put("type", "%" + key + "%");
        params.put("city", "%" + key + "%");
        return ValueListHandlerFactory.getInstance(valueListHandlerDAO, "Company.findByCountAll", "Company.findByAll", params);
    }

    private ValueListHandlerDAO valueListHandlerDAO;

    public void setValueListHandlerDAO(ValueListHandlerDAO valueListHandlerDAO) {
        this.valueListHandlerDAO = valueListHandlerDAO;
    }
}
