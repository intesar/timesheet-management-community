package com.company.projectname.base;

import java.lang.reflect.Method;


/**
 * Looks up Hibernate named queries based on the simple name of the invoked class and the method
 * name of the invocation.
 * 
 * @author pmellqvist
 * @see http://www-128.ibm.com/developerworks/java/library/j-genericdao.html
 */
public class SimpleFinderNamingStrategy implements FinderNamingStrategy {

   public String queryNameFromMethod(Class findTargetType, Method finderMethod) {
      return findTargetType.getSimpleName() + "." + finderMethod.getName();
   }

}
