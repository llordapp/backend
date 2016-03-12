package io.hackathon.llord.dao.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Payment {

	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	private String address;
	private String reference;
	private String status;
	private String image;
	
	private long amount;
	private String currency;
	private LocalDateTime requestDate;
	private LocalDateTime paidDate;
	
	public Payment() {
		
	}

	public Payment(String firstName, String lastName, String address, String reference, String status, String image, long amount, String currency,
			LocalDateTime requestDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.reference = reference;
		this.status = status;
		this.image = image;
		this.amount = amount;
		this.currency = currency;
		this.requestDate = requestDate;
		this.paidDate = null;
	}

	public String getImage() {
		return image;
	}

	public LocalDateTime getPaidDate() {
		return paidDate;
	}

	public String getStatus() {
		return status;
	}

	public String getReference() {
		return reference;
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

	public long getAmount() {
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
				+ ", reference=" + reference + ", status=" + status + ", image=" + image + ", amount=" + amount
				+ ", currency=" + currency + ", requestDate=" + requestDate + ", paidDate=" + paidDate + "]";
	}
}
