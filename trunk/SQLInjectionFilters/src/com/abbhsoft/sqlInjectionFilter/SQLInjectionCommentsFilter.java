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
 *  removes database comments (--, # and block comments)
 */
class SQLInjectionCommentsFilter implements SQLInjectionFilter {

    public SQLInjectionCommentsFilter() {
    }

    public String filter(String filter) {
        filter = filter.replace("--", SPACE);
        filter = filter.replace("#", SPACE);
        filter = filter.replace("/*", SPACE);
        filter = filter.replace("*/", SPACE);
        return filter;
    }

}
