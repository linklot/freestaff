/**
 * 
 */
package com.iceroom.fundamental.viewmodel;

import java.util.List;

/**
 * @author Lincoln
 *
 */
public class CategoryViewModel {
    
    private long id;
    private String name;
    private List<CategoryViewModel> children;
    private int order;

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
     * @return the children
     */
    public List<CategoryViewModel> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<CategoryViewModel> children) {
        this.children = children;
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }
    
}
