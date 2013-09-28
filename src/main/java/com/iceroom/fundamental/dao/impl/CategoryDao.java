package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.ICategoryDao;
import com.iceroom.fundamental.entity.Category;

/**
 * @author Lincoln
 *
 */
public class CategoryDao extends AbstractDao<Category, Long> implements
        ICategoryDao {

    protected CategoryDao() {
        super(Category.class);
    }
    
}
