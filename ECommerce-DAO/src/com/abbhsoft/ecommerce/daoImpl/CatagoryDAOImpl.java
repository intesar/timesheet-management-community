/*
 * CatagoryDAOImpl.java
 * 
 * Created on Aug 21, 2007, 7:03:28 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.daoImpl;

import com.abbhsoft.ecommerce.dao.CatagoryDAO;
import com.abbhsoft.ecommerce.model.Catagory;
import com.abbhsoft.ecommerce.model.Item;
import java.util.List;

/**
 *
 * @author shannan
 */
public class CatagoryDAOImpl extends GenericAbstractDAO<Catagory, Long> implements CatagoryDAO   {

    public CatagoryDAOImpl() {
        super( Catagory.class);
    }

    public List<Item> findCatagoryItems(Long catagory) {
        return (List<Item>) this.findById(catagory).getItemIdCollection();
    }

    

}
