package com.iceroom.fundamental.service;

/**
 * @author Lincoln
 *
 */
public interface IPaymentService {
    
    /**
     * Update a candidate's membership.
     * @param userId The id of the User entity.
     * @param itemName The payment item name.
     * @param amount The amount paid.
     */
    void updateCandidateMembership(long userId,
            String itemName, String amount);
    
}
