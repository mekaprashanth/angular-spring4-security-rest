/**
 * 
 */
package com.prash.spring.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Prashanth_Meka
 *
 */
public interface BaseDAO<T, PK extends Serializable> {
	
	public List<T> findAll();
	
	public T save(T t);
	
	public T findByPK(PK pk);

}
