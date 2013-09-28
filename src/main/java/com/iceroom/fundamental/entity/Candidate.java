package com.iceroom.fundamental.entity;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.iceroom.fundamental.util.StringUtil;

/**
 * Candidate entity.
 * @author Lincoln
 *
 */
@Entity
@Table(name="candidate")
public class Candidate {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @Column(name="PICURL")
    private String picUrl;
    
    @Column(name="FIRSTNAME")
    private String firstName;
    
    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;
    
    @OneToOne(cascade=CascadeType.DETACH, fetch=FetchType.LAZY)
    @JoinColumn(name="FK_USER_ID")
    private User user;
    
    @Column(name="MOBILENO")
    private String mobileNo;
    
    @Column(name="PHONENO")
    private String phoneNo;
    
    @Column(name="CVURL")
    private String cvUrl;
    
    @Column(name="BIRTHCOUNTRY")
    private String birthCountry;
    
    @Column(name="CURRCITY")
    private String currCity;
    
    @Column(name="CURRCOUNTRY")
    private String currCountry;
    
    @Column(name="CURRVISASTATUS")
    private String currVisaStatus;
    
    @Column(name="LISTENING")
    private String listening;
    
    @Column(name="READING")
    private String reading;
    
    @Column(name="WRITING")
    private String writing;
    
    @Column(name="SPEAKING")
    private String speaking;
    
    @Column(name="OVERALL")
    private String overall;
    
    @Column(name="TESTDATE")
    private String testDate;
    
    @Column(name="TESTREFNO")
    private String testRefNo;
    
    @Column(name="CLASSIF")
    private String classif;
    
    @Column(name="SUBCLASSIF")
    private String subClassif;
    
    @Column(name="HIGHESTQUALIF")
    private String highestQualif;
    
    @Column(name="QUALIFNAME")
    private String qualifName;
    
    @Column(name="SKILLASSESS")
    @Type(type="yes_no")
    private boolean skillAssess;
    
    @Column(name="ASSESSAUTH")
    private String assessAuth;
    
    @Column(name="ASSESSDATE")
    private String assessDate;
    
    @Column(name="ASSESSREFNO")
    private String assessRefNo;
    
    @Column(name="CANPAYAIRFARE")
    @Type(type="yes_no")
    private boolean canPayAirfare;
    
    @Column(name="CANPAYVISACOST")
    @Type(type="yes_no")
    private boolean canPayVisaCost;
    
    @Column(name="KEYSKILL1")
    private String keySkill1;
    
    @Column(name="KEYSKILL2")
    private String keySkill2;
    
    @Column(name="KEYSKILL3")
    private String keySkill3;
    
    @Column(name="KEYSKILL4")
    private String keySkill4;
    
    @Column(name="KEYSKILL5")
    private String keySkill5;
    
    @Column(name="PITCH")
    private String pitch;
    
    @Column(name="INTERESTS")
    private String interests;
    
    @Column(name="VIDEOURL")
    private String videoUrl;
    
    @OneToMany(mappedBy="candidate")
    @OrderBy("id")
    private Set<EmpHistory> empHistories;
    
    @OneToMany(mappedBy="candidate")
    @OrderBy("id")
    private Set<EduHistory> eduHistories;
    
    @OneToMany(mappedBy="candidate")
    @OrderBy("id")
    private Set<Invitation> invitations;
    
    @Column(name="VIEWCOUNT")
    private int viewCount;
    
    @Column(name="MEMBERSHIPFROM")
    private Calendar membershipFrom;
    
    @Column(name="MEMBERSHIPTO")
    private Calendar membershipTo;
    
    @OneToMany(mappedBy="candidate")
    @OrderBy("id")
    private Set<PaymentHistory> paymentHistories;

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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the cvUrl
     */
    public String getCvUrl() {
        return cvUrl;
    }

    /**
     * @param cvUrl the cvUrl to set
     */
    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    /**
     * @return the birthCountry
     */
    public String getBirthCountry() {
        return birthCountry;
    }

    /**
     * @param birthCountry the birthCountry to set
     */
    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    /**
     * @return the currCity
     */
    public String getCurrCity() {
        return currCity;
    }

    /**
     * @param currCity the currCity to set
     */
    public void setCurrCity(String currCity) {
        this.currCity = currCity;
    }

    /**
     * @return the currCountry
     */
    public String getCurrCountry() {
        return currCountry;
    }

    /**
     * @param currCountry the currCountry to set
     */
    public void setCurrCountry(String currCountry) {
        this.currCountry = currCountry;
    }

