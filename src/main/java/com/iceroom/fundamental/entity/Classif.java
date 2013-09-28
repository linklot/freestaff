package com.iceroom.fundamental.entity;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 * Classification entity.
 * @author Lincoln
 *
 */
@Entity
@Table(name="classif")
public class Classif {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="SUB")
    @Type(type="yes_no")
    private boolean sub;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PARENT_ID")
    private Classif parent;
    
    @OneToMany(mappedBy="parent", fetch=FetchType.LAZY)
    @OrderBy("name")
    private Set<Classif> children;

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
     * @return the isSub
     */
    public boolean isSub() {
        return sub;
    }

    /**
     * @param isSub the isSub to set
     */
    public void setSub(boolean isSub) {
        this.sub = isSub;
    }

    /**
     * @return the parent
     */
    public Classif getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Classif parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    public Set<Classif> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Set<Classif> children) {
        this.children = children;
    }

}
