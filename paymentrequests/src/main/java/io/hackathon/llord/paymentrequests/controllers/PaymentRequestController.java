package io.hackathon.llord.paymentrequests.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-request")
public class PaymentRequestController {

	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void add(@PathVariable String paymentRequestId)
	{
		//create a transaction
		
		//insert to DB
		
		//Add to broker		
	}
}
