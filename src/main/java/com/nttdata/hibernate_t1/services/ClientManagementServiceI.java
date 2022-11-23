package com.nttdata.hibernate_t1.services;

import java.util.List;

import com.nttdata.hibernate_t1.persistence.Client;

/**
 * 
 * Client service interface
 * 
 * @author Fernando Pérez Nieto
 *
 */
public interface ClientManagementServiceI {

	/**
	 * Insert new client.
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);

	/**
	 * Update existing client
	 * 
	 * @param updatedClient
	 */
	public void updateClient(final Client updatedClient);

	/**
	 * Delete existing client.
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);

	/**
	 * Get a client by ID.
	 * 
	 * @param clientId
	 */
	public Client searchById(final Long clientId);

	/**
	 * Get a client data by name
	 * 
	 * @param name
	 * @return List<Client>
	 */
	public List<Client> searchByName(final String name);

	/**
	 * Get all clients
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchAll();

	/**
	 * Get clients by name and salary
	 * 
	 * @param namePattern
	 * @param salary
	 * @return List<Client>
	 */
	public List<Client> searchByNameAndSalary(final String namePattern, final Double salary);

	/**
	 * Get a client list from sellerId
	 * 
	 * @param sellerId
	 * @return List<Client>
	 */
	public List<Client> searchBySeller(final int sellerId);
}
