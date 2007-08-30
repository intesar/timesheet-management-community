/*
 * ItemService.java
 * 
 * Created on Aug 24, 2007, 11:50:35 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.ecommerce.service;

import com.abbhsoft.ecommerce.model.Item;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author Mohammed Hamed
 */
public interface ItemService {


public Collection<Item> getAllItems();

public List<Item> getSearchedItems( String key );

}
