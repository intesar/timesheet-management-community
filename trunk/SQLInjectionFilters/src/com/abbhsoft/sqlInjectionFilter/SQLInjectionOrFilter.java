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
 *  finds patterns like (or, and, =, true, --, ;, insert, drop, alter, shutdown
 *  removes ( or, OR ) 
 */
class SQLInjectionOrFilter implements SQLInjectionFilter {

    public SQLInjectionOrFilter() {
    }

    public String filter(String filter) {
        String str = filter;
        int count = 0;
        str = str.toLowerCase();
        if (str.contains("or")) {
            count++;
        }
        if (str.contains("and")) {
            count++;
        }
        if (str.contains("true")) {
            count++;
        }
        if (str.contains("insert")) {
            count++;
        }
        if (str.contains("select")) {
            count++;
        }
        if (str.contains("update")) {
            count++;
        }
        if (str.contains("drop")) {
            count++;
        }
        if (str.contains("alter")) {
            count++;
        }
        if (str.contains("shutdown")) {
            count++;
        }
        if (count > 1) {
            str = str.replace("or", SPACE);
            str = str.replace("and", SPACE);
            str = str.replace("true", SPACE);
            str = str.replace("insert", SPACE);
            str = str.replace("select", SPACE);
            str = str.replace("update", SPACE);
            str = str.replace("drop", SPACE);
            str = str.replace("alter", SPACE);
            str = str.replace("shutdown", SPACE);
        }

        return filter;
    }
}
