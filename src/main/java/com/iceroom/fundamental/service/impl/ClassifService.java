package com.iceroom.fundamental.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.iceroom.fundamental.dao.IClassifDao;
import com.iceroom.fundamental.entity.Classif;
import com.iceroom.fundamental.service.IClassifService;

/**
 * @author Lincoln
 *
 */
public class ClassifService implements IClassifService {
    
    private IClassifDao classifDao;

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IClassifService#getAllClassifs()
     */
    @Override
    @Transactional(readOnly=true)
    public List<Classif> getAllClassifs() {
        String hql = "from Classif c where c.sub=?1 order by c.name";
        return classifDao.findByHql(hql, false);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IClassifService#getSubClassifs(long)
     */
    @Override
    @Transactional(readOnly=true)
    public List<Classif> getSubClassifs(long id) {
        String hql = "from Classif c where c.parent.id=?1 order by c.name";
        return classifDao.findByHql(hql, id);
    }

    /**
     * @param classifDao the classifDao to set
     */
    public void setClassifDao(IClassifDao classifDao) {
        this.classifDao = classifDao;
    }

}
