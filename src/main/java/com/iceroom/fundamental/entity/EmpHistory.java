/**
 * 
 */
package com.iceroom.fundamental.entity;

import javax.persistence.*;

/**
 * Employment history entity.
 * @author Lincoln
 *
 */
@Entity
@Table(name="emphistory")
public class EmpHistory {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="SEQ")
    private int seq;
    
    @Column(name="LOC")
    private String loc;
    
    @Column(name="E_FROM")
    private String from;
    
    @Column(name="E_TO")
    private String to;
    
    @Column(name="JOBTITLE")
    private String jobTitle;
    
    @Column(name="DUTY")
    private String duty;
    
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
     * @return the seq
     */
    public int getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(int seq) {
        this.seq = seq;
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
     * @return the empFrom
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param empFrom the empFrom to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the empTo
     */
    public String getTo() {
        return to;
    }

    /**
     * @param empTo the empTo to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return the duty
     */
    public String getDuty() {
        return duty;
    }

    /**
     * @param duty the duty to set
     */
    public void setDuty(String duty) {
        this.duty = duty;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
