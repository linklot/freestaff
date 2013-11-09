package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IMembershipPromptDao;
import com.iceroom.fundamental.entity.MembershipPrompt;

/**
 * @author Lincoln
 *
 */
public class MembershipPromptDao extends AbstractDao<MembershipPrompt, Long>
        implements IMembershipPromptDao {

    protected MembershipPromptDao() {
        super(MembershipPrompt.class);
    }
    
}
