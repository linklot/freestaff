package com.iceroom.fundamental.dao.impl;

import com.iceroom.fundamental.dao.IClassifDao;
import com.iceroom.fundamental.entity.Classif;

/**
 * @author Lincoln
 *
 */
public class ClassifDao extends AbstractDao<Classif, Long> implements
        IClassifDao {

    protected ClassifDao() {
        super(Classif.class);
    }

}
