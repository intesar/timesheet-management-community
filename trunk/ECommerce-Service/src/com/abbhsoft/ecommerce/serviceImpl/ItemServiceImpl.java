/*
 * ItemImpl.java
 * 
 * Created on Aug 24, 2007, 11:52:09 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.serviceImpl;

import com.abbhsoft.ecommerce.dao.ItemDAO;
import com.abbhsoft.ecommerce.model.Item;
import com.abbhsoft.ecommerce.service.ItemService;
import java.util.Collection;


/**
 *
 * @author Mohammed Hamed
 */
public class ItemServiceImpl implements ItemService{

    public ItemServiceImpl() {
    }

    public Collection<Item> getAllItems() {
          return itemDAO.findAll();
        
    }


private ItemDAO itemDAO;
}
