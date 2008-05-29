/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
//
//import net.sf.acegisecurity.context.security.SecureContext;

import org.acegisecurity.context.SecurityContextHolder;

//import net.sf.acegisecurity.context.security.SecureContextUtils;
//import net.sf.acegisecurity.providers.dao.User;

/**
 *
 * @author intesar.mohammed
 */
public class AcegiUtil {

    /*
     *  returns logged in user
     */
    public static final String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
        
    }
}
