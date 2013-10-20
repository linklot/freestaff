package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IEmployerApplicationDao;
import com.iceroom.fundamental.entity.EmployerApplication;

/**
 * @author Lincoln
 *
 */
public class EmployerApplicationDao extends
        AbstractDao<EmployerApplication, Long> implements
        IEmployerApplicationDao {

    protected EmployerApplicationDao() {
        super(EmployerApplication.class);
    }
    
}
