package com.iceroom.fundamental.service;

import com.iceroom.fundamental.entity.Post;

/**
 * @author Lincoln
 *
 */
public interface IGeneralService {
    
    /**
     * Get the particular post "About"
     * @return {@link Post}
     */
    Post getPostAbout();
    
    /**
     * Get the particular post "Membership"
     * @return {@link Post}
     */
    Post getPostMembership();
    
    /**
     * Get the particular post "Visa Advice"
     * @return {@link Post}
     */
    Post getPostVisaAdvice();
    
    /**
     * Get the particular post "Farm Work"
     * @return {@link Post}
     */
    Post getPostFarmWork();
    
}
