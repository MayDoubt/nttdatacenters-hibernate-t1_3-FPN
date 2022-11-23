package com.nttdata.hibernate_t1.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * T_CLIENT table entity
 * 
 * @author Fernando Pérez Nieto
 *
 */
@Entity
@Table(name = "T_CLIENT")
public class Client extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Id (PK) */
	private Long clientId;

	/** Client name */
	private String name;

	/** Client firstSurname */
	private String firstSurname;
	
	/** Client secondSurname */
	private String secondSurname;

	/** Client dni */
	private String dni;
	
	/** Related Seller */
	private Seller seller;
	
	/** Related contracts list */
	private List<Contract> contractsList;

	/**
	 * @return the clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_CLIENT_ID", nullable = false)
	public Long getClientId() {
		return clientId;
	}	
	
	/**
	 * @param clientId
	 * 			the client id to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the firstSurname
	 */
	@Column(name = "C_FIRST_SURNAME", nullable = false)
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * @param firstSurname
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * @return the secondSurname
	 */
	@Column(name = "C_SECOND_SURNAME", nullable = false)
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param secondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "C_DNI", nullable = false)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the name
	 */
	@Column(name = "C_NAME", nullable = false)
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the seller
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_FK_SELLER_ID")
	public Seller getSeller() {
		return seller;
	}

	/**
	 * @param seller the seller to set
	 */
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	/**
	 * @return the contractsList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
	public List<Contract> getContractsList() {
		return contractsList;
	}
	
	/**
	 * @param contractsList
	 *            the contractsList to set
	 */
	public void setContractsList(List<Contract> contractsList) {
		this.contractsList = contractsList;
	}

	@Transient
	public Class<?> getClase() {
		return Client.class;
	}

	@Override
	public Long getId() {
		return this.clientId;
	}

	@Override
	public void setId(Long id) {
		this.clientId = id;
	}

}