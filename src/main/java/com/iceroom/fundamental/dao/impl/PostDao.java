package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IPostDao;
import com.iceroom.fundamental.entity.Post;

/**
 * @author Lincoln
 *
 */
public class PostDao extends AbstractDao<Post, Long> implements IPostDao {

    protected PostDao() {
        super(Post.class);
    }
    
}
