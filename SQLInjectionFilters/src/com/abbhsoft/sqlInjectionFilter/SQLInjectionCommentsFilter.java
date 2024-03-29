/*
 * CommentsFilter.java
 * 
 * Created on Aug 29, 2007, 9:51:29 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.sqlInjectionFilter;

/**
 *
 * @author shannan
 * 
 *  removes database comments (--, #, single & double quotes, *, and block comments)
 */
class SQLInjectionCommentsFilter implements SQLInjectionFilter {

    public SQLInjectionCommentsFilter() {
    }

    public String filter(String filter) {
        filter = filter.replaceAll("-", SPACE);
        filter = filter.replaceAll("--", SPACE);
        filter = filter.replaceAll("#", SPACE);
        filter = filter.replaceAll("/", SPACE);
        filter = filter.replaceAll("=", SPACE);        
        filter = filter.replace("*", SPACE);
        filter = filter.replaceAll("'", SPACE);
        filter = filter.replaceAll("\"", SPACE);        
        filter = filter.replaceAll(";", SPACE);
        filter = filter.replaceAll(":", SPACE);
        filter = filter.replaceAll("%", SPACE);
        return filter;
    }

}

