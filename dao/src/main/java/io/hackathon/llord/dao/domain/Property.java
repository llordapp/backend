package io.hackathon.llord.dao.domain;

import org.springframework.data.annotation.Id;

public class Property {

	@Id
	private String propertyId;
	private String address;
	private long rentAmount;

	public String getPropertyId() {
		return propertyId;
	}

	public String getAddress() {
		return address;
	}

	public long getRentAmount() {
		return rentAmount;
	}

	public Property() {

	}

	public Property(String address, long rentAmount) {
		super();
		this.address = address;
		this.rentAmount = rentAmount;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", address=" + address + ", rentAmount=" + rentAmount + "]";
	}

}
