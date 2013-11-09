package com.iceroom.fundamental.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import com.iceroom.fundamental.service.IEmailService;
import com.iceroom.fundamental.util.StringUtil;

/**
 * @author Lincoln
 *
 */
public class EmailService implements IEmailService {
    
    private String sender;// The sender's email
    private String password;// The sender's password
    private String smtp;// The smtp server's domain name
    private String visaAdviceEmail;// The email address used to receive visa advice emails.
    private String preDefinedEmailLocation;// The path that stores all pre-defined email files.
    private static Set<String> sent_list;
    private String tmplMembershipNoti = "";

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmailService#clearSentList()
     */
    @Override
    public void clearSentList() {
        if(sent_list != null) sent_list.clear();
    }

    @Override
    public void testSendMail(ServletContext context) {
        try {
            String realPath = context.getRealPath(".");
            BufferedReader br = new BufferedReader(new FileReader(realPath + preDefinedEmailLocation + "/invitation.html"));
            String line = br.readLine();
            while(line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
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
            email.setFrom(sender, "Freestaff");
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

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmailService#sendVisaAdviceEmail(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String)
     */
    @Override
    public void sendVisaAdviceEmail(String fName, String lName, String phone,
            String email, int visaType, String refCode) {
        String visa_type = "";
        switch(visaType) {
            case 0:
                visa_type = "Work/Employer Sponsorship Visa";
                break;
            case 1:
                visa_type = "State Regional Sponsorship Visa";
                break;
            case 2:
                visa_type = "Skilled Migrant Visa";
                break;
            case 3:
                visa_type = "Working Holiday Visa<";
                break;
            case 4:
                visa_type = "Farm Work Visa";
                break;
            case 5:
                visa_type = "Student Visa";
                break;
            case 6:
                visa_type = "Travel/Visitors Visa";
                break;
            case 7:
                visa_type = "Family / Spouse / Partner Visa";
                break;
            case 8:
                visa_type = "Retirement Visa";
                break;
            case 9:
                visa_type = "Business Visa";
                break;
            case 10:
                visa_type = "Permanent/Temporary Residency";
                break;
            case 11:
                visa_type = "Other Visas";
                break;
            default:
                visa_type = "Unknown";
                break;
        }
        try {
            HtmlEmail _email = new HtmlEmail();
            _email.setHostName(smtp);
            _email.setSmtpPort(25);
            _email.setAuthenticator(new DefaultAuthenticator(sender, password));
            _email.addTo(visaAdviceEmail, "World-wide Visa");
            _email.setFrom(sender, "FreeStaff");
            _email.setSubject("Visa Advice Form");
            String htmlMsg = "<html>This is a visa advice request form.<br/><br/>";
            htmlMsg += "///----------------------------<br/>";
            htmlMsg += "<strong>First Name:</strong> " + fName + "<br/>";
            htmlMsg += "<strong>Last Name:</strong> " + lName + "<br/>";
            htmlMsg += "<strong>Phone:</strong> " + phone + "<br/>";
            htmlMsg += "<strong>Email:</strong> " + email + "<br/>";
            htmlMsg += "<strong>Visa Type:</strong> " + visa_type + "<br/>";
            htmlMsg += "<strong>Referral Code:</strong> " + refCode + "<br/>";
            htmlMsg += "///----------------------------";
            htmlMsg += "</html>";
            _email.setHtmlMsg(htmlMsg);
            _email.send();
        } catch(Exception ex) {
            // Sending email fails
        }
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmailService#sendPromptEmail(java.lang.String, java.lang.String)
     */
    @Override
    public void sendPromptEmail(String to, String firstName) {
        firstName = StringUtil.formatFirstName(firstName);
        if(sent_list == null) sent_list = new HashSet<String>();
        if(sent_list.isEmpty()) {
            // Send mail
            this.doSendPromptEmail(to, firstName);
            sent_list.add(to);
        } else {
            boolean sent = false;
            for(String receiver : sent_list) {
                if(receiver.equals(to)) {
                    sent = !sent;
                    break;
                }
            }
            if(!sent) {
                // Send mail
                this.doSendPromptEmail(to, firstName);
                sent_list.add(to);
            }
        }
    }
    
    /**
     * Execute the sending-prompt-email action.
     * @param to The receiver's email
     * @param firstName The receiver's first name.
     */
    private void doSendPromptEmail(String to, String firstName) {
        try {
            if(tmplMembershipNoti.equals("")) tmplMembershipNoti = readMailTemplate("membershipNotification.html");
            String mailContent = String.format(tmplMembershipNoti, firstName);
            HtmlEmail _email = new HtmlEmail();
            _email.setHostName(smtp);
            _email.setSmtpPort(25);
            _email.setAuthenticator(new DefaultAuthenticator(sender, password));
            _email.addTo(to, "FreeStaff User");
            _email.setFrom(sender, "FreeStaff");
            _email.setSubject("Freestaff - Membership Notification");
            _email.setHtmlMsg(mailContent);
            _email.send();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Read a email template.
     * @param fileName The file name.
     * @return String
     */
    private String readMailTemplate(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(preDefinedEmailLocation+ "/" +fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while(line != null) {
                sb.append(line);
                sb.append('\n');
                line = br.readLine();
            }
            br.close();
            return sb.toString();
        } catch(Exception ex) {
            ex.printStackTrace();
            return "";
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

    /**
     * @param visaAdviceEmail the visaAdviceEmail to set
     */
    public void setVisaAdviceEmail(String visaAdviceEmail) {
        this.visaAdviceEmail = visaAdviceEmail;
    }

    /**
     * @param preDefineEmailLocation the preDefineEmailLocation to set
     */
    public void setPreDefinedEmailLocation(String preDefinedEmailLocation) {
        this.preDefinedEmailLocation = preDefinedEmailLocation;
    }
    
}
