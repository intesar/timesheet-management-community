/*
 * CatagoryDAO.java
 *
 * Created on Aug 21, 2007, 7:01:26 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.dao;

import com.abbhsoft.ecommerce.model.Catagory;
import com.abbhsoft.ecommerce.model.Item;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface CatagoryDAO extends GenericDAO<Catagory, Long> {

    public List<Item> findCatagoryItems(Long catagory);
    
}
