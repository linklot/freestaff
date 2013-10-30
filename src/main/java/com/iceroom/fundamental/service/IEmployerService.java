package com.iceroom.fundamental.service;

import java.io.File;
import java.util.List;

import com.iceroom.fundamental.entity.Classif;
import com.iceroom.fundamental.entity.Invitation;
import com.iceroom.fundamental.entity.User;

/**
 * The Employer service interface.
 * @author Lincoln
 *
 */
public interface IEmployerService {
    
    /**
     * Save an employer's profile.
     * At this moment, the User instance's Employer instance must not be null,<br/>
     * (i.e. the user <strong>must be an employer</strong>.)
     * @param user The User entity.
     */
    void saveProfile(User user);
    
    /**
     * Get the classification entity by its id.
     * @param id The id of the Classif entity.
     * @return The entity.{@link Classif}
     */
    Classif getClassifById(long id);
    
    /**
     * Search candidates by criteria.
     * @param keywords Key words, which are seperated by spaces.
     * @param classif The name of classification.
     * @param subClassif The name of sub-classification.
     * @return A set of User entity. List&lt;{@link User}&gt;
     */
    List<User> searchCandidates(String keywords, String classif,
            String subClassif, String birthCountry, String currCity,
            String currCountry, int currVisaStatus, String highestQualif,
            String qualifName, int canPayAirfare, int canPayVisaCost);
    
    /**
     * Get a candidate user entity.
     * @param id The id of the user.
     * @return {@link User}
     */
    User getCandidate(long id);
    
    /**
     * Create a new Invitation entity.
     * @param candId The id of a candidate.
     * @param employer The User entity as an employer.
     * @param description The description of this invitation
     */
    void createInvitation(long candId, User employer, String description);
    
    /**
     * Get all invitations of a particular employer.
     * @param user The User entity as an employer
     * @return List&lt;{@link Invitation}&gt;
     */
    List<Invitation> getInvitationsOfEmployer(User user);
    
    /**
     * Withdraw an invitation.
     * @param id The id of the Invitation entity.
     */
    void withdrawInvitation(long id);
    
    /**
     * Re-send an invitation.
     * @param id The id of the Invitation entity.
     */
    void resendInvitation(long id);
    
    /**
     * Close an invitation.
     * @param id The id of the Invitation entity.
     */
    void closeInvitation(long id);
    
    /**
     * Get a Invitation entity related to particular employer and candidate
     * @param emp_id The id of an employer.
     * @param cand_id The id of an candidate.
     * @return {@link Invitation}
     */
    Invitation getInvitationOfEmpCand(long emp_id, long cand_id);
    
    /**
     * Get the CV file of a candidate.
     * @param cand_id The id of the Candidate id.
     * @return {@link File}
     */
    File getCandCV(long cand_id);
    
    /**
     * Get the count of all candidates.
     * @return int
     */
    int getCandidateCount();
    
    /**
     * Get the count of all invitations sent by the employer.
     * @return int
     */
    int getInvitationCount(long employerId);
    
    /**
     * Save a Feedback entity.
     * @param content The content of the feedback.
     */
    void saveFeedback(String content);

}
