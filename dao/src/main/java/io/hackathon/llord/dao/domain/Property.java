package io.hackathon.llord.dao.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Property {
	@Id
	private String propertyId;
	private String address;
	private long rentAmount;
	private int contractMonthsLeft;
	private List<Tenant> tenants;

	public String getPropertyId() {
		return propertyId;
	}

	public String getAddress() {
		return address;
	}

	public long getRentAmount() {
		return rentAmount;
	}

	public int getContractMonthsLeft() {
		return contractMonthsLeft;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public Property(String address, long rentAmount,
			int contractMonthsLeft, List<Tenant> tenants) {
		super();		
		this.address = address;
		this.rentAmount = rentAmount;
		this.contractMonthsLeft = contractMonthsLeft;
		this.tenants = tenants;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", address=" + address
				+ ", rentAmount=" + rentAmount + ", contractMonthsLeft="
				+ contractMonthsLeft + ", tenants=" + tenants + "]";
	}

}
