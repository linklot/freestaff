package com.iceroom.fundamental.entity;

import java.util.Calendar;

import javax.persistence.*;

import com.iceroom.fundamental.util.StringUtil;

/**
 * Payment History entity
 * @author Lincoln
 *
 */
@Entity
@Table(name="paymenthistory")
public class PaymentHistory {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_CANDIDATE_ID")
    private Candidate candidate;
    
    @Column(name="DATE")
    private Calendar date;
    
    @Column(name="AMOUNT")
    private String amount;
    
    @Column(name="DESCRIPTION")
    private String description;

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
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
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
    
    public String getFriendlyDate() {
        return StringUtil.getFriendlyDate(this.date);
    }
    
}
