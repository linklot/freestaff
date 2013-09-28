package com.iceroom.fundamental.entity;

import java.util.Set;

import javax.persistence.*;

/**
 * Employer entity.
 * @author Lincoln
 *
 */
@Entity
@Table(name="employer")
public class Employer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @OneToOne(cascade=CascadeType.DETACH, fetch=FetchType.LAZY)
    @JoinColumn(name="FK_USER_ID")
    private User user;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="PHONE")
    private String phone;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="ADDR_STREET")
    private String addrStreet;
    
    @Column(name="ADDR_CITY")
    private String addrCity;
    
    @Column(name="ADDR_STATE")
    private String addrState;
    
    @Column(name="ADDR_COUNTRY")
    private String addrCountry;
    
    @Column(name="ZIP")
    private String zip;
    
    @Column(name="STATEMENT")
    private String statement;
    
    @OneToMany(mappedBy="employer")
    @OrderBy("id")
    private Set<Invitation> invitations;

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

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * @return the addrStreet
     */
    public String getAddrStreet() {
        return addrStreet;
    }

    /**
     * @param addrStreet the addrStreet to set
     */
    public void setAddrStreet(String addrStreet) {
        this.addrStreet = addrStreet;
    }

    /**
     * @return the addrCity
     */
    public String getAddrCity() {
        return addrCity;
    }

    /**
     * @param addrCity the addrCity to set
     */
    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    /**
     * @return the addrState
     */
    public String getAddrState() {
        return addrState;
    }

    /**
     * @param addrState the addrState to set
     */
    public void setAddrState(String addrState) {
        this.addrState = addrState;
    }

    /**
     * @return the addrCountry
     */
    public String getAddrCountry() {
        return addrCountry;
    }

    /**
     * @param addrCountry the addrCountry to set
     */
    public void setAddrCountry(String addrCountry) {
        this.addrCountry = addrCountry;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the statement
     */
    public String getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(String statement) {
        this.statement = statement;
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

}
