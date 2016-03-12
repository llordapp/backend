package io.hackathon.llord.paymentrequests.controllers;

import io.hackathon.llord.paymentrequests.domain.PaymentRequestData;
import io.hackathon.llord.paymentrequests.services.PaymentRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-request")
public class PaymentRequestController 
{
	@Autowired
	PaymentRequestService paymentRequestServiceImpl;
	
	/**
	 * Add a new transaction for the specified payment request
	 * @param paymentRequestData The Id of the existing payment request
	 * @return the ID of the transaction created
	 */
	@RequestMapping(method=RequestMethod.POST)	
	public ResponseEntity<String> add(@RequestBody PaymentRequestData paymentRequestData)
	{
		System.out.println(paymentRequestData.toString());
		if (paymentRequestData.equals(null))
		{
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}
		
		String success = paymentRequestServiceImpl.CreatePaymentTransaction(paymentRequestData);
		
		return new ResponseEntity<String>(success, HttpStatus.OK);
	}
}
