package com.nttdata.hibernate_t1.services;

import java.util.List;

import com.nttdata.hibernate_t1.persistence.Seller;

/**
 * 
 * Seller service interface
 * 
 * @author Fernando Pérez Nieto
 *
 */
public interface SellerManagementServiceI {

	/**
	 * Insert new seller.
	 * 
	 * @param newSeller
	 */
	public void insertNewSeller(final Seller newSeller);

	/**
	 * Update existing seller
	 * 
	 * @param updatedSeller
	 */
	public void updateSeller(final Seller updatedSeller);

	/**
	 * Delete existing seller.
	 * 
	 * @param deletedSeller
	 */
	public void deleteSeller(final Seller deletedSeller);

	/**
	 * Get a seller by ID.
	 * 
	 * @param sellerId
	 */
	public Seller searchById(final Long sellerId);

	/**
	 * Get all sellers
	 * 
	 * @return List<Seller>
	 */
	public List<Seller> searchAll();

	/**
	 * @param name
	 * @return List<Seller>
	 */
	public List<Seller> searchByName(String name);
}