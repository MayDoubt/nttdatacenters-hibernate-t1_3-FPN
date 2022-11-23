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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * T_SELLER table entity
 * 
 * @author Fernando Pérez Nieto
 *
 */
@Entity
@Table(name = "T_SELLER")
public class Seller extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Id (PK) */
	private Long sellerId;

	/** Seller name */
	private String name;

	/** Seller firstSurname */
	private String firstSurname;
	
	/** Seller secondSurname */
	private String secondSurname;

	/** Seller phone */
	private String phone;
	
	/** Related clients list */
	private List<Client> clientsList;

	/**
	 * @return the sellerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_SELLER_ID", nullable = false)
	public Long getSellerId() {
		return sellerId;
	}
	
	/**
	 * @param sellerId
	 * 			the seller id to set
	 */
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the clientsList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "seller")
	public List<Client> getClientsList() {
		return clientsList;
	}

	/**
	 * @param clientsList the clientsList to set
	 */
	public void setClientsList(List<Client> clientsList) {
		this.clientsList = clientsList;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", name=" + name + ", firstSurname=" + firstSurname + ", secondSurname="
				+ secondSurname + ", phone=" + phone + ", clientsList=" + clientsList + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Seller.class;
	}

	@Override
	public Long getId() {
		return this.sellerId;
	}

	@Override
	public void setId(Long id) {
		this.sellerId = id;
	}

}
