package com.nttdata.hibernate_t1.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 * Abstract Entity
 * 
 * @author Fernando Pérez Nieto
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Auditoría | Usuario que actualiza */
	private String updatedUser;

	/** Auditoría | Día actualizado */
	private Date updatedDate;

	/**
	 * GET ID
	 * 
	 * @return Long
	 */
	public abstract Long getId();

	/**
	 * SET ID
	 * 
	 * @param id
	 */
	public abstract void setId(final Long id);

	/**
	 * @return the updatedUser
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser
	 *            the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}