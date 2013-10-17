/**
 * 
 */
package com.iceroom.fundamental.service.impl;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.iceroom.fundamental.dao.ICandidateDao;
import com.iceroom.fundamental.dao.IEduHistoryDao;
import com.iceroom.fundamental.dao.IEmpHistoryDao;
import com.iceroom.fundamental.dao.IEmployerDao;
import com.iceroom.fundamental.dao.IRoleDao;
import com.iceroom.fundamental.dao.IUserDao;
import com.iceroom.fundamental.entity.Candidate;
import com.iceroom.fundamental.entity.EduHistory;
import com.iceroom.fundamental.entity.EmpHistory;
import com.iceroom.fundamental.entity.Employer;
import com.iceroom.fundamental.entity.Role;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.service.IAccountService;
import com.iceroom.fundamental.service.IEmailService;
import com.iceroom.fundamental.util.StringUtil;

/**
 * @author Lincoln
 *
 */
public class AccountService implements IAccountService {
    
    private IUserDao userDao;
    private IRoleDao roleDao;
    private ICandidateDao candidateDao;
    private IEmployerDao employerDao;
    private IEmpHistoryDao empHistoryDao;
    private IEduHistoryDao eduHistoryDao;
    private IEmailService emailService;
    private String hql;
    private final String FIRST_ACCOUNT = "c10086";// If there is no candidate, use this as the first account.
    private final String ROLE_CANDIDATE_NAME = "ROLE_CANDIDATE";// the role name of candidates.
    private final String ROLE_EMPLOYER_NAME = "ROLE_EMPLOYER";// the role name of employers

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAccountService#registerCandidate(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public String registerCandidate(String firstName, String lastName,
            String email, String password) {
        
        long id = 0;
        String account = "";
        
        /* Step 1, create a new User entity. */
        //      1.1 Query the biggest user account
        hql = "from User u where u.account like 'c%' order by u.account desc";
        User lastUser = userDao.findSingleByHql(hql);
        if(lastUser == null) {
            // The first registration
            id = this.createCandidate(FIRST_ACCOUNT, password);
        } else {
            // Get the last registration number
            String last_account = lastUser.getAccount();
            int number = Integer.parseInt(last_account.substring(1));
            account = "c" + ++number;
            id = this.createCandidate(account, password);
        }
        
        /* Step 2, set the user's role to "ROLE_CANDIDATE". */
        User user = userDao.getEntityById(id);
        hql = "from Role r where r.name=?1";
        Role role = roleDao.findSingleByHql(hql, ROLE_CANDIDATE_NAME);
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        userDao.update(user);
        
        /* Step 3, initialise the user's candidate information. */
        Candidate candidate = new Candidate();
        candidate.setUser(user);
        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        candidate.setEmail(email);
        candidate.setPicUrl("");
        candidate.setMobileNo("");
        candidate.setPhoneNo("");
        candidate.setCvUrl("");
        candidate.setBirthCountry("");
        candidate.setCurrCity("");
        candidate.setCurrCountry("");
        candidate.setCurrVisaStatus("");
        candidate.setListening("");
        candidate.setReading("");
        candidate.setWriting("");
        candidate.setSpeaking("");
        candidate.setOverall("");
        candidate.setTestDate("");
        candidate.setTestRefNo("");
        candidate.setClassif("");
        candidate.setSubClassif("");
        candidate.setHighestQualif("");
        candidate.setQualifName("");
        candidate.setSkillAssess(false);
        candidate.setAssessAuth("");
        candidate.setAssessDate("");
        candidate.setAssessRefNo("");
        candidate.setCanPayAirfare(false);
        candidate.setCanPayVisaCost(false);
        candidate.setKeySkill1("");
        candidate.setKeySkill2("");
        candidate.setKeySkill3("");
        candidate.setKeySkill4("");
        candidate.setKeySkill5("");
        candidate.setPitch("");
        candidate.setInterests("");
        candidate.setVideoUrl("");
        id = ((Long)candidateDao.create(candidate)).longValue();// Get id of the Candidate
        
        /* Step 4, initialise employment history and education history entities. */
        candidate = candidateDao.getEntityById(id);
        for(int i=0; i<5; i++) {
            EmpHistory eh = new EmpHistory();
            eh.setCandidate(candidate);
            eh.setName("");
            eh.setSeq(i);
            eh.setLoc("");
            eh.setFrom("");
            eh.setTo("");
            eh.setJobTitle("");
            eh.setDuty("");
            empHistoryDao.create(eh);
        }
        for(int i=0; i<3;i++) {
            EduHistory eh = new EduHistory();
            eh.setCandidate(candidate);
            eh.setQualifType("");
            eh.setUni("");
            eh.setLoc("");
            eh.setComplDate("");
            eduHistoryDao.create(eh);
        }
        
        /* Step 5, send a welcome email to the emial address */
        emailService.sendWelcomeEmail(account, email);
        
        return user.getAccount();
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAccountService#getCurrentUser()
     */
    @Override
    @Transactional(readOnly=true)
    public User getCurrentUser() {
        String account = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails)
            account = ((UserDetails)principal).getUsername();
        else account = principal.toString();
        User user = userDao.getUserByAccount(account);
        if(user != null) return user;
        else return new User();
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAccountService#getCurrentUserFirstName()
     */
    @Override
    @Transactional(readOnly=true)
    public User getCurrentCandidate() {
        User user = this.getCurrentUser();
        Candidate candidate = user.getCandidate();
        candidate.getEmpHistories().size();
        candidate.getEduHistories().size();
        candidate.getPaymentHistories().size();
        return user;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAccountService#changePwd(long, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public boolean changePwd(long userId, String old_pwd, String n_pwd) {
        User user = userDao.getEntityById(userId);
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String encryption = encoder.encodePassword(old_pwd, user.getAccount());
        if(encryption.equals(user.getPassword())) {
            /* user-input password is correct,
             * change the password to the new one. */
            encryption = encoder.encodePassword(n_pwd, user.getAccount());
            user.setPassword(encryption);
            userDao.update(user);
            return true;
        } else return false;
    }
    
    /**
     * Create a new candidate User entity
     * @param account
     * @param password
     * @return
     */
    private long createCandidate(String account, String password) {
        User user = new User();
        user.setAccount(account);
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        password = encoder.encodePassword(password, account);
        user.setPassword(password);
        user.setEnabled(true);
        user.setRegDate(Calendar.getInstance());
        return (Long)userDao.create(user);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAccountService#registerEmployer(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional
    public void registerEmployer(User user) {
        /* Step 1, create a new User entity. */
        User newUser = new User();
        newUser.setAccount(user.getAccount());
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String password = encoder.encodePassword(user.getPassword(), user.getAccount());
        newUser.setPassword(password);
        newUser.setEnabled(true);
        newUser.setRegDate(Calendar.getInstance());
        long userId = (Long)userDao.create(newUser);
        
        /* Step 2, set the user's role to ROLE_EMPLOYER. */
        newUser = userDao.getEntityById(userId);
        String hql = "from Role r where r.name=?1";
        Role role = roleDao.findSingleByHql(hql, ROLE_EMPLOYER_NAME);
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        newUser.setRoles(roles);
        userDao.update(newUser);
        
        /* Step 3, Initialise the user's employer information. */
        Employer emp = new Employer();
        emp.setUser(newUser);
        emp.setName(user.getEmployer().getName());
        emp.setPhone(user.getEmployer().getPhone());
        emp.setEmail(user.getEmployer().getEmail());
        emp.setAddrStreet(user.getEmployer().getAddrStreet());
        emp.setAddrCity(user.getEmployer().getAddrCity());
        emp.setAddrState(user.getEmployer().getAddrState());
        emp.setAddrCountry(user.getEmployer().getAddrCountry());
        emp.setZip(user.getEmployer().getZip());
        emp.setStatement(user.getEmployer().getStatement());
        employerDao.create(emp);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAccountService#retrievePWD(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public boolean retrievePWD(String account, String email) {
        User user = userDao.getUserByAccount(account);
        if(user == null) return false;// This account does not exist.
        else {
            if(user.getCandidate() != null) {
                // A candidate
                Candidate candidate = user.getCandidate();
                if(candidate.getEmail().equals(email)) {
                    // Email is correct
                    String newPWD = StringUtil.randomString();
                    resetPWDSendEmail(user, email, newPWD);
                    return true;
                } else return false;// Wrong email.
            } else if(user.getEmployer() != null) {
                // An employer
                Employer employer = user.getEmployer();
                if(employer.getEmail().equals(email)) {
                    // Email is correct.
                    String newPWD = StringUtil.randomString();
                    resetPWDSendEmail(user, email, newPWD);
                    return true;
                } else return false; // Wrong email
            } else return false;// An error occurs.
        }
    }
    
    /**
     * To reset a user's password and send an email notification.
     * @param User The User instance.
     * @param email User's email address.
     * @param newPWD The new password
     */
    private void resetPWDSendEmail(User user, String email, String newPWD) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String password = encoder.encodePassword(newPWD, user.getAccount());
        user.setPassword(password);
        userDao.update(user);
        
        // Send email
        emailService.sendResetPasswordEmail(user.getAccount(), email, newPWD);
    }

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @param roleDao the roleDao to set
     */
    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * @param candidateDao the candidateDao to set
     */
    public void setCandidateDao(ICandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    /**
     * @param employerDao the employerDao to set
     */
    public void setEmployerDao(IEmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    /**
     * @param empHistoryDao the empHistoryDao to set
     */
    public void setEmpHistoryDao(IEmpHistoryDao empHistoryDao) {
        this.empHistoryDao = empHistoryDao;
    }

    /**
     * @param eduHistoryDao the eduHistoryDao to set
     */
    public void setEduHistoryDao(IEduHistoryDao eduHistoryDao) {
        this.eduHistoryDao = eduHistoryDao;
    }

    /**
     * @param emailService the emailService to set
     */
    public void setEmailService(IEmailService emailService) {
        this.emailService = emailService;
    }

}
