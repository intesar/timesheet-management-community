/*
 * SQLInjectionSingleAndDoubleQuotesFilter.java
 * 
 * Created on Aug 29, 2007, 10:02:26 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.sqlInjectionFilter;

/**
 *
 * @author shannan
 * 
 *  remove single and double quotes
 */
class SQLInjectionSingleAndDoubleQuotesFilter implements SQLInjectionFilter {

    public SQLInjectionSingleAndDoubleQuotesFilter() {
    }

    public String filter(String filter) {
        filter = filter.replace("'", SPACE);
        filter = filter.replace("\"", SPACE);
        return filter;
    }

}
