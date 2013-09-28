/**
 * 
 */
package com.iceroom.fundamental.service.impl;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iceroom.fundamental.dao.ICandidateDao;
import com.iceroom.fundamental.dao.IClassifDao;
import com.iceroom.fundamental.dao.IEduHistoryDao;
import com.iceroom.fundamental.dao.IEmpHistoryDao;
import com.iceroom.fundamental.dao.IInvitationDao;
import com.iceroom.fundamental.dao.IUserDao;
import com.iceroom.fundamental.entity.Candidate;
import com.iceroom.fundamental.entity.EduHistory;
import com.iceroom.fundamental.entity.EmpHistory;
import com.iceroom.fundamental.entity.Employer;
import com.iceroom.fundamental.entity.Invitation;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.service.ICandidateService;
import com.iceroom.fundamental.util.StringUtil;

/**
 * @author Lincoln
 *
 */
public class CandidateService implements ICandidateService {
    
    private String avatarPath;
    private final String AVATAR_URL_PATH = "/res/avatar/";
    private IUserDao userDao;
    private ICandidateDao candidateDao;
    private IClassifDao classifDao;
    private IEmpHistoryDao empHistoryDao;
    private IEduHistoryDao eduHistoryDao;
    private IInvitationDao invitationDao;
    private String cvFilePath;

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#updateAvatar(long, org.springframework.web.multipart.MultipartFile)
     */
    @Override
    @Transactional
    public void updateAvatar(long id, MultipartFile image) throws Exception {
        /* Save the file to the path */
        String ori_name = image.getOriginalFilename();
        String extName = StringUtil.getExtName(ori_name);
        String fileName = id + "." + extName;
        File file = new File(avatarPath + fileName);
        FileUtils.writeByteArrayToFile(file, image.getBytes());
        
        /* Update associated Candidate entity */
        User user = userDao.getEntityById(id);
        Candidate candidate = user.getCandidate();
        candidate.setPicUrl(AVATAR_URL_PATH + fileName);
        candidateDao.update(candidate);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#getAvatarPath(long)
     */
    @Override
    @Transactional(readOnly=true)
    public String getAvatarPath(long id) {
        User user = userDao.getEntityById(id);
        Candidate candidate = user.getCandidate();
        return candidate.getPicUrl();
    }
    
    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#saveClassif(com.iceroom.fundamental.entity.User, int, int)
     */
    @Override
    @Transactional
    public void saveClassif(User user, long classifId, long subClassifId) {
        /* Fetch the name of the classification and the sub-classification */
        String classifName = "";
        String subClassifName = "";
        if(classifId != 0)
            classifName = classifDao.getEntityById(classifId).getName();
        if(subClassifId != 0)
            subClassifName = classifDao.getEntityById(subClassifId).getName();
        
        /* Fetch the Candidate entity instance */
        Candidate candidate = userDao.getEntityById(user.getId()).getCandidate();
        
        /* Modify values submitted by the user */
        candidate.setClassif(classifName);
        candidate.setSubClassif(subClassifName);
        candidate.setBirthCountry(user.getCandidate().getBirthCountry());
        candidate.setCurrCity(user.getCandidate().getCurrCity());
        candidate.setCurrCountry(user.getCandidate().getCurrCountry());
        candidate.setCurrVisaStatus(user.getCandidate().getCurrVisaStatus());
        candidate.setHighestQualif(user.getCandidate().getHighestQualif());
        candidate.setQualifName(user.getCandidate().getQualifName());
        candidate.setCanPayAirfare(user.getCandidate().isCanPayAirfare());
        candidate.setCanPayVisaCost(user.getCandidate().isCanPayVisaCost());
        
        /* Update Candidate entity */
        candidateDao.update(candidate);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#saveIelts(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional
    public void saveIelts(User user) {
        /* Fetch the Candidate instance */
        Candidate candidate = userDao.getEntityById(user.getId()).getCandidate();
        
        /* Modify values submitted by the user */
        candidate.setListening(user.getCandidate().getListening());
        candidate.setReading(user.getCandidate().getReading());
        candidate.setWriting(user.getCandidate().getWriting());
        candidate.setSpeaking(user.getCandidate().getSpeaking());
        candidate.setOverall(user.getCandidate().getOverall());
        
        /* Update Candidate entity */
        candidateDao.update(candidate);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#saveKeySkills(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional
    public void saveKeySkills(User user) {
        /* Fetch the Candidate instance */
        Candidate candidate = userDao.getEntityById(user.getId()).getCandidate();
        
        /* Modify values submitted by the user */
        candidate.setKeySkill1(user.getCandidate().getKeySkill1());
        candidate.setKeySkill2(user.getCandidate().getKeySkill2());
        candidate.setKeySkill3(user.getCandidate().getKeySkill3());
        candidate.setKeySkill4(user.getCandidate().getKeySkill4());
        candidate.setKeySkill5(user.getCandidate().getKeySkill5());
        
        /* Update Candidate entity */
        candidateDao.update(candidate);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#saveSkillAssess(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional
    public void saveSkillAssess(User user) {
        /* Fetch the Candidate instance */
        Candidate candidate = userDao.getEntityById(user.getId()).getCandidate();
        
        /* Modify values submitted by the user */
        candidate.setSkillAssess(user.getCandidate().isSkillAssess());
        candidate.setAssessAuth(user.getCandidate().getAssessAuth());
        candidate.setAssessDate(user.getCandidate().getAssessDate());
        candidate.setAssessRefNo(user.getCandidate().getAssessRefNo());
        
        /* Update Candidate entity */
        candidateDao.update(candidate);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#savePitch(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional
    public void savePitch(User user) {
        /* Fetch the Candidate instance */
        Candidate candidate = userDao.getEntityById(user.getId()).getCandidate();
        
        /* Modify values submitted by the user */
        candidate.setPitch(user.getCandidate().getPitch());
        
        /* Update Candidate entity */
        candidateDao.update(candidate);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#getUserEmpHistory(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional(readOnly=true)
    public List<EmpHistory> getUserEmpHistories(User user) {
        String hql = "from EmpHistory h where h.candidate.user.id=?1 order by h.seq";
        return empHistoryDao.findByHql(hql, user.getId());
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#saveEmpHistories(com.iceroom.fundamental.entity.User, java.util.List)
     */
    @Override
    @Transactional
    public void saveEmpHistory(User user, List<EmpHistory> empHistories) {
        user = userDao.getEntityById(user.getId());
        Candidate candidate = user.getCandidate();
        Set<EmpHistory> oriHistories = candidate.getEmpHistories();
        for(int i=0; i<empHistories.size(); i++) {
            EmpHistory history = empHistories.get(i);
            for(EmpHistory oriHistory : oriHistories) {
                if(oriHistory.getId() == history.getId()) {
                    /* Modify and save the data submitted by the user. */
                    oriHistory.setName(history.getName());
                    oriHistory.setLoc(history.getLoc());
                    oriHistory.setFrom(history.getFrom());
                    oriHistory.setTo(history.getTo());
                    oriHistory.setJobTitle(history.getJobTitle());
                    oriHistory.setDuty(history.getDuty());
                    empHistoryDao.update(oriHistory);
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#getUserEduHistories(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional(readOnly=true)
    public List<EduHistory> getUserEduHistories(User user) {
        String hql = "from EduHistory h where h.candidate.user.id=?1 order by h.id";
        return eduHistoryDao.findByHql(hql, user.getId());
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#saveEduHistory(com.iceroom.fundamental.entity.User, java.util.List)
     */
    @Override
    @Transactional
    public void saveEduHistory(User user, List<EduHistory> eduHistories) {
        user = userDao.getEntityById(user.getId());
        Candidate candidate = user.getCandidate();
        Set<EduHistory> oriHistories = candidate.getEduHistories();
        for(int i=0; i<eduHistories.size(); i++) {
            EduHistory history = eduHistories.get(i);
            for(EduHistory oriHistory : oriHistories) {
                if(oriHistory.getId() == history.getId()) {
                    /* Modify and save the date submitted by the user. */
                    oriHistory.setQualifType(history.getQualifType());
                    oriHistory.setUni(history.getUni());
                    oriHistory.setLoc(history.getLoc());
                    oriHistory.setComplDate(history.getComplDate());
                    eduHistoryDao.update(oriHistory);
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#saveInterests(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional
    public void saveInterests(User user) {
        Candidate candidate = userDao.getEntityById(user.getId()).getCandidate();
        candidate.setInterests(user.getCandidate().getInterests());
        candidateDao.update(candidate);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#saveCV(com.iceroom.fundamental.entity.User, org.springframework.web.multipart.MultipartFile)
     */
    @Override
    @Transactional
    public void saveCV(User user, MultipartFile file) throws Exception {
        Candidate candidate = userDao.getEntityById(user.getId()).getCandidate();
        long id = user.getId();
        
        /* Save file to the hard disk. */
        File cvfile = new File(cvFilePath + id + ".pdf");
        FileUtils.writeByteArrayToFile(cvfile, file.getBytes());
        
        /* Update Candidate entity. */
        candidate.setCvUrl(id + ".pdf");
        candidateDao.update(candidate);
        
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#getCVFilePath(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional(readOnly=true)
    public File getCVFile(User user) {
        Candidate candidate = userDao.getEntityById(user.getId()).getCandidate();
        File file = new File(cvFilePath + candidate.getCvUrl());
        return file;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#getNewInvitationCount(long)
     */
    @Override
    @Transactional(readOnly=true)
    public int getNewInvitationCount(long userId) {
        String hql = "from Invitation i where i.status=1 and i.candidate.user.id=?1";
        List<Invitation> invis = invitationDao.findByHql(hql, userId);
        return invis.size();
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#getInvitations(long)
     */
    @Override
    @Transactional
    public List<Invitation> getInvitations(long userId) {
        String hql = "from Invitation i where i.candidate.user.id=?1 and i.status<>6 order by i.status";
        List<Invitation> invis = invitationDao.findByHql(hql, userId);
        for(Invitation invi : invis) {
            invi.getEmployer().getId();
            /* At the same time, if the stauts is 'SENT', change it to 'VIEWED'. */
            if(invi.getStatus() == Invitation.STATUS_SENT) {
                invi.setStatus(Invitation.STATUS_VIEWED);
                invitationDao.update(invi);
            }
        }
        return invis;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#actionOnInvitation(long, int)
     */
    @Override
    @Transactional
    public void acceptInvitation(long id) {
        Invitation invi = invitationDao.getEntityById(id);
        invi.setStatus(Invitation.STATUS_ACCEPTED);
        invitationDao.update(invi);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#declineInvitation(long)
     */
    @Override
    @Transactional
    public void declineInvitation(long id) {
        Invitation invi = invitationDao.getEntityById(id);
        invi.setStatus(Invitation.STATUS_DECLINED);
        invitationDao.update(invi);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.ICandidateService#getEmployerByInvitation(long)
     */
    @Override
    @Transactional(readOnly=true)
    public Employer getEmployerByInvitation(long id) {
        Invitation invi = invitationDao.getEntityById(id);
        invi.getEmployer().getName();
        return invi.getEmployer();
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
     * @param classifDao the classifDao to set
     */
    public void setClassifDao(IClassifDao classifDao) {
        this.classifDao = classifDao;
    }

    /**
     * @param avatarUrl the avatarUrl to set
     */
    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
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
     * @param cvFilePath the cvFilePath to set
     */
    public void setCvFilePath(String cvFilePath) {
        this.cvFilePath = cvFilePath;
    }

    /**
     * @param invitationDao the invitationDao to set
     */
    public void setInvitationDao(IInvitationDao invitationDao) {
        this.invitationDao = invitationDao;
    }

}
