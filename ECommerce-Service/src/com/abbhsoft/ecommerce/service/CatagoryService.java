/*
 * ItemService.java
 * 
 * Created on Aug 20, 2007, 11:12:29 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.service;

import com.abbhsoft.ecommerce.model.Catagory;
import com.abbhsoft.ecommerce.model.Item;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface CatagoryService {
    
    /**
     * 
     * @return 
     */
    public List<Catagory> getCatagories();

    /**
     * 
     * @param catagory 
     * @return 
     */
    public List<Item> getCatagoryItems(Long catagory);

}
