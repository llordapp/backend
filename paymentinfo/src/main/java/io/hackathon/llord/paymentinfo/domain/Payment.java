package io.hackathon.llord.paymentinfo.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Payment {

	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	private String address;
	
	private double amount;
	private String currency;
	private LocalDateTime requestDate;
	
	public Payment() {
		
	}

	public Payment(String firstName, String lastName, String address, double amount, String currency,
			LocalDateTime requestDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.amount = amount;
		this.currency = currency;
		this.requestDate = requestDate;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public double getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public LocalDateTime getRequestDate() {
		return requestDate;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", amount=" + amount + ", currency=" + currency + ", requestDate=" + requestDate + "]";
	}
	
}
