package com.iceroom.fundamental.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.iceroom.fundamental.dao.IPostDao;
import com.iceroom.fundamental.entity.Post;
import com.iceroom.fundamental.service.IGeneralService;

/**
 * @author Lincoln
 *
 */
@Transactional(readOnly=true)
public class GeneralService implements IGeneralService {
    
    private final long POST_ID_ABOUT = 2L;// The id of "About" post.
    private final long POST_ID_MEMBERSHIP = 3L;
    private final long POST_ID_VISAADVICE = 4L;
    private final long POST_ID_FARMWORK = 5L;
    
    private IPostDao postDao;

    @Override
    public Post getPostAbout() {
        return postDao.getEntityById(POST_ID_ABOUT);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IGeneralService#getPostMembership()
     */
    @Override
    public Post getPostMembership() {
        return postDao.getEntityById(POST_ID_MEMBERSHIP);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IGeneralService#getPostVisaAdvice()
     */
    @Override
    public Post getPostVisaAdvice() {
        return postDao.getEntityById(POST_ID_VISAADVICE);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IGeneralService#getPostFarmWork()
     */
    @Override
    public Post getPostFarmWork() {
        return postDao.getEntityById(POST_ID_FARMWORK);
    }

    /**
     * @param postDao the postDao to set
     */
    public void setPostDao(IPostDao postDao) {
        this.postDao = postDao;
    }
    
}
