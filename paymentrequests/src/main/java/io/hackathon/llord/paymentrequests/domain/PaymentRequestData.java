package io.hackathon.llord.paymentrequests.domain;

public class PaymentRequestData {
	private String paymentInfoId;
	private String expiryDate;
	private String cardNumber;
	private String type;
	private String cardHolderName;
	private String cvn;
	private boolean cvnPresent;

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

	public PaymentRequestData(String paymentInfoId, String expiryDate,
			String cardNumber, String type, String cardHolderName, String cvn,
			boolean cvnPresent) {
		super();
		this.paymentInfoId = paymentInfoId;
		this.expiryDate = expiryDate;
		this.cardNumber = cardNumber;
		this.type = type;
		this.cardHolderName = cardHolderName;
		this.cvn = cvn;
		this.cvnPresent = cvnPresent;
	}

	public PaymentRequestData()
	{
		
	}
	
	@Override
	public String toString() {
		return "PaymentRequestData [paymentInfoId=" + paymentInfoId
				+ ", expiryDate=" + expiryDate + ", cardNumber=" + cardNumber
				+ ", type=" + type + ", cardHolderName=" + cardHolderName
				+ ", cvn=" + cvn + ", cvnPresent=" + cvnPresent + "]";
	}

}
