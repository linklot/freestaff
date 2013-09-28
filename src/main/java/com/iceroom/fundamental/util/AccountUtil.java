/**
 * 
 */
package com.iceroom.fundamental.util;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * The utility relating to user's account
 * @author Lincoln
 *
 */
public class AccountUtil {
    
    /**
     * Send email to the receiver.
     * @param mailSender
     * @param from
     * @param to
     * @param subject
     * @param msg
     */
    public static void sendMail(MailSender mailSender,
            String from, String to, String subject,
            String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        //message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }

}
