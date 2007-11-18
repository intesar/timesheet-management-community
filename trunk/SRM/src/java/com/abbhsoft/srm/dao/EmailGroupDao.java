/*
 * EmailGroupDao.java
 * 
 * Created on Nov 17, 2007, 9:44:06 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.EmailGroup;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface EmailGroupDao extends GenericDao<EmailGroup, Long> {

    public List<EmailGroup> findByOwner(String owner);

    public List<EmailGroup> findBySubscribeEmail(String subscribeEmail);

    public List<EmailGroup> findByGroupEmail(String groupEmail);

    public List<EmailGroup> findByUnsubscribeEmail(String unSubscribeEmail);
    
    // 4 params all same looks for matching emails

    public List<EmailGroup> findByEmails(String args0, String args1,String args2,String args3);
}
