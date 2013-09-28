/**
 * 
 */
package com.iceroom.fundamental.entity;

import java.util.Set;

import javax.persistence.*;

/**
 * @author Lincoln
 *
 */
@Entity
@Table(name="role")
public class Role {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_ID")
    private long id;
    
    @Column(name="NAME")
    private String name;
    
    @ManyToMany(mappedBy="roles")
    private Set<User> users;

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
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
