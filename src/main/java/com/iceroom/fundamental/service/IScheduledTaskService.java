/**
 * 
 */
package com.iceroom.fundamental.service;

/**
 * @author Lincoln
 *
 */
public interface IScheduledTaskService {
    
    /**
     * Automatically check candidates' membership status <br/>
     * and send emails to those whose membershipis not activated.
     */
    void membershipCheckTask();
    
}
