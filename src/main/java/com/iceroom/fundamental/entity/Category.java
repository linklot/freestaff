package com.iceroom.fundamental.entity;

import java.util.Set;

import javax.persistence.*;

/**
 * Category entity.
 * @author Lincoln
 *
 */
@Entity
@Table(name="category")
public class Category {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @Column(name="NAME")
    private String name;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_PARENT_ID")
    private Category parent;
    
    @OneToMany(mappedBy="parent")
    @OrderBy("sequence, name")
    private Set<Category> children;
    
    @Column(name="SEQUENCE")
    private int sequence;
    
    @OneToMany(mappedBy="category")
    @OrderBy("sequence, id DESC")
    private Set<Post> posts;

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
     * @return the parent
     */
    public Category getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Category parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    public Set<Category> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Set<Category> children) {
        this.children = children;
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
     * @return the posts
     */
    public Set<Post> getPosts() {
        return posts;
    }

    /**
     * @param posts the posts to set
     */
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
    
}
