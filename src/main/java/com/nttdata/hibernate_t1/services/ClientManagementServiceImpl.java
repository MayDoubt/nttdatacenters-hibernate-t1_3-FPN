package com.nttdata.hibernate_t1.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.hibernate_t1.persistence.Client;
import com.nttdata.hibernate_t1.persistence.ClientDaoI;
import com.nttdata.hibernate_t1.persistence.ClientDaoImpl;
import com.nttdata.hibernate_t1.utilities.InterfaceUtils;

/**
 * 
 * Client Service Implementation
 * 
 * @author Fernando Pérez Nieto
 *
 */
public class ClientManagementServiceImpl implements ClientManagementServiceI {

	/** Logger */
	private static Logger log = LoggerFactory.getLogger(ClientManagementServiceImpl.class);
	
	/** DAO: T_CLIENT */
	private ClientDaoI clientDao;

	/**
	 * Constructor
	 */
	public ClientManagementServiceImpl(final Session session) {
		this.clientDao = new ClientDaoImpl(session);
	}

	@Override
	public void insertNewClient(final Client newClient) {
		
		log.debug(InterfaceUtils.INIT);
		
		// Verify if exist or if it's null.
		if (newClient != null && newClient.getClientId() == null) {

			// Insert new client.
			clientDao.insert(newClient);
		}
		
		log.debug(InterfaceUtils.END);
	}

	@Override
	public void updateClient(final Client updatedClient) {
		
		log.debug(InterfaceUtils.INIT);
		
		// Verify if exist or if it's null.
		if (updatedClient!= null && updatedClient.getClientId() != null) {

			// Update client.
			clientDao.update(updatedClient);
		}
		
		log.debug(InterfaceUtils.END);
	}

	@Override
	public void deleteClient(final Client deletedClient) {

		log.debug(InterfaceUtils.INIT);
		
		// Verify if exist or if it's null.
		if (deletedClient != null && deletedClient.getClientId() != null) {

			// Delete client.
			clientDao.delete(deletedClient);
		}
		
		log.debug(InterfaceUtils.END);

	}

	@Override
	public Client searchById(final Long clientId) {
		
		log.debug(InterfaceUtils.INIT);
		
		// Result.
		Client client = null;

		// Verify if it's null
		if (clientId != null) {

			// Get the client by Id
			client = clientDao.searchById(clientId);
		}
		
		log.debug(InterfaceUtils.END);
		return client;
	}

	@Override
	public List<Client> searchByName(final String name) {

		log.debug(InterfaceUtils.INIT);
		
		// Result.
		List<Client> clientsList = new ArrayList<>();

		// Verify if it's null
		if (StringUtils.isNotBlank(name)) {

			// Get the clients by name
			clientsList = clientDao.searchByName(name);
		}

		log.debug(InterfaceUtils.END);
		return clientsList;
	}

	@Override
	public List<Client> searchAll() {
		
		log.debug(InterfaceUtils.INIT);
		
		// Get all clients
		log.debug(InterfaceUtils.END);
		return clientDao.searchAll();
		
		
	}

	@Override
	public List<Client> searchByNameAndSalary(String namePattern, Double salary) {
		
		log.debug(InterfaceUtils.INIT);
		
		// Get the clients.
		log.debug(InterfaceUtils.END);
		return clientDao.searchByNameAndSalary(namePattern, salary);
	}
	
	@Override
	public List<Client> searchBySeller(int sellerId) {
		log.debug(InterfaceUtils.INIT);
		
		// Get client by id
		log.debug(InterfaceUtils.END);
		return clientDao.searchBySeller(sellerId);
	}
}
