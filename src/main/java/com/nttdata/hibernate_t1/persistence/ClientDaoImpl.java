package com.nttdata.hibernate_t1.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	/** Database session */
	private Session session;

	/**
	 * Constructor
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByName(final String name) {

		// Verify session
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Get clients by name
		return session.createQuery("FROM Client WHERE name=" + name).list();
	}

	@Override
	public List<Client> searchByNameAndSalary(final String namePattern, final Double salary) {

		// Query
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cb.createQuery(Client.class);
		final Root<Client> rootP = cquery.from(Client.class);
		final Join<Client, Contract> pJoinT = rootP.join("contractsList");

		// Where
		final Predicate pr1 = cb.like(pJoinT.getParent().<String>get("name"), namePattern);
		final Predicate pr2 = cb.gt(pJoinT.<Double>get("salary"), salary);

		// Query
		cquery.select(rootP).where(cb.and(pr1, pr2));

		// Order by salary
		cquery.distinct(true).orderBy(cb.desc(pJoinT.get("salary")));
		

		// Query execution
		return session.createQuery(cquery).getResultList();
	}
	
	@Override
	public List<Client> searchBySeller(int sellerId) {
		// Query
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cb.createQuery(Client.class);
		final Root<Client> rootP = cquery.from(Client.class);

		// Where
		final Predicate pr1 = cb.equal(rootP.get("seller"), sellerId);

		// Query
		cquery.select(rootP).where(cb.and(pr1));

		// Query execution
		return session.createQuery(cquery).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchAll() {

		// Verify session
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Get all clients
		return session.createQuery("FROM Client").list();

	}
}
