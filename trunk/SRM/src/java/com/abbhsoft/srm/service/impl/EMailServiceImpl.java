/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.EmailTemplateDao;
import com.abbhsoft.srm.model.EmailTemplate;
import com.abbhsoft.srm.service.EMailService;
import java.security.Security;
import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author mdshannan
 */

public class EMailServiceImpl implements EMailService {

    public EmailTemplate getEmailTemplate(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void SendMail(String[] sendTo) {
        try {

            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            sendSSMessage(sendTo, emailSubjectTxt, emailMsgTxt, emailFromAddress);
        } catch (MessagingException ex) {
            Logger.getLogger(EMailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendEmail(String toAddress, String body) {
        try {

            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            sendSSMessage(sendTo, emailSubjectTxt, body, emailFromAddress);
        } catch (MessagingException ex) {
            Logger.getLogger(EMailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendSSMessage(String recipients[], String subject,
            String message, String from) throws MessagingException {
        boolean debug = true;

        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("mdshannan", "Abbhamena");
                    }
                });

        session.setDebug(debug);

        Message msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport.send(msg);
    }
    // dao

    private EmailTemplateDao emailTemplateDao;

    public void setEmailTemplateDao(EmailTemplateDao emailTemplateDao) {
        this.emailTemplateDao = emailTemplateDao;
    }
    }

