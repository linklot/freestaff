package com.iceroom.fundamental.service.impl;

import java.util.Calendar;

import org.springframework.transaction.annotation.Transactional;

import com.iceroom.fundamental.dao.ICandidateDao;
import com.iceroom.fundamental.dao.IPaymentHistoryDao;
import com.iceroom.fundamental.dao.IUserDao;
import com.iceroom.fundamental.entity.Candidate;
import com.iceroom.fundamental.entity.PaymentHistory;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.service.IPaymentService;

/**
 * @author Lincoln
 *
 */
public class PaymentService implements IPaymentService {
    
    private final String MONTH_3 = "Freestaff Membership 3 months";
    private final String MONTH_6 = "Freestaff Membership 6 months";
    private final String MONTH_12 = "Freestaff Membership 12 months";
    
    private IUserDao userDao;
    private ICandidateDao candidateDao;
    private IPaymentHistoryDao paymentHistoryDao;
    
    private int month = 0;

    @Override
    @Transactional
    public void updateCandidateMembership(long userId, String itemName,
            String amount) {
        User user = userDao.getEntityById(userId);
        Candidate candidate = user.getCandidate();
        Calendar now = Calendar.getInstance();
        
        if(itemName.equals(MONTH_3)) month = 3;
        if(itemName.equals(MONTH_6)) month = 6;
        if(itemName.equals(MONTH_12)) month = 12;
        
        /* Create a PaymentHistory entity. */
        PaymentHistory history = new PaymentHistory();
        history.setCandidate(candidate);
        history.setDate(now);
        history.setAmount(amount);
        history.setDescription(itemName);
        paymentHistoryDao.create(history);
        
        /* Update Candidate entity */
        if(candidate.getMembershipFrom() == null) {
            // It's the first time that the user tops up.
            candidate.setMembershipFrom(now);
            Calendar to = Calendar.getInstance();
            to.add(Calendar.MONTH, month);
            candidate.setMembershipTo(to);
        } else {
            // Topped up before.
            if(candidate.getMembershipTo().getTimeInMillis() > now.getTimeInMillis()) {
                // Membership hasn't expired.
                Calendar to = candidate.getMembershipTo();
                to.add(Calendar.MONTH, month);
                candidate.setMembershipTo(to);
            } else {
                // Expired
                candidate.setMembershipFrom(now);
                Calendar to = Calendar.getInstance();
                to.add(Calendar.MONTH, month);
                candidate.setMembershipTo(to);
            }
        }
        candidateDao.update(candidate);
    }

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @param candidateDao the candidateDao to set
     */
    public void setCandidateDao(ICandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    /**
     * @param paymentHistoryDao the paymentHistoryDao to set
     */
    public void setPaymentHistoryDao(IPaymentHistoryDao paymentHistoryDao) {
        this.paymentHistoryDao = paymentHistoryDao;
    }
    
}
