/**
 * 
 */
package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IEduHistoryDao;
import com.iceroom.fundamental.entity.EduHistory;

/**
 * @author Lincoln
 *
 */
public class EduHistoryDao extends AbstractDao<EduHistory, Long> implements
        IEduHistoryDao {

    protected EduHistoryDao() {
        super(EduHistory.class);
    }

}
