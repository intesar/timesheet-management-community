/*
 * ItemDAOImpl.java
 * 
 * Created on Aug 20, 2007, 11:15:30 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.daoImpl;

import com.abbhsoft.ecommerce.dao.ItemDAO;
import com.abbhsoft.ecommerce.model.Item;

/**
 *
 * @author shannan
 */
public class ItemDAOImpl extends GenericAbstractDAO<Item, Long> implements ItemDAO {

    public ItemDAOImpl() {
        super(Item.class);
    }

    

}