    /**
     * @return the currVisaStatus
     */
    public String getCurrVisaStatus() {
        return currVisaStatus;
    }

    /**
     * @param currVisaStatus the currVisaStatus to set
     */
    public void setCurrVisaStatus(String currVisaStatus) {
        this.currVisaStatus = currVisaStatus;
    }

    /**
     * @return the listening
     */
    public String getListening() {
        return listening;
    }

    /**
     * @param listening the listening to set
     */
    public void setListening(String listening) {
        this.listening = listening;
    }

    /**
     * @return the reading
     */
    public String getReading() {
        return reading;
    }

    /**
     * @param reading the reading to set
     */
    public void setReading(String reading) {
        this.reading = reading;
    }

    /**
     * @return the writing
     */
    public String getWriting() {
        return writing;
    }

    /**
     * @param writing the writing to set
     */
    public void setWriting(String writing) {
        this.writing = writing;
    }

    /**
     * @return the speaking
     */
    public String getSpeaking() {
        return speaking;
    }

    /**
     * @param speaking the speaking to set
     */
    public void setSpeaking(String speaking) {
        this.speaking = speaking;
    }

    /**
     * @return the overall
     */
    public String getOverall() {
        return overall;
    }

    /**
     * @param overall the overall to set
     */
    public void setOverall(String overall) {
        this.overall = overall;
    }

    /**
     * @return the testDate
     */
    public String getTestDate() {
        return testDate;
    }

    /**
     * @param testDate the testDate to set
     */
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    /**
     * @return the testRefNo
     */
    public String getTestRefNo() {
        return testRefNo;
    }

    /**
     * @param testRefNo the testRefNo to set
     */
    public void setTestRefNo(String testRefNo) {
        this.testRefNo = testRefNo;
    }

    /**
     * @return the classif
     */
    public String getClassif() {
        return classif;
    }

    /**
     * @param classif the classif to set
     */
    public void setClassif(String classif) {
        this.classif = classif;
    }

    /**
     * @return the subClassif
     */
    public String getSubClassif() {
        return subClassif;
    }

    /**
     * @param subClassif the subClassif to set
     */
    public void setSubClassif(String subClassif) {
        this.subClassif = subClassif;
    }

    /**
     * @return the highestQualif
     */
    public String getHighestQualif() {
        return highestQualif;
    }

    /**
     * @param highestQualif the highestQualif to set
     */
    public void setHighestQualif(String highestQualif) {
        this.highestQualif = highestQualif;
    }

    /**
     * @return the qualifName
     */
    public String getQualifName() {
        return qualifName;
    }

    /**
     * @param qualifName the qualifName to set
     */
    public void setQualifName(String qualifName) {
        this.qualifName = qualifName;
    }

    /**
     * @return the skillAssess
     */
    public boolean isSkillAssess() {
        return skillAssess;
    }

    /**
     * @param skillAssess the skillAssess to set
     */
    public void setSkillAssess(boolean skillAssess) {
        this.skillAssess = skillAssess;
    }

    /**
     * @return the assessAuth
     */
    public String getAssessAuth() {
        return assessAuth;
    }

    /**
     * @param assessAuth the assessAuth to set
     */
    public void setAssessAuth(String assessAuth) {
        this.assessAuth = assessAuth;
    }

    /**
     * @return the assessDate
     */
    public String getAssessDate() {
        return assessDate;
    }

    /**
     * @param assessDate the assessDate to set
     */
    public void setAssessDate(String assessDate) {
        this.assessDate = assessDate;
    }

    /**
     * @return the assessRefNo
     */
    public String getAssessRefNo() {
        return assessRefNo;
    }

    /**
     * @param assessRefNo the assessRefNo to set
     */
    public void setAssessRefNo(String assessRefNo) {
        this.assessRefNo = assessRefNo;
    }

    /**
     * @return the canPayAirfare
     */
    public boolean isCanPayAirfare() {
        return canPayAirfare;
    }

    /**
     * @param canPayAirfare the canPayAirfare to set
     */
    public void setCanPayAirfare(boolean canPayAirfare) {
        this.canPayAirfare = canPayAirfare;
    }

    /**
     * @return the canPayVisaCost
     */
    public boolean isCanPayVisaCost() {
        return canPayVisaCost;
    }

    /**
     * @param canPayVisaCost the canPayVisaCost to set
     */
    public void setCanPayVisaCost(boolean canPayVisaCost) {
        this.canPayVisaCost = canPayVisaCost;
    }

