package com.iceroom.fundamental.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.iceroom.fundamental.dao.IPostDao;
import com.iceroom.fundamental.entity.Post;
import com.iceroom.fundamental.service.IGeneralService;

/**
 * @author Lincoln
 *
 */
public class GeneralService implements IGeneralService {
    
    private final long POST_ID_ABOUT = 2L;// The id of "About" post.
    
    private IPostDao postDao;

    @Override
    @Transactional(readOnly=true)
    public Post getPostAbout() {
        return postDao.getEntityById(POST_ID_ABOUT);
    }

    /**
     * @param postDao the postDao to set
     */
    public void setPostDao(IPostDao postDao) {
        this.postDao = postDao;
    }
    
}
