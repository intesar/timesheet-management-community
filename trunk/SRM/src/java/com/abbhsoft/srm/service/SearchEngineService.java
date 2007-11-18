/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import java.util.List;

/**
 *
 * @author Intesar.Mohammed
 */
public interface SearchEngineService {
    
    /*
     *  user can enter
     *   single string or single date or single no (phone or age)
     *  and user can enter multiple strings or double dates
     * 
     *  date format MM/dd/yy
     * 
     */
    List search (String text );

}
