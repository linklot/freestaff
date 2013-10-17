package com.iceroom.fundamental.service;

/**
 * @author Lincoln
 *
 */
public interface IEmailService {
    
    void testSendMail();
    
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
    
}
