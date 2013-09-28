/**
 * 
 */
package com.iceroom.fundamental.dao;

import com.iceroom.fundamental.entity.User;

/**
 * @author Lincoln
 *
 */
public interface IUserDao extends IDao<User, Long> {
    
    /**
     * Get a User object by its account attribute.
     * @param account
     * @return If account exists return {@link com.iceroom.fundamental.entity.User},
     *          else return null.
     */
    User getUserByAccount(String account);

}
