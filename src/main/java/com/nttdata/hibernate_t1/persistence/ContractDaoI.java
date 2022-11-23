package com.nttdata.hibernate_t1.persistence;

import java.util.List;

/**
 * 
 * T_CONTRACT table DAO
 * 
 * @author Fernando Pérez Nieto
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract> {

	
	/**
	 * Get contracts by clientId
	 * 
	 * @param clientId
	 * @return List<Contract>
	 */
	public List<Contract> searchByClientId(final Long clientId);
}
