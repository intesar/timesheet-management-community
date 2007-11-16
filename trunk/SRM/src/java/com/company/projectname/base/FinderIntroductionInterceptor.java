package com.company.projectname.base;


import java.util.Date;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
 * Connects the Spring AOP with the Hibernate DAO.
 *
 * For any method beginning with "find" this interceptor will use the FinderExecutor to call a
 * Hibernate named query.
 *
 * @author pmellqvist
 * @see http://www-128.ibm.com/developerworks/java/library/j-genericdao.html
 */
public class FinderIntroductionInterceptor implements IntroductionInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        FinderExecutor executor = null;
        String methodName = methodInvocation.getMethod().getName();
        if (methodName.startsWith("find")) {
            Object obj = null;
            try {
                obj = methodInvocation.proceed();
                if (methodInvocation.getThis() instanceof FinderExecutor) {
                    return ((FinderExecutor) methodInvocation.getThis()).executeFinder(methodInvocation.getMethod(), methodInvocation.getArguments());
                }
            } catch (Exception e) {
                if (methodInvocation.getThis() instanceof FinderExecutor) {
                    return ((FinderExecutor) methodInvocation.getThis()).executeFinder(methodInvocation.getMethod(), methodInvocation.getArguments());
                }
            }
        } else if (methodName.startsWith("create") ||
                methodName.startsWith("update") ||
                methodName.startsWith("delete")) {
            Object obj = null;
            try {
                obj = methodInvocation.proceed();
                if (methodInvocation.getThis() instanceof GenericDao) {
                    Object[] args = methodInvocation.getArguments();
                    BaseModel model = (BaseModel) args[0];
                    Date dt = new Date();
                    model.setLastModifiedDate(dt);
                    model.setLastModifiedUser(23L);
                    if (methodName.startsWith("create")) {
                        model.setCreateDate(dt);
                        model.setCreateUser(22L);
                        model.setLastModifiedDate(dt);
                        model.setLastModifiedUser(22L);
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }


        if (methodName.startsWith("finds") || methodName.startsWith("list")) {
            Object[] arguments = methodInvocation.getArguments();
            return executor.executeFinder(methodInvocation.getMethod(), arguments);
        } else if (methodName.startsWith("iterate")) {
            Object[] arguments = methodInvocation.getArguments();
            return executor.iterateFinder(methodInvocation.getMethod(), arguments);
        } else {
            return methodInvocation.proceed();
        }
    }

    public boolean implementsInterface(Class intf) {
        return intf.isInterface() && FinderExecutor.class.isAssignableFrom(intf);
    }
}