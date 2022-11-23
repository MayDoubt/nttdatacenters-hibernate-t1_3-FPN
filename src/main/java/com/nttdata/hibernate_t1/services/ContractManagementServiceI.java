package com.nttdata.hibernate_t1.services;

import java.util.List;

import com.nttdata.hibernate_t1.persistence.Contract;


public interface ContractManagementServiceI {
	
	/**
	 * Insert new Contract
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Update existing contract
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final Contract updatedContract);

	/**
	 * Delete existing contract
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final Contract deletedContract);

	/**
	 * Get contract by id
	 * 
	 * @param contractId
	 */
	public Contract searchById(final Long contractId);

	/**
	 * Get all contracts
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAll();

}
