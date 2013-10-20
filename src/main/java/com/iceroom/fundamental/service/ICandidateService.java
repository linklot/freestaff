/**
 * 
 */
package com.iceroom.fundamental.service;


import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iceroom.fundamental.entity.EduHistory;
import com.iceroom.fundamental.entity.EmpHistory;
import com.iceroom.fundamental.entity.Employer;
import com.iceroom.fundamental.entity.Invitation;
import com.iceroom.fundamental.entity.User;

/**
 * @author Lincoln
 *
 */
public interface ICandidateService {
    
    /**
     * Update a candidate's avatar photo.
     * @param id The id of the User entity.
     * @param image The photo file uploaded.
     */
    void updateAvatar(long id, MultipartFile image) throws Exception;
    
    /**
     * Get a candidate's avatar path including file name.
     * @param id The candidate's User entity id.
     * @return {@link String}
     */
    String getAvatarPath(long id);
    
    /**
     * Upadate a candidate's classification information.
     * @param user The User entity.
     * @param classifId The id of the classification chosen by the candidate.
     * @param subClassifId The id of the sub-classification chosen by the candidate.
     */
    void saveClassif(User user, long classifId, long subClassifId);
    
    /**
     * Update a candidate's IELTS score
     * @param user The User entity.
     */
    void saveIelts(User user);
    
    /**
     * Update a candidate's key skills
     * @param user The User entity.
     */
    void saveKeySkills(User user);
    
    /**
     * Update a candidate's skill assessment.
     * @param user The User entity.
     */
    void saveSkillAssess(User user);
    
    /**
     * Update a candidate's elvator pitch.
     * @param user The User entity.
     */
    void savePitch(User user);
    
    /**
     * Get a candidate's employment history.
     * @param user The User entity.
     * @return List&lt;{@link EmpHistory}&gt;
     */
    List<EmpHistory> getUserEmpHistories(User user);
    
    /**
     * Update a candidate's employment history.
     * @param user The User instance
     * @param empHistories List&lt;{@link EmpHistory}&gt;
     */
    void saveEmpHistory(User user, List<EmpHistory> empHistories);
    
    /**
     * Get a candidate's education history.
     * @param user The User entity.
     * @return List&lt;{@link EduHistory}&gt;
     */
    List<EduHistory> getUserEduHistories(User user);
    
    void saveEduHistory(User user, List<EduHistory> eduHistories);
    
    /**
     * Update a candidate's interests.
     * @param user The User entity.
     */
    void saveInterests(User user);
    
    /**
     * Upload the candidate's CV and update the entity.
     * @param user The User entity.
     * @param file The CV file.
     */
    void saveCV(User user, MultipartFile file) throws Exception;
    
    /**
     * Get a candidate's CV file.
     * @param user The User entity.
     * @return {@link File} The CV file.
     */
    File getCVFile(User user);
    
    /**
     * Get number of new invitations (i.e. status is 1) of current candidate.
     * @param userId The id of current User.
     * @return int The number of new invitations.
     */
    int getNewInvitationCount(long userId);
    
    /**
     * Get all invitations of a candidate.
     * @param userId The id of the candidate.
     * @return List&lt{@link Invitation}&gt;
     */
    List<Invitation> getInvitations(long userId);
    
    /**
     * Accept an invitation.
     * @param id The id of the Invitation entity.
     */
    void acceptInvitation(long id);
    
    /**
     * Decline an invitation.
     * @param id The id of the Invitation entity.
     */
    void declineInvitation(long id);
    
    /**
     * Get the Employer entity related to an invitation.
     * @param id The id of the invitation.
     * @return {@link Employer}
     */
    Employer getEmployerByInvitation(long id);
    
    /**
     * Update a candidate's first name, last name and email.
     * @param user
     */
    void updateCandidateNameEmail(User user);
    
    /**
     * Update a candidate's video url.
     * @param url The url.
     */
    void updateVideoUrl(String url);
    
    /**
     * Persist a Feedback entity.
     * @param user The User object who sends the feedback.
     * @param content The content of the feedback.
     */
    void saveFeedback(User user, String content);

}
