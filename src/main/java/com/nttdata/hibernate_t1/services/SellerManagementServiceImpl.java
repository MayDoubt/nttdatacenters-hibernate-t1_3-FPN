package com.nttdata.hibernate_t1.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.hibernate_t1.persistence.Seller;
import com.nttdata.hibernate_t1.persistence.SellerDaoI;
import com.nttdata.hibernate_t1.persistence.SellerDaoImpl;
import com.nttdata.hibernate_t1.utilities.InterfaceUtils;

/**
 * 
 * Seller Service Implementation
 * 
 * @author Fernando Pérez Nieto
 *
 */
public class SellerManagementServiceImpl implements SellerManagementServiceI {

	/** Logger */
	private static Logger log = LoggerFactory.getLogger(SellerManagementServiceImpl.class);
	
	/** DAO: T_CLIENT */
	private SellerDaoI sellerDao;

	/**
	 * Constructor
	 */
	public SellerManagementServiceImpl(final Session session) {
		this.sellerDao = new SellerDaoImpl(session);
	}

	@Override
	public void insertNewSeller(final Seller newSeller) {
		
		log.debug(InterfaceUtils.INIT);
		
		// Verify if exist or if it's null.
		if (newSeller!= null && newSeller.getSellerId() == null) {

			// Insert new client.
			sellerDao.insert(newSeller);
		}
		
		log.debug(InterfaceUtils.END);
	}

	@Override
	public void updateSeller(final Seller updatedSeller) {
		
		log.debug(InterfaceUtils.INIT);
		
		// Verify if exist or if it's null.
		if (updatedSeller!= null && updatedSeller.getSellerId() != null) {

			// Update client.
			sellerDao.update(updatedSeller);
		}
		
		log.debug(InterfaceUtils.END);
	}

	@Override
	public void deleteSeller(final Seller deletedSeller) {

		log.debug(InterfaceUtils.INIT);
		
		// Verify if exist or if it's null.
		if (deletedSeller != null && deletedSeller.getSellerId() != null) {

			// Delete client.
			sellerDao.delete(deletedSeller);
		}
		
		log.debug(InterfaceUtils.END);

	}

	@Override
	public Seller searchById(final Long sellerId) {
		
		log.debug(InterfaceUtils.INIT);
		
		// Result.
		Seller seller = null;

		// Verify if it's null
		if (sellerId != null) {

			// Get the client by Id
			seller = sellerDao.searchById(sellerId);
		}
		
		log.debug(InterfaceUtils.END);
		return seller;
	}

	@Override
	public List<Seller> searchByName(final String name) {

		log.debug(InterfaceUtils.INIT);
		
		// Result.
		List<Seller> sellersList = new ArrayList<>();

		// Verify if it's null
		if (StringUtils.isNotBlank(name)) {

			// Get the clients by name
			sellersList = sellerDao.searchByName(name);
		}

		log.debug(InterfaceUtils.END);
		return sellersList;
	}

	@Override
	public List<Seller> searchAll() {
		
		log.debug(InterfaceUtils.INIT);
		
		// Get all clients
		log.debug(InterfaceUtils.END);
		return sellerDao.searchAll();
		
		
	}
}
