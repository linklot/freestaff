package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IPaymentHistoryDao;
import com.iceroom.fundamental.entity.PaymentHistory;

/**
 * @author Lincoln
 *
 */
public class PaymentHistoryDao extends AbstractDao<PaymentHistory, Long>
        implements IPaymentHistoryDao {

    protected PaymentHistoryDao() {
        super(PaymentHistory.class);
    }
    
}
