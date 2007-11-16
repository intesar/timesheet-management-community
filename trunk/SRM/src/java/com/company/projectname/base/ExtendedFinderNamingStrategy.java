package com.company.projectname.base;

import java.lang.reflect.Method;



/**
 * Looks up Hibernate named queries based on the simple name of the invoked class and the method
 * name of the invocation.
 * 
 * @author pmellqvist
 * @see http://www-128.ibm.com/developerworks/java/library/j-genericdao.html
 */
public class ExtendedFinderNamingStrategy implements FinderNamingStrategy {

   // Always look for queries that start with findBy (even if method is iterateBy... or scrollBy...)
   public String queryNameFromMethod(Class findTargetType, Method finderMethod) {
      String methodName = finderMethod.getName();
      String methodPart = methodName;
      if (methodName.startsWith("find")) {
         // No-op
      } else if (methodName.startsWith("listBy")) {
         methodPart = "findBy" + methodName.substring("listBy".length());
      } else if (methodName.startsWith("iterateBy")) {
         methodPart = "findBy" + methodName.substring("iterateBy".length());
      } else if (methodName.startsWith("scrollBy")) {
         methodPart = "findBy" + methodName.substring("scrollBy".length());
      }
      return findTargetType.getSimpleName() + "." + methodPart;
   }

}
