package io.hackathon.llord.dao.domain;

public class Tenant {
	
	private String firstName;
	private String lastName;


	public Tenant() {
		
	}

	public Tenant(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
