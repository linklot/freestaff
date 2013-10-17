package com.iceroom.fundamental.service;

import com.iceroom.fundamental.entity.User;

/**
 * @author Lincoln
 *
 */
public interface IAccountService {
    
    /**
     * Register a new candidate account.
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @return The new signin account.
     */
    String registerCandidate(String firstName, String lastName,
            String email, String password);
    
    /**
     * Get current signed in user
     * @return User {@link User}
     */
    User getCurrentUser();
    
    /**
     * Get current User object (as a candidate).
     * @return {@link User}
     */
    User getCurrentCandidate();
    
    /**
     * Change a user's password
     * @param userId The User entity's id.
     * @param old_pwd The old password.
     * @param n_pwd The new password.
     * @return <strong>true</strong>: success; <strong>false</strong>: fail.
     */
    boolean changePwd(long userId, String old_pwd, String n_pwd);
    
    /**
     * Register a new employer account.
     * @param user The User entity submitted.
     */
    void registerEmployer(User user);
    
    /**
     * When a user forgot login password.<br/>
     * It first check whether the account and email are valid,
     * then reset the password to a new value. Lastly it sends an email to the user's email address
     * @param account
     * @param email
     * @return true: success; false: fail
     */
    boolean retrievePWD(String account, String email);

}
