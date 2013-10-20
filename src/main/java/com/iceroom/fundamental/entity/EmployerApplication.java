package com.iceroom.fundamental.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iceroom.fundamental.util.StringUtil;

/**
 * @author Lincoln
 *
 */
@Entity
@Table(name="employerapplication")
public class EmployerApplication {
    
    public static final int STATUS_INQUEUE = 1;
    public static final int STATUS_ACCEPTED = 2;
    public static final int STATUS_REJECTED = 3;// Status of an application.
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "PHONE")   
    private String phone;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name="NUMBER")
    private String number;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "STATE")
    private String state;
    
    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "POSTCODE")
    private String postcode;
    
    @Column(name = "STATEMENT")
    private String statement;
    
    @Column(name = "STATUS")
    private int status;
    
    @Column(name = "APPLYTIME")
    private Calendar applyTime;

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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
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
     * @return the applyTime
     */
    public Calendar getApplyTime() {
        return applyTime;
    }

    /**
     * @param applyTime the applyTime to set
     */
    public void setApplyTime(Calendar applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getFriendlyApplyTime() {
        return StringUtil.getFriendlyDate(this.applyTime);
    }
    
}
