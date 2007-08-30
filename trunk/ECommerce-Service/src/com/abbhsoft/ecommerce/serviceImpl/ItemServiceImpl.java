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
import com.abbhsoft.sqlInjectionFilter.SQLInjectionFilterManager;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author Mohammed Hamed
 */
public class ItemServiceImpl implements ItemService {

    public ItemServiceImpl() {
    }

    public Collection<Item> getAllItems() {
        return itemDAO.findAll();
    }

    public List<Item> getSearchedItems(String key) {
        // make sure the string is not empty else return empty List but not Null
        // apply SQLInjectionFilter by calling 
        // u can find this jar inside dao/lib
        key = SQLInjectionFilterManager.getInstance().filter(key);
        // use String[] keys = key.split(" ");
        // call dao
        // return the result
        return null;
    }
    
    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    
    private ItemDAO itemDAO;
}
