/*
 * Group1Dao.java
 * 
 * Created on Nov 17, 2007, 9:44:06 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.Group1;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface Group1Dao extends GenericDao < Group1,Long> {
    
    public List<Group1>findByOwner(String owner);
     public List<Group1>findBySubscribeEmail(String subscribeEmail);
      public List<Group1>findByGroupEmail(String groupEmail);
       public List<Group1>findByUnsubscribeEmail(String unSubscribeEmail);
       

}
