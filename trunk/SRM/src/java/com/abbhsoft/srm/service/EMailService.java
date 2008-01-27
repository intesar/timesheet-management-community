/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.EmailTemplate;

/**
 *
 * @author mdshannan
 */
public interface EMailService {

    static final String SMTP_HOST_NAME = "smtp.gmail.com";
    static final String SMTP_PORT = "465";
    static final String EMAIL_MESSAGE_TEXT = "ABBHSOFT Reminder  <input type='text' name='name' />";
    static final String EMAIL_SUBJECT_TEXT = "ABBHSOFT Reminder, Batching starting soon," +
            "Contact Us ASAP...";
    static final String EMAIL_FROM_ADDRESS = "mdshannan@gmail.com";
    static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    static final String[] SEND_TO = {"mohdshannan@yahoo.com"};
    static final String SEND_FROM_USERNAME = "mdshannan1";
    static final String SEND_FROM_PASSWORD = "Abbh1234";
    static final String EMAIL_CONTENT_TYPE = "text/html";
    void SendMail(String[] sendTo);
    void sendEmail (String toAddress, String body );
    EmailTemplate getEmailTemplate(Long id);
}
