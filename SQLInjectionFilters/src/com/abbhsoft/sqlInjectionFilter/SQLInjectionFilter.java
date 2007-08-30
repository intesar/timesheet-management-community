/*
 * SQLInjectionFilter.java
 * 
 * Created on Aug 29, 2007, 9:50:17 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.sqlInjectionFilter;

/**
 *
 * @author shannan
 */
public interface SQLInjectionFilter {
    public static final String SPACE = "";
    public abstract String filter ( String filter );
}
