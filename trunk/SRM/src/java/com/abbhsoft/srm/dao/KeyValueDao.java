/*
 * KeyValueDao.java
 * 
 * Created on Nov 17, 2007, 9:43:33 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.KeyValue;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface KeyValueDao extends GenericDao < KeyValue, Long> {
    
     public List<KeyValue> findByKey (String key );
     public List<KeyValue> findByValue (String value );
     public List<KeyValue> findByDescriptIon(String description );
    
}
