/**
 * 
 */
package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IEmployerDao;
import com.iceroom.fundamental.entity.Employer;

/**
 * @author Lincoln
 *
 */
public class EmployerDao extends AbstractDao<Employer, Long> implements
        IEmployerDao {
    
    protected EmployerDao() {
        super(Employer.class);
    }

}
