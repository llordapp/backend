package io.hackathon.llord.dao.domain;

import org.springframework.data.annotation.Id;

public class TransactionData {
	@Id
	private String transactionId;
	private String paymentInfoId;
	private String expiryDate;
	private String type;
	private String cardHolderName;
	private String cvn;
	private boolean cvnPresent;
	private double amount;
	private String currency;

	public String getTransactionId() {
		return transactionId;
	}

	public String getPaymentInfoId() {
		return paymentInfoId;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public String getType() {
		return type;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public String getCvn() {
		return cvn;
	}

	public boolean isCvnPresent() {
		return cvnPresent;
	}

	public double getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public TransactionData(String paymentInfoId, String expiryDate,
			String type, String cardHolderName, String cvn, boolean cvnPresent,
			double amount, String currency) {
		super();
		this.paymentInfoId = paymentInfoId;
		this.expiryDate = expiryDate;
		this.type = type;
		this.cardHolderName = cardHolderName;
		this.cvn = cvn;
		this.cvnPresent = cvnPresent;
		this.amount = amount;
		this.currency = currency;
	}
}
