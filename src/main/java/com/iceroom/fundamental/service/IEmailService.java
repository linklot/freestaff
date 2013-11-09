package com.iceroom.fundamental.service;

import javax.servlet.ServletContext;

/**
 * @author Lincoln
 *
 */
public interface IEmailService {
    
    void clearSentList();
    
    void testSendMail(ServletContext context);
    
    /**
     * Send an email to notify the candidate about the invitation.
     * @param candidate_email The candidate's email
     */
    void sendInviEmail(String candidate_email);
    
    /**
     * Send a welcome email
     * @param account The candidate's account.
     * @param candidate_email The candidate's email.
     */
    void sendWelcomeEmail(String account, String candidate_email);
    
    /**
     * To notify the user that password has been reset.
     * @param account User's account.
     * @param email User's email.
     * @param newPWD The new password.
     */
    void sendResetPasswordEmail(String account, String email, String newPWD);
    
    /**
     * To send an email to the particualr visa advice email address.
     * @param fName First name.
     * @param lName Last name.
     * @param phone Phone number.
     * @param email Email address.
     * @param visaType The visa type.
     * @param refCode The referal code.
     */
    void sendVisaAdviceEmail(String fName, String lName, String phone, String email,
            int visaType, String refCode);
    
    /**
     * Send a prompt email to a candidate.
     * @param to The candidate's email address.
     * @param firstName The candidate's first name.
     */
    void sendPromptEmail(String to, String firstName);
    
}
