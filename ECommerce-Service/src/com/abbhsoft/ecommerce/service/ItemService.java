/*
 * ItemService.java
 * 
 * Created on Aug 20, 2007, 11:12:29 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.service;

import java.util.List;

/**
 *
 * @author shannan
 */
public interface ItemService {
    
    public abstract List getCatagories () ;
    public abstract List getCatagoryItems ( String catagory );

}
