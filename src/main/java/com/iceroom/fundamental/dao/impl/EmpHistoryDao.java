package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IEmpHistoryDao;
import com.iceroom.fundamental.entity.EmpHistory;

/**
 * @author Lincoln
 *
 */
public class EmpHistoryDao extends AbstractDao<EmpHistory, Long> implements
        IEmpHistoryDao {

    protected EmpHistoryDao() {
        super(EmpHistory.class);
    }

}
