/*
 * CompanyServiceImpl.java
 * 
 * Created on Aug 18, 2007, 10:54:12 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.serviceImpl;

import com.abbh.timesheet.service.CompanyService;
import com.abbh.timesheet.dao.CompanyDAO;
import com.abbhsoft.framework.valueListHandler.ValueListHandler;

/**
 *
 * @author shannan
 */
public class CompanyServiceImpl implements CompanyService {

    public CompanyServiceImpl() {
    }
    
    public ValueListHandler search ( String key ) {
        return companyDAO.search(key);
    }

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
    
    
    private CompanyDAO companyDAO;

}
