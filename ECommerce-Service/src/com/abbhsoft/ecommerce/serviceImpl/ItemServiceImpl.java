/*
 * ItemServiceImpl.java
 *
 * Created on Aug 20, 2007, 11:13:38 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.serviceImpl;

import com.abbhsoft.ecommerce.dao.ItemDAO;
import com.abbhsoft.ecommerce.service.ItemService;
import java.util.List;

/**
 *
 * @author shannan
 */
public class ItemServiceImpl implements ItemService {

    public ItemServiceImpl() {
    }

    public List getCatagories() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List getCatagoryItems(String catagory) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }


    private ItemDAO itemDAO;
}
