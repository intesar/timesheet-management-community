package com.abbhsoft.srm.base;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;



/**
 * Execute a finder method with the appropriate arguments.
 * 
 * @author pmellqvist
 * @see http://www-128.ibm.com/developerworks/java/library/j-genericdao.html
 */
public interface FinderExecutor<T> {
   List<T> executeFinder(Method method, Object[] queryArgs);

   Iterator<T> iterateFinder(Method method, Object[] queryArgs);

   //ScrollableResults scrollFinder(Method method, Object[] queryArgs);
}
