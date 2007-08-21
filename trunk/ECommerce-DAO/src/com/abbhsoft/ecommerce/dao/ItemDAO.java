/*
 * ItemDAO.java
 * 
 * Created on Aug 20, 2007, 11:14:39 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.dao;

import com.abbhsoft.ecommerce.model.Item;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface ItemDAO {    
    
   
    /**
     * 
     * @param catagoryId 
     * @return 
     */
    public abstract List<Item> findCatagoryItems ( Long catagoryId );

}
