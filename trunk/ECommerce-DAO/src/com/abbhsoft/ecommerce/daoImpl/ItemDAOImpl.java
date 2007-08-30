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
//        select * from item
//         where (name like :key1 and name like :key2 and name like 1key3 ) or
//        (description like :key1 and description like :key2 and description like :key3  ) or
//        (ingredients like :key1 and ingredients like :key2 and ingredients like :key3  );
        
//         construct a map of params [name, value]
//         Map<String, Object> map = ..
//         map.put ( "Key1", keys[0]);
//         map.put ( "Key2", keys[1]);
//         map.put ( "Key3", keys[2]);
        // call this.findByJPAQL(sql, map) and return the List
        return null;
    }

    

}
