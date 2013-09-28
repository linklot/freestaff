/**
 * 
 */
package com.iceroom.fundamental.entity;

import javax.persistence.*;

/**
 * Education history entity.
 * @author Lincoln
 *
 */
@Entity
@Table(name="eduhistory")
public class EduHistory {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @Column(name="QUALIFTYPE")
    private String qualifType;
    
    @Column(name="UNI")
    private String uni;
    
    @Column(name="LOC")
    private String loc;
    
    @Column(name="COMPLDATE")
    private String complDate;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_CANDIDATE_ID")
    private Candidate candidate;

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
     * @return the qualifType
     */
    public String getQualifType() {
        return qualifType;
    }

    /**
     * @param qualifType the qualifType to set
     */
    public void setQualifType(String qualifType) {
        this.qualifType = qualifType;
    }

    /**
     * @return the uni
     */
    public String getUni() {
        return uni;
    }

    /**
     * @param uni the uni to set
     */
    public void setUni(String uni) {
        this.uni = uni;
    }

    /**
     * @return the loc
     */
    public String getLoc() {
        return loc;
    }

    /**
     * @param loc the loc to set
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }

    /**
     * @return the complDate
     */
    public String getComplDate() {
        return complDate;
    }

    /**
     * @param complDate the complDate to set
     */
    public void setComplDate(String complDate) {
        this.complDate = complDate;
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

}
