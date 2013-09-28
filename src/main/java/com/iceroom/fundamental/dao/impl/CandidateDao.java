/**
 * 
 */
package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.ICandidateDao;
import com.iceroom.fundamental.entity.Candidate;

/**
 * @author Lincoln
 *
 */
public class CandidateDao extends AbstractDao<Candidate, Long> implements
        ICandidateDao {

    protected CandidateDao() {
        super(Candidate.class);
    }

}
