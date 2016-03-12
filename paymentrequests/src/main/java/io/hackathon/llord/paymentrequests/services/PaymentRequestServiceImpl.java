package io.hackathon.llord.paymentrequests.services;

import io.hackathon.llord.dao.domain.Payment;
import io.hackathon.llord.dao.domain.TransactionData;
import io.hackathon.llord.paymentrequests.domain.PaymentRequestData;
import io.hackathon.llord.paymentrequests.interop.PaymentInfoService;
import io.hackathon.llord.paymentrequests.interop.BrokerPublisher;
import io.hackathon.llord.paymentrequests.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class PaymentRequestServiceImpl implements PaymentRequestService {

	@Autowired
	private PaymentInfoService paymentInfoService;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private BrokerPublisher brokerPublisher;
	
	/**
	 * @see PaymentRequestService.CreatePaymentTransaction(String)
	 */
	public String CreatePaymentTransaction(PaymentRequestData paymentRequestData) 
	{
		//Also validate the card details are populated etc.
		if (paymentRequestData == null) 
		{
			System.out.println("The paymentInfoId was null or empty");
			return null;
		}
		// get from payment info
		Payment payment = paymentInfoService.GetPaymentById(paymentRequestData.getPaymentInfoId());
		
		// create a transaction
		TransactionData transactionData = GenerateNewTransaction(payment, paymentRequestData);

		if (transactionData == null)// || !ValidateTransactionData(transactionData))
		{
			System.out.println("The mapped TransactionData object was null.");
			return null;
		}
		
		// insert to DB
		TransactionData transactionDataStored = transactionRepository.save(transactionData);
		if (transactionDataStored == null)
		{
			System.out.println("The save operation for the TransactionData object returned null.");
			return null;
		}
			
		// Add to broker
		boolean publishSuccess = brokerPublisher.publishTransactionPending(transactionDataStored.getTransactionId());
		if (!publishSuccess)
		{
			System.out.println("The transaction id could not be published to the broker");
			return null;
		}
		
		return transactionDataStored.getTransactionId();
	}

	/**
	 * Generates a new {@code TransactionData} object from the combination of the
	 * input parameters
	 * @param payment The payment information
	 * @param paymentRequestData The payment request information
	 * @return a combined TransactionData object
	 */
	private TransactionData GenerateNewTransaction(Payment payment, PaymentRequestData paymentRequestData) 
	{
		if (payment == null)
		{
			System.out.println("Payment object was null, could not generate new transaction.");
			return null;
		}
		
		TransactionData transactionData = new TransactionData(
				payment.getId(),
				paymentRequestData.getExpiryDate(),
				paymentRequestData.getCardNumber(),
				paymentRequestData.getType(),
				paymentRequestData.getCardHolderName(),
				paymentRequestData.getCvn(),
				paymentRequestData.isCvnPresent(),
				payment.getAmount(),
				payment.getCurrency());
		
		return transactionData;
	}
}
