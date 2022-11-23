package com.nttdata.hibernate_t1.persistence;

import java.util.List;

/**
 * 
 * Table T_SELLER DAO
 * 
 * @author Fernando Pérez Nieto
 *
 */
public interface SellerDaoI extends CommonDaoI<Seller> {

	
	/**
	 * Get seller by client name
	 * 
	 * @param name
	 * @return List<Seller>
	 */
	public List<Seller> searchByName(final String name);
	
	/**
	 * Get seller by phone number
	 * 
	 * @param phone
	 * @return List<Seller>
	 */
	public List<Seller> searchByPhone(final String phone);

}
