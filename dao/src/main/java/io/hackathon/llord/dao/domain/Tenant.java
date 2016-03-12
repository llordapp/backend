package io.hackathon.llord.dao.domain;

import org.springframework.data.annotation.Id;

public class Tenant {

	@Id
	private String tenantId;
	private String firstName;
	private String lastName;
	private String propertyId;

	public Tenant() {
		
	}

	public Tenant(String firstName, String lastName, String propertyId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.propertyId = propertyId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPropertyId() {
		return propertyId;
	}
}
