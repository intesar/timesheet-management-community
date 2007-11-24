/*
 * EmailTemplateDao.java
 * 
 * Created on Nov 24, 2007, 1:33:27 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.EmailTemplate;
import java.util.List;
/**
 *
 * @author ABDUL RAHMAN
 */
public interface EmailTemplateDao extends GenericDao<EmailTemplate,Long> {
    
    public List<EmailTemplate>findByName(String type);
    public List<EmailTemplate>findByTemplate(String street);
   
}
