/**
 * 
 */
package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IInvitationDao;
import com.iceroom.fundamental.entity.Invitation;

/**
 * @author Lincoln
 *
 */
public class InvitationDao extends AbstractDao<Invitation, Long> implements
        IInvitationDao {
    
    protected InvitationDao() {
        super(Invitation.class);
    }
    
}
