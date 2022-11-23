package com.nttdata.hibernate_t1.persistence;

import java.util.List;

/**
 * 
 * Common DAO 
 * 
 * @author Fernando Pérez Nieto
 *
 */
public interface CommonDaoI<T> {

	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);
	
	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);
	
	/**
	 * Localiza un registro por ID en BBDD.
	 * 
	 * @param paramT
	 */
	public T searchById(final Long id);

	/**
	 * Búsqueda de todos los registros en BBDD.
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();

}
