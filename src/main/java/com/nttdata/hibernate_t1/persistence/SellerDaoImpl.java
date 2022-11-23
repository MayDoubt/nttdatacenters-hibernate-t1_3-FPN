package com.nttdata.hibernate_t1.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * 
 * Table T_CLIENT DAO Impl
 * 
 * @author Fernando Pérez Nieto
 *
 */
public class SellerDaoImpl extends CommonDaoImpl<Seller> implements SellerDaoI {

	/** Database session */
	private Session session;

	/**
	 * Constructor
	 */
	public SellerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Seller> searchByPhone(String phone) {
		// Query
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Seller> cquery = cb.createQuery(Seller.class);
		final Root<Seller> rootP = cquery.from(Seller.class);

		// Where
		final Predicate pr1 = cb.equal(rootP.<String>get("phone"), phone);

		// Query
		cquery.select(rootP).where(cb.and(pr1));

		// Query execution
		return session.createQuery(cquery).getResultList();
	}

	@Override
	public List<Seller> searchByName(String name) {
		// Query
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Seller> cquery = cb.createQuery(Seller.class);
		final Root<Seller> rootP = cquery.from(Seller.class);

		// Where
		final Predicate pr1 = cb.like(rootP.<String>get("name"), name);

		// Query
		cquery.select(rootP).where(cb.and(pr1));

		// Query execution
		return session.createQuery(cquery).getResultList();
	}
}
