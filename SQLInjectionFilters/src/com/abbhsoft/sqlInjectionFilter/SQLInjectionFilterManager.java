/*
 * SQLInjectionFilterManager.java
 *
 * Created on Aug 29, 2007, 10:21:26 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.sqlInjectionFilter;

/**
 *
 * @author shannan
 *  
 * filters and given string by applying all the filters
 */
public class SQLInjectionFilterManager {

    private SQLInjectionFilterManager() {
    }
    // define filters
    private SQLInjectionFilter sqlInjectionCommentsFilter = new SQLInjectionCommentsFilter();
    private SQLInjectionFilter sqlInjectionSingleAndDoubleQuoteFilter = new SQLInjectionSingleAndDoubleQuotesFilter();
    private SQLInjectionFilter sqlInjectionOrFilter = new SQLInjectionOrFilter();
    private static final SQLInjectionFilterManager instance = new SQLInjectionFilterManager();

    // apply filters
    public String filter(String filterString) {
        if (filterString == null || filterString.trim().length() == 0 ) {
            return filterString;
        }
        filterString = this.sqlInjectionCommentsFilter.filter(filterString);
        //filterString = this.sqlInjectionSingleAndDoubleQuoteFilter.filter(filterString);
        filterString = this.sqlInjectionOrFilter.filter(filterString);
        return filterString;
    }

    public static SQLInjectionFilterManager getInstance() {
        return instance;
    }
}