    /**
     * @return the keySkill1
     */
    public String getKeySkill1() {
        return keySkill1;
    }

    /**
     * @param keySkill1 the keySkill1 to set
     */
    public void setKeySkill1(String keySkill1) {
        this.keySkill1 = keySkill1;
    }

    /**
     * @return the keySkill2
     */
    public String getKeySkill2() {
        return keySkill2;
    }

    /**
     * @param keySkill2 the keySkill2 to set
     */
    public void setKeySkill2(String keySkill2) {
        this.keySkill2 = keySkill2;
    }

    /**
     * @return the keySkill3
     */
    public String getKeySkill3() {
        return keySkill3;
    }

    /**
     * @param keySkill3 the keySkill3 to set
     */
    public void setKeySkill3(String keySkill3) {
        this.keySkill3 = keySkill3;
    }

    /**
     * @return the keySkill4
     */
    public String getKeySkill4() {
        return keySkill4;
    }

    /**
     * @param keySkill4 the keySkill4 to set
     */
    public void setKeySkill4(String keySkill4) {
        this.keySkill4 = keySkill4;
    }

    /**
     * @return the keySkill5
     */
    public String getKeySkill5() {
        return keySkill5;
    }

    /**
     * @param keySkill5 the keySkill5 to set
     */
    public void setKeySkill5(String keySkill5) {
        this.keySkill5 = keySkill5;
    }

    /**
     * @return the pitch
     */
    public String getPitch() {
        return pitch;
    }

    /**
     * @param pitch the pitch to set
     */
    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    /**
     * @return the interests
     */
    public String getInterests() {
        return interests;
    }

    /**
     * @param interests the interests to set
     */
    public void setInterests(String interests) {
        this.interests = interests;
    }

    /**
     * @return the videoUrl
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * @param videoUrl the videoUrl to set
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * @return the empHistories
     */
    public Set<EmpHistory> getEmpHistories() {
        return empHistories;
    }

    /**
     * @param empHistories the empHistories to set
     */
    public void setEmpHistories(Set<EmpHistory> empHistories) {
        this.empHistories = empHistories;
    }

    /**
     * @return the eduHistories
     */
    public Set<EduHistory> getEduHistories() {
        return eduHistories;
    }

    /**
     * @param eduHistories the eduHistories to set
     */
    public void setEduHistories(Set<EduHistory> eduHistories) {
        this.eduHistories = eduHistories;
    }

    /**
     * @return the picUrl
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * @param picUrl the picUrl to set
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * @return the invitations
     */
    public Set<Invitation> getInvitations() {
        return invitations;
    }

    /**
     * @param invitations the invitations to set
     */
    public void setInvitations(Set<Invitation> invitations) {
        this.invitations = invitations;
    }

    /**
     * @return the viewCount
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * @param viewCount the viewCount to set
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * @return the membershipFrom
     */
    public Calendar getMembershipFrom() {
        return membershipFrom;
    }

    /**
     * @param membershipFrom the membershipFrom to set
     */
    public void setMembershipFrom(Calendar membershipFrom) {
        this.membershipFrom = membershipFrom;
    }

    /**
     * @return the membershipTo
     */
    public Calendar getMembershipTo() {
        return membershipTo;
    }

    /**
     * @param membershipTo the membershipTo to set
     */
    public void setMembershipTo(Calendar membershipTo) {
        this.membershipTo = membershipTo;
    }

    /**
     * @return the paymentHistories
     */
    public Set<PaymentHistory> getPaymentHistories() {
        return paymentHistories;
    }

    /**
     * @param paymentHistories the paymentHistories to set
     */
    public void setPaymentHistories(Set<PaymentHistory> paymentHistories) {
        this.paymentHistories = paymentHistories;
    }
    
    /**
     * Get the candidate's membership status.
     * Including "Inactive, Active, Suspended"
     * @return
     */
    public String getMembershipStatus() {
        if(this.membershipFrom == null) return "Inactive";
        else {
            Calendar now = Calendar.getInstance();
            if(membershipTo.getTimeInMillis() >= now.getTimeInMillis()) return "Active";
            else return "Suspended";
        }
    }
    
    public String getFriendlyMembershipFrom() {
        if(this.membershipFrom != null) {
            return StringUtil.getFriendlyDate(this.membershipFrom);
        } else return "";
    }
    
    public String getFriendlyMembershipTo() {
        if(this.membershipTo != null) {
            return StringUtil.getFriendlyDate(this.membershipTo);
        } else return "";
    }

}
