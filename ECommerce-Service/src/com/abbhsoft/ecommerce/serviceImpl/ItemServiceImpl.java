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


    public List<Item> getMatchingItems(String key) {
        key = SQLInjectionFilterManager.getInstance().filter(key);
        key = key.toLowerCase();
        key = key.replace("..", " ");
        String[] keys = key.split(" ");
        Double[] _keys = new Double[keys.length];
        try {
            for (int i = 0; i < keys.length; i++) {
                _keys[i] = Double.valueOf(keys[i]);
            }
            return this.itemDAO.findByPrice(_keys);
        } catch (RuntimeException re) {
            return this.itemDAO.findBySearchKeys(keys);
        }
    }




    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    private ItemDAO itemDAO;
}
