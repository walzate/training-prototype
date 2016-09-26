package com.payulatam.model;

import javax.persistence.Entity;

import com.gigaspaces.annotation.pojo.SpaceId;

@Entity
public class Client {

	private String id;
	private String name;
	private String address;
	private String telephone;

	public Client() {
	}

	public Client(String name, String address, String telephone) {
		super();
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}
	
	@SpaceId(autoGenerate=true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", address=" + address + ", telephone=" + telephone + "]";
	}
	
	

}
