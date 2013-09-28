package com.iceroom.fundamental.entity;

import java.util.Calendar;

import javax.persistence.*;

import com.iceroom.fundamental.util.StringUtil;

/**
 * The invitation entity.
 * @author Lincoln
 *
 */
@Entity
@Table(name="invitation")
public class Invitation {
    
    public static final int STATUS_SENT = 1;
    public static final int STATUS_VIEWED = 2;
    public static final int STATUS_DECLINED = 3;
    public static final int STATUS_ACCEPTED = 4;
    public static final int STATUS_FINESHED = 5;
    public static final int STATUS_WITHDRAWN = 6;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_EMPLOYER_ID")
    private Employer employer;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_CANDIDATE_ID")
    private Candidate candidate;
    
    @Column(name="STATUS")
    private int status;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="SENDDATE")
    private Calendar sendDate;

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
     * @return the employer
     */
    public Employer getEmployer() {
        return employer;
    }

    /**
     * @param employer the employer to set
     */
    public void setEmployer(Employer employer) {
        this.employer = employer;
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
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the sendDate
     */
    public Calendar getSendDate() {
        return sendDate;
    }

    /**
     * @param sendDate the sendDate to set
     */
    public void setSendDate(Calendar sendDate) {
        this.sendDate = sendDate;
    }
    
    /**
     * Get the send date in a user-friendly string.
     * @return The date string.
     */
    public String getFriendlySendDate() {
        return StringUtil.getFriendlyDate(sendDate);
    }
    
}
