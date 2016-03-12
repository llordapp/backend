package io.hackathon.llord.dao.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactiondata")
public class TransactionData {
	@Id
	private String transactionId;
	private String paymentInfoId;
	private String expiryDate;
	private String cardNumber;
	private String type;
	private String cardHolderName;
	private String cvn;
	private boolean cvnPresent;
	private long amount;
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

	public String getCardNumber() {
		return cardNumber;
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

	public long getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public TransactionData(String paymentInfoId, String expiryDate, String cardNumber,
			String type, String cardHolderName, String cvn, boolean cvnPresent,
			long amount, String currency) {
		super();
		this.paymentInfoId = paymentInfoId;
		this.expiryDate = expiryDate;
		this.cardNumber = cardNumber;
		this.type = type;
		this.cardHolderName = cardHolderName;
		this.cvn = cvn;
		this.cvnPresent = cvnPresent;
		this.amount = amount;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "TransactionData [transactionId=" + transactionId
				+ ", paymentInfoId=" + paymentInfoId + ", expiryDate="
				+ expiryDate + ", cardNumber=" + cardNumber + ", type=" + type
				+ ", cardHolderName=" + cardHolderName + ", cvn=" + cvn
				+ ", cvnPresent=" + cvnPresent + ", amount=" + amount
				+ ", currency=" + currency + "]";
	}
}
