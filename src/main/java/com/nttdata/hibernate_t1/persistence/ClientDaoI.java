package com.nttdata.hibernate_t1.persistence;

import java.util.List;

/**
 * 
 * Table T_CLIENT DAO
 * 
 * @author Fernando Pérez Nieto
 *
 */
public interface ClientDaoI extends CommonDaoI<Client> {

	/**
	 * Get clients by pattern name and salary
	 * 
	 * @param namePattern
	 * @param salary
	 * @return List<Client>
	 */
	public List<Client> searchByNameAndSalary(final String namePattern, final Double salary);
	
	/**
	 * Get clients by name
	 * 
	 * @param name
	 * @return List<Client>
	 */
	public List<Client> searchByName(final String name);
	
	/**
	 * Get clients by seller id
	 * 
	 * @param sellerId
	 * @return List<Client>
	 */
	public List<Client> searchBySeller(final int sellerId);

}
