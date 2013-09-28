package com.iceroom.fundamental.service;

/**
 * @author Lincoln
 *
 */
public interface IEmailService {
    
    void testSendMail();
    
    /**
     * Send a email to notify the candidate about the invitation.
     * @param candidate_email The candidate's email
     */
    void sendInviEmail(String candidate_email);
    
}
