/**
 * 
 */
package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IRoleDao;
import com.iceroom.fundamental.entity.Role;

/**
 * @author Lincoln
 *
 */
public class RoleDao extends AbstractDao<Role, Long> implements IRoleDao {

    protected RoleDao() {
        super(Role.class);
    }

}
