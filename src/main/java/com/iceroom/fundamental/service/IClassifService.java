package com.iceroom.fundamental.service;

import java.util.List;

import com.iceroom.fundamental.entity.Classif;

/**
 * The Classification service object.
 * @author Lincoln
 *
 */
public interface IClassifService {
    
    /**
     * Get all non-sub-classifications.
     * @return {@link List}&lt;{@link Classif}&gt;
     */
    List<Classif> getAllClassifs();
    
    /**
     * Get all sub-classifications of a parent.
     * @param id The id of the parent classification.
     * @return {@link List}&lt;{@link Classif}&gt;
     */
    List<Classif> getSubClassifs(long id);

}
