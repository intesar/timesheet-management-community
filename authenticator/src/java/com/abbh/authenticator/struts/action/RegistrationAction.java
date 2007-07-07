/*
 * RegistrationAction.java
 *
 * Created on July 4, 2007, 8:04 PM
 */

package com.abbh.authenticator.struts.action;

import com.abbh.authenticator.bo.BOFactory;
import com.abbh.authenticator.bo.UserBO;
import com.abbh.authenticator.entity.UserAddress;
import com.abbh.authenticator.entity.Users;
import com.abbh.authenticator.struts.bean.RegistrationBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
/**
 *
 * @author Mir Khurram Ali
 * @version
 */

public class RegistrationAction extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
    static BOFactory factory;
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        RegistrationBean bean = (RegistrationBean) form;
        UserBO userBO = (UserBO) factory.getBean("UserBO");        
        Users user = createUser(bean);
        userBO.addUser(user);
        
        return mapping.findForward(SUCCESS);        
    }
    
    private Users createUser(RegistrationBean bean)
    {
        Users user = new Users();
        user.setCompany(bean.getCompany());
        user.setFirstName(bean.getFirstName());
        user.setLastName(bean.getLastName());
        user.setMiddleName(bean.getMiddleName());
        user.setPassword(bean.getPassword1());
        user.setSecondaryEmail(bean.getSecondaryEmail());
        user.setSecretQuestion(bean.getSecretQuestion());
        user.setSecretAnswer(bean.getSecretAnswer());
        user.setSummary(bean.getSummary());
        user.setTitle(bean.getTitle());
        user.setUsername(bean.getUsername());
                
        return user;
    }
    
    private UserAddress createAddress(RegistrationBean bean)
    {        
        UserAddress address = new UserAddress();
        address.setStreet(bean.getAddressStreet());
        address.setCity(bean.getAddressCity());
        address.setState(bean.getAddressState());
        address.setCountry(bean.getAddressCountry());
        address.setZipcode(bean.getAddressZipcode());
        return address;
    }
}
