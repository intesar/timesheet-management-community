package com.abbhsoft.srm.base;

import java.lang.reflect.Method;

/**
 * Used to locate a named query based on the called finder method.
 * 
 * @author pmellqvist
 * @see http://www-128.ibm.com/developerworks/java/library/j-genericdao.html
 */
public interface FinderNamingStrategy {

   public String queryNameFromMethod(Class findTargetType, Method finderMethod);

}
