package com.abbhsoft.srm.base;

import org.springframework.aop.support.DefaultIntroductionAdvisor;


/**
 * @author pmellqvist
 * @see http://www-128.ibm.com/developerworks/java/library/j-genericdao.html
 */
public class FinderIntroductionAdvisor extends DefaultIntroductionAdvisor {
   private static final long serialVersionUID = -8219814032032259554L;

   public FinderIntroductionAdvisor() {
      super(new FinderIntroductionInterceptor());
   }
}
