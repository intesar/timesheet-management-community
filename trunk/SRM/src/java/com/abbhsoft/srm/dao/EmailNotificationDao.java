/*
 * EmailNotification.java
 * 
 * Created on Nov 24, 2007, 1:42:22 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.EmailNotification;
import java.util.List;
/**
 *
 * @author ABDUL RAHMAN
 */
public interface EmailNotificationDao  extends GenericDao<EmailNotification,Long>{
    public List<EmailNotification>findByEmailId(String emailId);
    public List<EmailNotification>findBySentDate(String sentDate);
    public List<EmailNotification>findByTemplate(String template);
      

}
