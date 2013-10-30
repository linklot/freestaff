/**
 * 
 */
package com.iceroom.fundamental.service.impl;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import com.iceroom.fundamental.service.IEmailService;

/**
 * @author Lincoln
 *
 */
public class EmailService implements IEmailService {
    
    private String sender;// The sender's email
    private String password;// The sender's password
    private String smtp;// The smtp server's domain name

    @Override
    public void testSendMail() {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName(smtp);
            email.setSmtpPort(25);
            email.setAuthenticator(new DefaultAuthenticator(sender, password));
            email.addTo("linklot@gmail.com", "Lincoln Li");
            email.setFrom(sender, "FreeStaff Notification");
            email.setSubject("Test Email!");
            email.setHtmlMsg("<html><strong>Something</strong></html>");
            email.setTextMsg("Something");
            email.send();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmailService#sendInviEmail(java.lang.String)
     */
    @Override
    public void sendInviEmail(String candidate_email) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName(smtp);
            email.setSmtpPort(25);
            email.setAuthenticator(new DefaultAuthenticator(sender, password));
            email.addTo(candidate_email, "Candidate");
            email.setFrom(sender, "Freestaff Invitation Notification");
            email.setSubject("Invitation Notification");
            String htmlMsg = "<html><strong>Congratulations! An Australian Employer is keen to discuss a job opportunity with you! </strong>";
            htmlMsg += "<br/><br/>Please <a href='http://www.freestaff.com.au' target='_blank'>log in</a> to your Freestaff Account to view.";
            htmlMsg += "<br/><br/>Please do not reply to this message as it is from an unmonitored email address.";
            htmlMsg += "<br/><br/>Good luck!<br/><br/>The Freestaff Team<br/>w : <a href='http://www.freestaff.com.au' target='_blank'>www.freestaff.com.au</a>";
            htmlMsg += "<br/>fb : /freestaff<br/>tw : @freestaff1</html>";
            email.setHtmlMsg(htmlMsg);
            email.send();
        } catch(Exception ex) {
            // Sending email fails
        }
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmailService#sendWelcomeEmail(java.lang.String, java.lang.String)
     */
    @Override
    public void sendWelcomeEmail(String account, String candidate_email) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName(smtp);
            email.setSmtpPort(25);
            email.setAuthenticator(new DefaultAuthenticator(sender, password));
            email.addTo(candidate_email, "Candidate");
            email.setFrom(sender, "Freestaff");
            email.setSubject("Welcome!");
            String htmlMsg = "<html><strong>Welcome to Freestaff!<br/><br/> Your candidate account is <strong>"+ account +"</strong>.";
            htmlMsg += "<br/><br/> Please <a href='http://freesta.jvmhost.net/candidate'>sign in</a> with your account and password.";
            htmlMsg += "<br/><br/>The Freestaff Team<br/>w : <a href='http://www.freestaff.com.au' target='_blank'>www.freestaff.com.au</a>";
            htmlMsg += "<br/>fb : /freestaff<br/>tw : @freestaff1</html>";
            email.setHtmlMsg(htmlMsg);
            email.send();
        } catch(Exception ex) {
            // Sending email fails
        }
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmailService#sendResetPasswordEmail(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void sendResetPasswordEmail(String account, String email,
            String newPWD) {
        try {
            HtmlEmail _email = new HtmlEmail();
            _email.setHostName(smtp);
            _email.setSmtpPort(25);
            _email.setAuthenticator(new DefaultAuthenticator(sender, password));
            _email.addTo(email, "FreeStaff User");
            _email.setFrom(sender, "FreeStaff");
            _email.setSubject("Password Reset");
            String htmlMsg = "<html>Your password has been reset.<br/><br/>Your Account: "+ account +"<br/>New Password: "+ newPWD +"<br/><br/>Please change your password after you logged-in.";
            htmlMsg += "<br/><br/>The Freestaff Team<br/>w : <a href='http://www.freestaff.com.au' target='_blank'>www.freestaff.com.au</a>";
            htmlMsg += "<br/>fb : /freestaff<br/>tw : @freestaff1</html>";
            _email.setHtmlMsg(htmlMsg);
            _email.send();
        } catch(Exception ex) {
            // Sending email fails
        }
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param smtp the smtp to set
     */
    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }
    
}
