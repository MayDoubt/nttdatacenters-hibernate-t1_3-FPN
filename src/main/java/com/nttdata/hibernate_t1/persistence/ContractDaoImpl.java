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
 * Table T_CONTRACT DAO Impl
 * 
 * @author Fernando Pérez Nieto
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** Database session */
	private Session session;

	/**
	 * Constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@Override
	public List<Contract> searchByClientId(final Long clientId){
		
		// Query
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Contract> cquery = cb.createQuery(Contract.class);
		final Root<Contract> rootP = cquery.from(Contract.class);
		final Join<Client, Contract> pJoinT = rootP.join("client");

		// Where
		final Predicate pr1 = cb.gt(pJoinT.<Long> get("clientId"), clientId);

		// Query
		cquery.select(rootP).where(cb.and(pr1));

		// Order by name
		cquery.orderBy(cb.desc(pJoinT.get("name")));

		// Query execution
		return session.createQuery(cquery).getResultList();
	}
}
