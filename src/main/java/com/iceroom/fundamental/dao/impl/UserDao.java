/**
 * 
 */
package com.iceroom.fundamental.dao.impl;

import java.util.List;

import com.iceroom.fundamental.dao.IUserDao;
import com.iceroom.fundamental.entity.User;

/**
 * @author Lincoln
 *
 */
public class UserDao extends AbstractDao<User, Long> implements IUserDao {

    protected UserDao() {
        super(User.class);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.dao.IUserDao#getUserByAccount(java.lang.String)
     */
    @Override
    public User getUserByAccount(String account) {
        String hql = "from User u where u.account=?1";
        List<User> users = findByHql(hql, account);
        if((users == null) || (users.size() == 0)) return null;
        return users.get(0);
    }

}
