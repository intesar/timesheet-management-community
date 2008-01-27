/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.base.BaseTest;
import com.abbhsoft.srm.model.EmailGroup;
import com.abbhsoft.srm.service.EMailService;
import java.util.List;
import com.abbhsoft.srm.service.EmailGroupService;

/**
 *
 * @author mdshannan
 */
public class EmailGroupServiceImplTest extends BaseTest {
    
    public EmailGroupServiceImplTest(String testName) {
        super(testName);
    }
    
    private EmailGroupService emailGroupService;
    
    private EMailService eMailService;

    public void setEMailService(EMailService eMailService) {
        this.eMailService = eMailService;
    }
    
    
    

   public void setEmailGroupService(EmailGroupService emailGroupService) {
        this.emailGroupService = emailGroupService;
    }


   

    /**
     * Test of recentEmailGroups method, of class EmailGroupServiceImpl.
     */
    public void testRecentEmailGroups() {
        System.out.println("recentEmailGroups");
        
        EmailGroup email1=new EmailGroup(0L,"hossainsadd@gmail.com");
        EmailGroup email2=new EmailGroup(1L,"bllllllllll");
        EmailGroup email3=new EmailGroup(2L,"ddddddddddddd");
        
        emailGroupService.save(email1);
        emailGroupService.save(email2);
        emailGroupService.save(email3);
        
        List<EmailGroup> result = emailGroupService.recentEmailGroups();
        assertTrue(result.size() >= 3);

        
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    public void testSendHTMLEmail() {
        String[] s = new String[] {"mdshannan@gmail.com"};
        this.eMailService.SendMail(s);
    }

}
