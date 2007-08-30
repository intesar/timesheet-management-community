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
import java.util.List;

/**
 *
 * @author shannan
 */
public class ItemDAOImpl extends GenericAbstractDAO<Item, Long> implements ItemDAO {

    public ItemDAOImpl() {
        super(Item.class);
    }

    public List<Item> findBySearchKeys(String... keys) {
        // construct a query
        // use preparedstatement like params
        // construct a map of params [name, value]
        // call this.findByJPAQL(sql, params) and return the List
        return null;
    }

    

}
