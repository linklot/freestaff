package com.iceroom.fundamental.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import com.iceroom.fundamental.dao.ICandidateDao;
import com.iceroom.fundamental.dao.IMembershipPromptDao;
import com.iceroom.fundamental.entity.Candidate;
import com.iceroom.fundamental.entity.MembershipPrompt;
import com.iceroom.fundamental.service.IEmailService;
import com.iceroom.fundamental.service.IScheduledTaskService;

/**
 * @author Lincoln
 *
 */
public class ScheduledTaskService implements IScheduledTaskService {
    
    private ICandidateDao candidateDao;
    private IMembershipPromptDao membershipPromptDao;
    private IEmailService emailService;
    private final long MILLIS_72_HOURS = 72 * 60 * 60 * 1000;
    private final long MILLIS_7_DAYS = 7 * 24 * 60 * 60 * 1000;
    
    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IScheduledTaskService#membershipCheckTask()
     */
    @Override
    @Scheduled(cron="0 0 2 * * *")// Triggered everyday at 2:00 am
//    @Scheduled(fixedDelay=15000)
    @Transactional
    public void membershipCheckTask() {
        this.checkCandidateMembership();
    }
    
    @Async
    private void checkCandidateMembership() {
        /* Get all candidates that are not activited yet. */
        String hql = "from Candidate c where c.membershipTo is null";
        List<Candidate> candidates = candidateDao.findByHql(hql);
        long millisNow = Calendar.getInstance().getTimeInMillis();
        for(Candidate candidate : candidates) {
            long millisRegDate = candidate.getUser().getRegDate().getTimeInMillis();
            if((millisNow - millisRegDate) > MILLIS_72_HOURS) {
                // This candidate has been registered for over 72 hours.
                Set<MembershipPrompt> prompts = candidate.getMembershipPrompts();
                if(prompts == null) {
                    // This candidate has not been prompted ever. Send an email to him/her.
                    String to = candidate.getEmail();
                    String firstName = candidate.getFirstName();
                    emailService.sendPromptEmail(to, firstName);
                    // Add a new record for this candidate
                    MembershipPrompt prompt = new MembershipPrompt();
                    prompt.setCandidate(candidate);
                    prompt.setPromptTime(Calendar.getInstance());
                    prompt.setToEmail(to);
                    membershipPromptDao.create(prompt);
                    
                } else if(prompts.size() == 0) {
                    // This candidate has not been prompted ever. Send an email to him/her.
                    String to = candidate.getEmail();
                    String firstName = candidate.getFirstName();
                    emailService.sendPromptEmail(to, firstName);
                    // Add a new record for this candidate
                    MembershipPrompt prompt = new MembershipPrompt();
                    prompt.setCandidate(candidate);
                    prompt.setPromptTime(Calendar.getInstance());
                    prompt.setToEmail(to);
                    membershipPromptDao.create(prompt);
                }
                else {
                    // This candidate has been prompted before. Check the sending time of the latest prompt.
                    Calendar latestPromptTime = Calendar.getInstance();
                    latestPromptTime.set(Calendar.YEAR, 1111);
                    for(MembershipPrompt prompt : prompts) {
                        Calendar promptTime = prompt.getPromptTime();
                        if(promptTime.after(latestPromptTime)) latestPromptTime = promptTime;
                    }
                    if((millisNow - latestPromptTime.getTimeInMillis()) > MILLIS_7_DAYS) {
                        // The candidate has not been prompted for 7 days. Send an email to him/her.
                        String to = candidate.getEmail();
                        String firstName = candidate.getFirstName();
                        emailService.sendPromptEmail(to, firstName);
                        // Add a new record for this candidate
                        MembershipPrompt prompt = new MembershipPrompt();
                        prompt.setCandidate(candidate);
                        prompt.setPromptTime(Calendar.getInstance());
                        prompt.setToEmail(to);
                        membershipPromptDao.create(prompt);
                    }
                }
            }
        }
        emailService.clearSentList();
    }

    /**
     * @param candidateDao the candidateDao to set
     */
    public void setCandidateDao(ICandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    /**
     * @param membershipPromptDao the membershipPromptDao to set
     */
    public void setMembershipPromptDao(IMembershipPromptDao membershipPromptDao) {
        this.membershipPromptDao = membershipPromptDao;
    }

    /**
     * @param emailService the emailService to set
     */
    public void setEmailService(IEmailService emailService) {
        this.emailService = emailService;
    }
    
}
