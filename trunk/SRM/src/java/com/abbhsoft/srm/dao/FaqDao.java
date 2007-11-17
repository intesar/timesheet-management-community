/*
 * FaqDao.java
 * 
 * Created on Nov 17, 2007, 9:44:29 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.Faq;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface FaqDao extends GenericDao<Faq,Long> {
    
    public List<Faq> findByQuestion(String question);
    public List<Faq> findByAnswer(String answer);
    public List<Faq> findByTag(String tag);
   
}
