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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shannan
 */
public class ItemDAOImpl extends GenericAbstractDAO<Item, Long> implements ItemDAO {

    public ItemDAOImpl() {
        super(Item.class);
    }

    public List<Item> findBySearchKeys(String... keys) {
        String ql = " select i from Item i where ";
        String nameString = "";
        String descriptionString = "";
        Map<String, Object> params = new HashMap<String, Object>();
        boolean flag = false;
        for (int i = 0; i < keys.length; i++) {
            if (flag) {
                nameString += " and ";
                descriptionString += " and ";
            }
            nameString += " i.name like :key" + i;
            descriptionString += " i.description like :key" + i;
            flag = true;
            // params
            params.put("key" + i, "%" + keys[i] + "%");
        }

        ql += " ( " + nameString + " ) or  ( " + descriptionString + " ) ";

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
        System.out.println ( ql + params);
        return (List<Item>) this.findByJPAQL(ql, params);
    }

    public List<Item> findByPrice(Double... prices) {
        Double startPrice = 0.0;
        Double endPrice = 5.99;
        if (prices.length > 0) {
            if (prices.length > 1) {
                startPrice = prices[0];
                endPrice = prices[1];
            } else {
                endPrice = prices[0];
            }
        }
        String ql = " select i from Item i where i.price between :startPrice and :endPrice ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("startPrice", startPrice);
        params.put("endPrice", endPrice);
        return (List<Item>) this.findByJPAQL (ql, params);
    }
}
