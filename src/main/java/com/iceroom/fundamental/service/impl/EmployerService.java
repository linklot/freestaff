package com.iceroom.fundamental.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.iceroom.fundamental.dao.ICandidateDao;
import com.iceroom.fundamental.dao.IClassifDao;
import com.iceroom.fundamental.dao.IEmployerDao;
import com.iceroom.fundamental.dao.IFeedbackDao;
import com.iceroom.fundamental.dao.IInvitationDao;
import com.iceroom.fundamental.dao.IUserDao;
import com.iceroom.fundamental.entity.Candidate;
import com.iceroom.fundamental.entity.Classif;
import com.iceroom.fundamental.entity.Employer;
import com.iceroom.fundamental.entity.Feedback;
import com.iceroom.fundamental.entity.Invitation;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.service.IAccountService;
import com.iceroom.fundamental.service.IEmailService;
import com.iceroom.fundamental.service.IEmployerService;

/**
 * @author Lincoln
 *
 */
public class EmployerService implements IEmployerService {
    
    private IUserDao userDao;
    private ICandidateDao candidateDao;
    private IEmployerDao employerDao;
    private IClassifDao classifDao;
    private IInvitationDao invitationDao;
    private String cvFilePath;
    private IEmailService emailService;
    private IAccountService accountService;
    private IFeedbackDao feedbackDao;

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#saveProfile(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional
    public void saveProfile(User user) {
        Employer emp = user.getEmployer();
        User _user = userDao.getEntityById(user.getId());
        Employer _employer = _user.getEmployer();
        _employer.setName(emp.getName());
        _employer.setPhone(emp.getPhone());
        _employer.setEmail(emp.getEmail());
        _employer.setAddrStreet(emp.getAddrStreet());
        _employer.setAddrCity(emp.getAddrCity());
        _employer.setAddrState(emp.getAddrState());
        _employer.setZip(emp.getZip());
        _employer.setAddrCountry(emp.getAddrCountry());
        _employer.setStatement(emp.getStatement());
        employerDao.update(_employer);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#getClassifName(long)
     */
    @Override
    @Transactional(readOnly=true)
    public Classif getClassifById(long id) {
        Classif classif = classifDao.getEntityById(id);
        return classif;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#searchCandidates(java.lang.String, long, long)
     */
    @Override
    @Transactional(readOnly=true)
    public List<User> searchCandidates(String keywords, String classif,
            String subClassif, String birthCountry, String currCity,
            String currCountry, int currVisaStatus, String highestQualif,
            String qualifName, int canPayAirfare, int canPayVisaCost) {
        String hql = "from User u where u.candidate.id is not null";// Query all candidates.
        
        // Filter out candidates haven't paid.
        hql += " and u.candidate.membershipTo >= current_date()";
        
        // Add search criteria
        if(!classif.equals("") ) {
            // Add classification as a criterion.
            hql += " and u.candidate.classif=:classif";
        }
        if(!subClassif.equals("")) {
            // Add sub-classification as a criterion.
            hql += " and u.candidate.subClassif=:subClassif";
        }
        
        if(!birthCountry.equals("")) hql += " and u.candidate.birthCountry like :birthCountry";
        if(!currCity.equals("")) hql += " and u.candidate.currCity like :currCity";
        if(!currCountry.equals("")) hql += " and u.candidate.currCountry like :currCountry";
        if(currVisaStatus != 9) hql += " and u.candidate.currVisaStatus = :currVisaStatus";
        if(!highestQualif.equals("9")) hql += " and u.candidate.highestQualif = :highestQualif";
        if(!qualifName.equals("")) hql += " and u.candidate.qualifName like :qualifName";
        if(canPayAirfare != 9) {
            if(canPayAirfare == 1) hql += " and u.candidate.canPayAirfare is true";
            else hql += " and u.candidate.canPayAirfare is false";
        }
        if(canPayVisaCost != 9) {
            if(canPayVisaCost == 1) hql += " and u.candidate.canPayVisaCost is true";
            else hql += " and u.candidate.canPayVisaCost is false";
        }
        
        if(!keywords.equals("")) {
            String[] keyword = keywords.split(" ");
            hql += " and (";
            int index = 0;
            for(@SuppressWarnings("unused") String kw : keyword) {
                index ++;
                String key = "kw" + index;
                hql += "u.candidate.highestQualif like :"+ key +
                       " or u.candidate.qualifName like :"+ key +
                       " or u.candidate.keySkill1 like :"+ key +
                       " or u.candidate.keySkill2 like :"+ key +
                       " or u.candidate.keySkill3 like :"+ key +
                       " or u.candidate.keySkill4 like :"+ key +
                       " or u.candidate.keySkill5 like :"+ key +
                       " or u.candidate.pitch like :"+ key +
                       " or u.candidate.interests like :"+ key;
                hql += " or ";
            }
            hql = hql.substring(0, hql.length() - 4);
            hql += ")";
        }
        hql += " order by u.candidate.firstName";
        
        // Construct the parameter key-value pairs
        Map<String, String> kvp = new HashMap<String, String>();
        if(!classif.equals("")) kvp.put("classif", classif);
        if(!subClassif.equals("")) kvp.put("subClassif", subClassif);
        if(!birthCountry.equals("")) kvp.put("birthCountry", "%"+ birthCountry +"%");
        if(!currCity.equals("")) kvp.put("currCity", "%"+ currCity +"%");
        if(!currCountry.equals("")) kvp.put("currCountry", "%"+ currCountry +"%");
        if(currVisaStatus != 9) kvp.put("currVisaStatus", String.valueOf(currVisaStatus));
        if(!highestQualif.equals("9")) kvp.put("highestQualif", highestQualif);
        if(!qualifName.equals("")) kvp.put("qualifName", qualifName);
//        if(canPayAirfare != 9) {
//            if(canPayAirfare == 1) kvp.put("canPayAirfare", String.valueOf(true));
//            else kvp.put("canPayAirfare", String.valueOf(false));
//        }
//        if(canPayVisaCost != 9) {
//            if(canPayVisaCost == 1) kvp.put("canPayVisaCost", String.valueOf(true));
//            else kvp.put("canPayVisaCost", String.valueOf(false));
//        }
        if(!keywords.equals("")) {
            String[] keyword = keywords.split(" ");
            int index = 0;
            for(String kw : keyword) {
                index ++;
                String key = "kw" + index;
                kvp.put(key, "%" + kw + "%");
            }
        }
        
        return userDao.findByPreparedStatement(hql, kvp);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#getCandidate(long)
     */
    @Override
    @Transactional
    public User getCandidate(long id) {
        User user = userDao.getEntityById(id);
        Candidate candidate = user.getCandidate();
        candidate.setViewCount(candidate.getViewCount() + 1);
        candidateDao.update(candidate);
        candidate.getEmpHistories().size();
        candidate.getEduHistories().size();
        return user;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#createInvitation(long, com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional
    public void createInvitation(long candId, User employer, String description) {
        Candidate candidate = userDao.getEntityById(candId).getCandidate();
        Employer _employer = userDao.getEntityById(employer.getId()).getEmployer();
        
        Invitation invitation = new Invitation();
        invitation.setCandidate(candidate);
        invitation.setEmployer(_employer);
        invitation.setStatus(Invitation.STATUS_SENT);
        invitation.setSendDate(Calendar.getInstance());
        invitation.setDescription(description);
        invitationDao.create(invitation);
        
        // Send a email notification to the candidate
        String receiver = candidate.getEmail();
        emailService.sendInviEmail(receiver);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#getInvitationsOfEmployer(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional(readOnly=true)
    public List<Invitation> getInvitationsOfEmployer(User user) {
        Employer employer = userDao.getEntityById(user.getId()).getEmployer();
        List<Invitation> invitations = new ArrayList<Invitation>();
        for(Invitation invitation : employer.getInvitations()) {
            invitation.getCandidate().getUser().getId();
            invitations.add(invitation);
        }
        return invitations;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#withdrawInvitation(long)
     */
    @Override
    @Transactional
    public void withdrawInvitation(long id) {
        Invitation invi = invitationDao.getEntityById(id);
        invi.setStatus(Invitation.STATUS_WITHDRAWN);
        invitationDao.update(invi);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#resendInvitation(long)
     */
    @Override
    @Transactional
    public void resendInvitation(long id) {
        Invitation invi = invitationDao.getEntityById(id);
        invi.setStatus(Invitation.STATUS_SENT);
        invitationDao.update(invi);
        
        // Send a email notification to the candidate.
        Candidate candidate = invi.getCandidate();
        String receiver = candidate.getEmail();
        emailService.sendInviEmail(receiver);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#closeInvitation(long)
     */
    @Override
    @Transactional
    public void closeInvitation(long id) {
        Invitation invi = invitationDao.getEntityById(id);
        invi.setStatus(Invitation.STATUS_FINESHED);
        invitationDao.update(invi);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#getInvitationOfEmpCand(long, long)
     */
    @Override
    @Transactional(readOnly=true)
    public Invitation getInvitationOfEmpCand(long emp_id, long cand_id) {
        String hql = "from Invitation i where i.employer.user.id=?1 and i.candidate.user.id=?2";
        return invitationDao.findSingleByHql(hql, emp_id, cand_id);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#getCandCV(long)
     */
    @Override
    @Transactional(readOnly=true)
    public File getCandCV(long cand_id) {
        Candidate cand = candidateDao.getEntityById(cand_id);
        File file = null;
        if(!cand.getCvUrl().equals(""))
            file = new File(cvFilePath + cand.getCvUrl());
        return file;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#getCandidateCount()
     */
    @Override
    @Transactional(readOnly=true)
    public int getCandidateCount() {
        String hql = "from Candidate c";
        return candidateDao.findByHql(hql).size();
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#getCandidateStat()
     */
    @Override
    @Transactional(readOnly=true)
    public Integer[] getCandidateStat() {
        String hql = "from Candidate c";
        int cand_count = candidateDao.findByHql(hql).size();
        hql = "from Candidate c where c.membershipTo >= current_date()";
        int act_cand_count = candidateDao.findByHql(hql).size();
        Integer[] array = new Integer[] {cand_count, act_cand_count};
        return array;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#getInvitationCount(long)
     */
    @Override
    @Transactional(readOnly=true)
    public int getInvitationCount(long employerId) {
        String hql = "from Invitation i where i.employer.id=?1";
        return invitationDao.findByHql(hql, employerId).size();
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IEmployerService#saveFeedback(java.lang.String)
     */
    @Override
    @Transactional
    public void saveFeedback(String content) {
        User user = accountService.getCurrentUser();
        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setContent(content);
        feedback.setTime(Calendar.getInstance());
        feedbackDao.create(feedback);
    }

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @param employerDao the employerDao to set
     */
    public void setEmployerDao(IEmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    /**
     * @param classifDao the classifDao to set
     */
    public void setClassifDao(IClassifDao classifDao) {
        this.classifDao = classifDao;
    }

    /**
     * @param invitationDao the invitationDao to set
     */
    public void setInvitationDao(IInvitationDao invitationDao) {
        this.invitationDao = invitationDao;
    }

    /**
     * @param candidateDao the candidateDao to set
     */
    public void setCandidateDao(ICandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    /**
     * @param cvFilePath the cvFilePath to set
     */
    public void setCvFilePath(String cvFilePath) {
        this.cvFilePath = cvFilePath;
    }

    /**
     * @param emailService the emailService to set
     */
    public void setEmailService(IEmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * @param accountService the accountService to set
     */
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * @param feedbackDao the feedbackDao to set
     */
    public void setFeedbackDao(IFeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

}
