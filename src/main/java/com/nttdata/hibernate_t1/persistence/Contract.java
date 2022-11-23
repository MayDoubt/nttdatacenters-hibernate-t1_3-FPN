package com.nttdata.hibernate_t1.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Table entity T_CONTRACT
 * 
 * @author Fernando Pérez Nieto
 *
 */
@Entity
@Table(name = "T_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Id (PK) */
	private Long contractId;
	
	/** Effective date */
	private Date effectiveDate;
	
	/** Date of expiry */
	private Date expiryDate;

	/** Salary */
	private Double salary;

	/** Client (FK) */
	private Client client;
	
	/**
	 * @return the ContractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}
	
	/**
	 * @param contractId
	 * 			the contract id to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	
	/**
	 * @return the effectiveDate
	 */
	@Column(name = "C_EFFECTIVE_DATE", nullable = false)
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	
	/**
	 * @param effectiveDate
	 *            the effective date to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	/**
	 * @return the expiryDate
	 */
	@Column(name = "C_EXPIRY_DATE", nullable = false)
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	/**
	 * @param expiryDate
	 *            the date of expiry to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the name
	 */
	@Column(name = "C_SALARY", nullable = false)
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	/**
	 * @return the client
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_FK_CLIENT_ID")
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Override
	public Long getId() {
		return this.contractId;
	}

	@Override
	public void setId(Long id) {
		this.contractId = id;
	}

}