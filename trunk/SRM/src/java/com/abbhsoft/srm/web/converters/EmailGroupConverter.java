/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.web.converters;

import com.abbhsoft.srm.model.EmailGroup;
import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.web.formBeans.EmailGroupBean;

/**
 *
 * @author mdshannan
 */
public class EmailGroupConverter {

    public static EmailGroup toModel(EmailGroupBean bean) {
       EmailGroup model = new EmailGroup();
       model.setOwner(bean.getOwner());
       model.setGroupEmail(bean.getGroupEmail());
       model.setSubscribeEmail(bean.getSubscribeEmail());
       model.setUnsubscribeEmail(bean.getUnSubscribeEmail()); 
  
       if ( bean.getUniversity() != null && bean.getUniversity() > 0 ) {
            University u = new University(bean.getUniversity());
            model.setUniversity(u);
        }
       return model;
    }

    public static EmailGroupBean toFormBean(EmailGroup Model) {
        return null;
    }
}
