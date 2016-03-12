package io.hackathon.llord.paymentrequests.services;

import org.springframework.stereotype.Service;

import io.hackathon.llord.paymentrequests.domain.PaymentRequestData;

@Service
public interface PaymentRequestService {

	/**
	 * Creates and persists a new transaction, adding a new 'transaction added'
	 * notification to the broker.
	 * @param paymentInfoId The Id of the existing payment
	 * @return The Id of the generated transaction for the payment
	 */
	public String CreatePaymentTransaction(PaymentRequestData paymentRequestData);
}
