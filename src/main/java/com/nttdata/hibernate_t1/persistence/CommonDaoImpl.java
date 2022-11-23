package com.nttdata.hibernate_t1.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * 
 * Common DAO
 * 
 * @author Fernando Pérez Nieto
 *
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Class type */
	private Class<T> entityClass;

	/** Session */
	private Session session;

	/**
	 * Constructor
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {

		// Verify if session is active
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insert
		session.save(paramT);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void update(final T paramT) {

		// Verify if session is active
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insert
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void delete(final T paramT) {

		// Verify if session is active
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insert
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public T searchById(final Long id) {

		// Verify if session is active
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Search by id
		return session.get(this.entityClass, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Verify if session is active
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Search all regs
		return session.createQuery("FROM " + this.entityClass.getName()).list();

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}