package io.hackathon.llord.paymentinfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.hackathon.llord.dao.domain.Payment;
import io.hackathon.llord.paymentinfo.impl.PaymentInfoImpl;

@RestController
public class PaymentInfoController {
	
	@Autowired
	PaymentInfoImpl impl;

	@RequestMapping("/")
	public List<Payment> index() {
		System.out.println("Getting all payments in requested state");
		return impl.findAllByStatus("Requested");
	}
	
	@RequestMapping("/all")
	public List<Payment> findAll() {
		System.out.println("Getting all payments");
		return impl.findAllPayments();
	}
	
	@RequestMapping(value = "/image/{image}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage(@PathVariable String image) {
		return impl.getImage(image);
	}
	
	@RequestMapping("/{id}")
    public Payment findPayment(@PathVariable String id) {
		System.out.println("id was: " + id);
		return impl.findPaymentsById(id);
    }
	
	@RequestMapping("/setup")
	public void firstTimeSetup() {
		System.out.println("Running first time setup");
		impl.firstTimeSetup();
	}
	
	@RequestMapping("/{id}/{status}")
	public Payment updateStatus(@PathVariable String id, @PathVariable String status) {
		return impl.updateStatus(id, status);
	}
}
