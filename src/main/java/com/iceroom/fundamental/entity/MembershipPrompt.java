package com.iceroom.fundamental.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Lincoln
 *
 */
@Entity
@Table(name="membershipprompt")
public class MembershipPrompt {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_CANDIDATE_ID")
    private Candidate candidate;
    
    @Column(name="PROMPTTIME")
    private Calendar promptTime;
    
    @Column(name="TOEMAIL")
    private String toEmail;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the candidate
     */
    public Candidate getCandidate() {
        return candidate;
    }

    /**
     * @param candidate the candidate to set
     */
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    /**
     * @return the promptTime
     */
    public Calendar getPromptTime() {
        return promptTime;
    }

    /**
     * @param promptTime the promptTime to set
     */
    public void setPromptTime(Calendar promptTime) {
        this.promptTime = promptTime;
    }

    /**
     * @return the toEmail
     */
    public String getToEmail() {
        return toEmail;
    }

    /**
     * @param toEmail the toEmail to set
     */
    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }
}
