/*
 * ItemServiceImpl.java
 *
 * Created on Aug 20, 2007, 11:13:38 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.serviceImpl;

import com.abbhsoft.ecommerce.dao.CatagoryDAO;
import com.abbhsoft.ecommerce.model.Catagory;
import com.abbhsoft.ecommerce.model.Item;
import com.abbhsoft.ecommerce.service.CatagoryService;
import java.util.List;

/**
 *
 * @author shannan
 */
public class CatagoryServiceImpl implements CatagoryService {

    public CatagoryServiceImpl() {
    }

    public List<Catagory> getCatagories() {
        return (List<Catagory>) catagoryDAO.findAll();
    }

    public List<Item> getCatagoryItems(Long catagory) {
        return catagoryDAO.findCatagoryItems(catagory);
    }

    public void setCatagoryDAO(CatagoryDAO catagoryDAO) {
        this.catagoryDAO = catagoryDAO;
    }

   

    private CatagoryDAO catagoryDAO;
}
