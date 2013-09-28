/**
 * 
 */
package com.iceroom.fundamental.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.iceroom.fundamental.entity.PaginationWrapper;

/**
 * DAO Interface
 * @author Lincoln
 *
 */
public interface IDao<T, ID extends Serializable> {
    
    /**
     * Get an entity instance by its id.
     * @param id The unique identity.
     * @return <strong>T</strong> The entity instance
     */
    public T getEntityById(ID id);
    
    /**
     * Create a new entity instance.
     * @param The entity instance
     * @return The unique id of the new instance.<br/>
     *          -1 when creation fails.
     */
    Serializable create(T entity);
    
    /**
     * Update an entity instance.
     * @param entity The instance
     * @return <strong>true</strong> when successes,
     *          <strong>false</strong> when fails
     */
    boolean update(T entity);
    
    /**
     * Delete an entity instance.
     * @param entity The instance
     * @return <strong>true</strong> when successes,
     *          <strong>false</strong> when fails
     */
    boolean delete(T entity);
    
    /**
     * Returns an entity list according to the given HQL statement.
     * @param hql The HQL statement.
     * @param params The parameters of the statement. Can be 0 or more.
     * @return java.util.List&lt;T&gt;
     */
    List<T> findByHql(String hql, Object... params);

    /**
     * No matter how many results the HQL finds, just return the first one.
     * @param hql The HQL.
     * @param params Parameters
     * @return The first query result.
     */
    T findSingleByHql(String hql, Object... params);
    
    /**
     * Execute a HQL statement. DO NOT use it unless there is no other way!
     * @param hql The HQL statement.
     * @param objects The parameters of the statement. Can be 0 or more.
     */
    void executeHql(String hql, Object... objects);
    
    /**
     * Execute a HQL on the database and get a paginated result.
     * @param startIndex
     * @param pageSize
     * @param hql The HQL statement.
     * @param isDesc The order param, true = descend
     * @param params Optional parameters.
     * @return PaginationWrapper {@link com.iceroom.fundamental.entity.PaginationWrapper}
     */
    PaginationWrapper paginatedFind(int startIndex, int pageSize,
                                    String hql, boolean isDesc, Object... params);
    
    /**
     * Execute a prepared-statement HQL statement.
     * @param hql The HQL statement.
     * @param paras The parameters as a Map. keys are parameter names, values are paramter values.
     * @return List&lt;T&gt;
     */
    List<T> findByPreparedStatement(String hql, Map<String, String> paras);

}
