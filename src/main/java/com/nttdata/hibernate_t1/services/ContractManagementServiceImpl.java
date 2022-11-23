package com.nttdata.hibernate_t1.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate_t1.persistence.Contract;
import com.nttdata.hibernate_t1.persistence.ContractDaoI;
import com.nttdata.hibernate_t1.persistence.ContractDaoImpl;

public class ContractManagementServiceImpl implements ContractManagementServiceI {

	/** DAO: T_CONTRACT */
	private ContractDaoI contractDao;

	/**
	 * Constructor.
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(final Contract newContract) {

		// Verify if exist or if it's null.
		if (newContract != null && newContract.getContractId() == null) {

			// Insert new contract
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(final Contract updatedContract) {

		// Verify if exist or if it's null.
		if (updatedContract != null && updatedContract.getContractId() != null) {

			// Update contract
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(final Contract deletedContract) {

		// Verify if exist or if it's null.
		if (deletedContract != null && deletedContract.getContractId() != null) {

			// Delete contract
			contractDao.delete(deletedContract);
		}

	}

	@Override
	public Contract searchById(final Long contractId) {

		// Result
		Contract contract = null;

		// Verify if it's null.
		if (contractId != null) {

			// Get contract by id
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<Contract> searchAll() {

		// Result
		return contractDao.searchAll();
	}
}
