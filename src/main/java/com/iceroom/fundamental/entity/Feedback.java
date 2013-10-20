package com.iceroom.fundamental.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.iceroom.fundamental.util.StringUtil;

/**
 * @author Lincoln
 *
 */
@Entity
@Table(name="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private long id;
    
    @Column(name = "CONTENT")
    private String content;
    
    @Column(name = "TIME")
    private Calendar time;
    
    @ManyToOne
    @JoinColumn(name="FK_USER_ID")
    private User user;

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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the time
     */
    public Calendar getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Calendar time) {
        this.time = time;
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
    
    public String getFriendlyTime() {
        return StringUtil.getFriendlyDate(this.time);
    }
    
}
