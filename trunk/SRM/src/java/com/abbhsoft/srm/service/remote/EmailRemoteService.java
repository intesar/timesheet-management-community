/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.remote;

import com.abbhsoft.srm.service.EMailService;
import com.abbhsoft.srm.service.ServiceFactory;

/**
 *
 * @author mdshannan
 */
public class EmailRemoteService {
    public void sentEmailToAddressWithBody(String to, String body) {
        EMailService service = (EMailService) ServiceFactory.getInstance().getBean("eMailServiceImpl");
        
    }
}
