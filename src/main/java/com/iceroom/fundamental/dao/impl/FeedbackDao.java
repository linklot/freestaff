package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IFeedbackDao;
import com.iceroom.fundamental.entity.Feedback;

/**
 * @author Lincoln
 *
 */
public class FeedbackDao extends AbstractDao<Feedback, Long> implements
        IFeedbackDao {

    protected FeedbackDao() {
        super(Feedback.class);
    }
    
}
