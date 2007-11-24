/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service;

/**
 *
 * @author mdshannan
 */
public interface EMailService {

    static final String SMTP_HOST_NAME = "smtp.gmail.com";
    static final String SMTP_PORT = "465";
    static final String emailMsgTxt = "ABBHSOFT Reminder";
    static final String emailSubjectTxt = "ABBHSOFT Reminder, Batching starting soon," +
            "Contact Us ASAP...";
    static final String emailFromAddress = "mdshannan@gmail.com";
    static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    static final String[] sendTo = {"mohdshannan@yahoo.com"};

    void SendMail(String[] sendTo);
    void sendEmail (String toAddress, String body );
}
