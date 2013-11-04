package com.iceroom.fundamental.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iceroom.fundamental.dao.IDao;
import com.iceroom.fundamental.entity.PaginationWrapper;

/**
 * Implementation of IDao
 * @author Lincoln
 *
 */
public abstract class AbstractDao<T, ID extends Serializable> implements IDao<T, ID> {
    
    private SessionFactory sessionFactory;
    private Class<T> entityClass;
    
    /**
     * The constructor
     * @param entityClass The entity class this DAO handles.
     */
    protected AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getEntityById(ID id) {
        return (T) getCurrentSession().get(entityClass, id);
    }

    @Override
    public Serializable create(T entity) {
        Serializable id = null;
        try {
            id = getCurrentSession().save(entity);
        } catch(Exception e) {
            id = -1;
        }
        return id;
    }

    @Override
    public boolean update(T entity) {
        boolean result = false;
        try {
            getCurrentSession().merge(entity);
            result = true;
        } catch(Exception ex) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(T entity) {
        boolean result = false;
        try {
            getCurrentSession().delete(entity);
            result = true;
        } catch(Exception ex) {
            result = false;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByHql(String hql, Object... objects) {
        try {
            return createQuery(hql, objects).list();
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T findSingleByHql(String hql, Object... params) {
        List<T> results = createQuery(hql, params).list();
        if(results == null || results.size() == 0) return null;
        else return results.get(0);
    }

    @Override
    public void executeHql(String hql, Object... objects) {
        createQuery(hql, objects).list();
    }
    
    /**
     * Get a Session instance from the SessionFactory object
     * @return org.hibernate.Session
     */
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    protected Query createQuery(String hql, Object... values) {
        Query query = getCurrentSession().createQuery(hql);
        if(null != values) {
            int position = 1;
            for(int i=0; i<values.length; i++) {
                query.setParameter(String.valueOf(position++), values[i]);
            }
        }
        return query;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.dao.IDao#paginatedFind(int, int, java.lang.String, boolean, java.lang.Object[])
     */
    @SuppressWarnings("rawtypes")
    @Override
    public PaginationWrapper paginatedFind(int startIndex, int pageSize,
            String hql, boolean isDesc, Object... params) {
        int totalCount = 0;
        
        // Step 1, get the total number of this query.
        // current hql should be like "from Xx xx where xx.xx=?1 order by xx.xx"
        String chql = "select count(*)" + hql.substring(0, hql.indexOf(" order by"));
        Query cQuery = createQuery(chql, params);
        List _list = cQuery.list();
        if(_list != null && _list.size() > 0) {
            totalCount = ((Long) _list.get(0)).intValue();
        }
        
        // Step 2, get the paginated result
        if(isDesc) hql = hql + " desc";
        Query query = createQuery(hql, params);
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
        _list = query.list();
        if(_list == null) _list = new ArrayList();
        PaginationWrapper wrapper = new PaginationWrapper(_list, totalCount, pageSize, startIndex);
        
        return wrapper;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.dao.IDao#findByPreparedStatement(java.lang.String, java.util.Map)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByPreparedStatement(String hql, Map<String, String> paras) {
        Query query = getCurrentSession().createQuery(hql);
        Set<String> keySet = paras.keySet();
        String value = null;
        for(String key : keySet) {
            value = paras.get(key);
            query.setString(key, value);
        }
        return query.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
