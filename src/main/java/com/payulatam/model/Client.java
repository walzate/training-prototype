package com.payulatam.model;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	 * Method used to return the value of the Client's id
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:16 a. m.
	 * @return The Client's id to return
	 */
	@Id
	@SpaceId(autoGenerate=true)
	public String getId() {
		return id;
	}

	/**
	 * Method used to modify the value of the Client's id
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:16 a. m.
	 * @param id
	 *            The Client's id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method used to return the value of the Client's name
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:16 a. m.
	 * @return The Client's name to return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method used to modify the value of the Client's name
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:16 a. m.
	 * @param name
	 *            The Client's name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method used to return the value of the Client's address
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:16 a. m.
	 * @return The Client's address to return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Method used to modify the value of the Client's address
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:16 a. m.
	 * @param address
	 *            The Client's address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Method used to return the value of the Client's telephone
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:16 a. m.
	 * @return The Client's telephone to return
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Method used to modify the value of the Client's telephone
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:16 a. m.
	 * @param telephone
	 *            The Client's telephone to set
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
