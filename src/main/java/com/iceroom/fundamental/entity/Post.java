package com.iceroom.fundamental.entity;

import java.util.Calendar;

import javax.persistence.*;

import com.iceroom.fundamental.util.StringUtil;

/**
 * Post entity
 * @author Lincoln
 *
 */
@Entity
@Table(name="post")
public class Post {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @Column(name="TITLE")
    private String title;
    
    @Column(name="MINIPICURL")
    private String miniPicUrl;

    @Column(name="SUMMARY")
    private String summary;

    @Column(name="SEQUENCE")
    private int sequence;

    @Column(name="PUBTIME")
    private Calendar pubTime;

    @Column(name="HITS")
    private int hits;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_CATEGORY_ID")
    private Category category;

    @Column(name="CONTENT")
    private String content;

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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the miniPicUrl
     */
    public String getMiniPicUrl() {
        return miniPicUrl;
    }

    /**
     * @param miniPicUrl the miniPicUrl to set
     */
    public void setMiniPicUrl(String miniPicUrl) {
        this.miniPicUrl = miniPicUrl;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the sequence
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    /**
     * @return the pubTime
     */
    public Calendar getPubTime() {
        return pubTime;
    }

    /**
     * @param pubTime the pubTime to set
     */
    public void setPubTime(Calendar pubTime) {
        this.pubTime = pubTime;
    }

    /**
     * @return the hits
     */
    public int getHits() {
        return hits;
    }

    /**
     * @param hits the hits to set
     */
    public void setHits(int hits) {
        this.hits = hits;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
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
    
    public String getFriendlyPubTime() {
        return StringUtil.getFriendlyDate(this.getPubTime());
    }
    
}
