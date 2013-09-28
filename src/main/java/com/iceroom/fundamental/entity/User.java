package com.iceroom.fundamental.entity;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Type;

import com.iceroom.fundamental.util.StringUtil;

/**
 * @author Lincoln
 *
 */
@Entity
@Table(name="user")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private long id;
    
    @Column(name = "ACCOUNT")
    private String account;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name="ENABLED")
    @Type(type="yes_no")
    private boolean enabled;
    
    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.DETACH)
    @JoinTable(name="user_role",
        joinColumns={@JoinColumn(name="FK_USER_ID")},
        inverseJoinColumns={@JoinColumn(name="FK_ROLE_ID")})
    private Set<Role> roles;
    
    @OneToOne(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
    @JoinColumn(name="FK_USER_ID")
    @LazyToOne(value=LazyToOneOption.NO_PROXY)
    private Candidate candidate;
    
    @OneToOne(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
    @JoinColumn(name="FK_USER_ID")
    @LazyToOne(value=LazyToOneOption.NO_PROXY)
    private Employer employer;
    
    @Column(name="REGDATE")
    private Calendar regDate;

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
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
     * @return the regDate
     */
    public Calendar getRegDate() {
        return regDate;
    }

    /**
     * @param regDate the regDate to set
     */
    public void setRegDate(Calendar regDate) {
        this.regDate = regDate;
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
    
    public String getFriendlyRegDate() {
        return StringUtil.getFriendlyDate(this.regDate);
    }
    
}
