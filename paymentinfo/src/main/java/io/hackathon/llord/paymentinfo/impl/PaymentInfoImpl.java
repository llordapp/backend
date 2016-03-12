package io.hackathon.llord.paymentinfo.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.hackathon.llord.dao.domain.Payment;
import io.hackathon.llord.dao.repositories.PaymentRepository;

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
		Payment first = new Payment("Jaime", "Clinton", "40 Magic Road, MAG 1CS", "Washing Machine", "Requested",
				132.99, "GBP", LocalDateTime.now().minusHours(5).minusMinutes(22));
		Payment second = new Payment("James", "Butler", "420 High Street, H14 1EL", "Plumber payment", "Requested",
				623.00, "GBP", LocalDateTime.now().minusDays(22).minusHours(12).minusMinutes(3));
		Payment third = new Payment("Quynh", "Nhim", "12 Frontside, E12 3FA", "Hair Dryer", "Requested", 12.99, "GBP",
				LocalDateTime.now().minusDays(2).minusHours(7).minusMinutes(50));
		Payment fourth = new Payment("Saci", "Sebo", "12 Frontside, E12 3FA", "TV", "Requested", 975.00, "GBP",
				LocalDateTime.now().minusDays(7).minusHours(3).minusMinutes(11));

		paymentRepository.save(first);
		paymentRepository.save(second);
		paymentRepository.save(third);
		paymentRepository.save(fourth);
	}

}
