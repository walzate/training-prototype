package com.payulatam.model;

import javax.persistence.Entity;

import com.gigaspaces.annotation.pojo.SpaceId;

/**
 * Clients entity
 * 
 * @author wilson.alzate
 *
 */
@Entity
public class Client {

	/**
	 * The UUID for Gigaspaces
	 */
	private String id;
	/**
	 * The client's name
	 */
	private String name;
	/**
	 * The client's address
	 */
	private String address;
	/**
	 * The client's telephone number
	 */
	private String telephone;

	/**
	 * The empty constructor needed by Gigaspaces
	 */
	public Client() {
	}

	/**
	 * Constructor with all fields
	 * 
	 * @param name
	 *            The client's name
	 * @param address
	 *            The client's address
	 * @param telephone
	 *            The client's telephone number
	 */
	public Client(String name, String address, String telephone) {
		super();
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}

	/**
	 * Method used to return the client's id
	 * 
	 * @return The client's id
	 */
	@SpaceId(autoGenerate = true)
	public String getId() {
		return id;
	}

	/**
	 * Method used to modify the client's id
	 * 
	 * @param id
	 *            The client's id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method used to return the client's name
	 * 
	 * @return The client's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method used to modify the client's name
	 * 
	 * @param id
	 *            The client's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method used to return the client's address
	 * 
	 * @return The client's address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Method used to modify the client's address
	 * 
	 * @param id
	 *            The client's address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Method used to return the client's telephone number
	 * 
	 * @return The client's telephone number
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Method used to modify the client's telephone number
	 * 
	 * @param id
	 *            The client's telephone number
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [name=" + name + ", address=" + address + ", telephone=" + telephone + "]";
	}
}
