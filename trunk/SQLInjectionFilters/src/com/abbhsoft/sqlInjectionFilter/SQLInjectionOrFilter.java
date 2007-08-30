/*
 * SQLInjectionOrFilter.java
 * 
 * Created on Aug 29, 2007, 10:08:44 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.sqlInjectionFilter;

/**
 *
 * @author shannan
 *  
 *  removes ( or, OR ) 
 */
class SQLInjectionOrFilter implements SQLInjectionFilter {

    public SQLInjectionOrFilter() {
    }

    public String filter(String filter) {
        filter = filter.replace("or", SPACE );
        filter = filter.replace("OR", SPACE );
        return filter;
    }

}
