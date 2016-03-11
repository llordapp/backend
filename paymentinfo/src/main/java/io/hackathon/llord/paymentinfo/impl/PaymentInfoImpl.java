package io.hackathon.llord.paymentinfo.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.hackathon.llord.paymentinfo.domain.Payment;
import io.hackathon.llord.paymentinfo.repositories.PaymentRepository;

public class PaymentInfoImpl {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public List<Payment> findAllPayments() {
		return paymentRepository.findAll();
	}
	
	public Payment findPaymentsById(String id) {
		return paymentRepository.findPaymentById(id);
	}
	
	public void firstTimeSetup() {
		paymentRepository.deleteAll();
		Payment first = new Payment("Jaime", "Clinton", "40 Magic Road, MAG 1CS", 132.99, "GBP", LocalDateTime.now());
		Payment second = new Payment("James", "Butler", "420 High Street, H14 1EL", 623.00, "GBP", LocalDateTime.now().minusDays(22));
		Payment third = new Payment("Quynh", "Nhim", "12 Frontside, E12 3FA", 12.99, "GBP", LocalDateTime.now().minusDays(2));
		Payment fourth = new Payment("Saci", "Sebo", "12 Frontside, E12 3FA", 975.00, "GBP", LocalDateTime.now().minusDays(7));

		paymentRepository.save(first);
		paymentRepository.save(second);
		paymentRepository.save(third);
		paymentRepository.save(fourth);
	}
	
}
