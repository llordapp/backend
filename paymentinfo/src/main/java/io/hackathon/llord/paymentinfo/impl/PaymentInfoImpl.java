package io.hackathon.llord.paymentinfo.impl;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import io.hackathon.llord.dao.domain.Payment;
import io.hackathon.llord.paymentinfo.repositories.PaymentRepository;

public class PaymentInfoImpl {

	@Autowired
	private PaymentRepository paymentRepository;

	public List<Payment> findAllPayments() {
		return paymentRepository.findAll();
	}

	public List<Payment> findAllByStatus(String status) {
		return paymentRepository.findAllByStatus(status);
	}

	public byte[] getImage(String image) {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(image + ".png");
		try {
			return IOUtils.toByteArray(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Payment> paidTransactions() {
		return paymentRepository.findAllByStatus("Paid");
	}
	
	public List<Payment> incomingPayments() {
		return paymentRepository.findAllByDirection("IN");
	}

	public Payment findPaymentsById(String id) {
		return paymentRepository.findPaymentById(id);
	}

	public Payment updateStatus(String id, String transactionId, String status) {
		Payment payment = paymentRepository.findPaymentById(id);

		System.out.println("Updating with id and status: " + transactionId + " " + status);

		payment.update(status, transactionId);

		return paymentRepository.save(payment);
	}

	public void firstTimeSetup() {
		paymentRepository.deleteAll();
		Payment first = new Payment("Jaime", "Clinton", "40 Magic Road, MAG 1CS", "Amazon FireStick", "Requested",
				"invoice.png", "OUT", 3499, "GBP",
				LocalDateTime.now().minusHours(5).minusMinutes(22).toEpochSecond(ZoneOffset.UTC));
		Payment second = new Payment("James", "Butler", "150 Canning Town, E16 1FC", "Plumber payment", "Requested",
				"invoice.png", "OUT", 62300, "GBP",
				LocalDateTime.now().minusDays(22).minusHours(12).minusMinutes(3).toEpochSecond(ZoneOffset.UTC));
		Payment third = new Payment("Quynh", "Nhim", "12 Frontside, E12 3FA", "Hair Dryer", "Requested", "invoice.png", "OUT",
				1299, "GBP",
				LocalDateTime.now().minusDays(2).minusHours(7).minusMinutes(50).toEpochSecond(ZoneOffset.UTC));
		Payment fourth = new Payment("Saci", "Sebo", "12 Frontside, E12 3FA", "TV", "Requested", "invoice.png", "OUT", 97500,
				"GBP", LocalDateTime.now().minusDays(7).minusHours(3).minusMinutes(11).toEpochSecond(ZoneOffset.UTC));
		Payment fifth = new Payment("Jaime", "Clinton", "40 Magic Road, MAG 1CS", "Badminton Lessons", "Paid",
				"invoice.png", "OUT", 1500, "GBP",
				LocalDateTime.now().minusDays(32).minusHours(22).minusMinutes(11).toEpochSecond(ZoneOffset.UTC));
		Payment sixth = new Payment("James", "Butler", "12 150 Canning Town, E16 1FC", "Door replacement", "Paid",
				"invoice.png", "OUT", 12500, "GBP",
				LocalDateTime.now().minusDays(7).minusHours(3).minusMinutes(11).toEpochSecond(ZoneOffset.UTC));

		Payment seven = new Payment("James", "Butler", "12 150 Canning Town, E16 1FC", "Rent", "Paid",
				"invoice.png", "IN", 500, "GBP",
				LocalDateTime.now().minusDays(7).minusHours(3).minusMinutes(11).toEpochSecond(ZoneOffset.UTC));

		Payment eight = new Payment("Jaime", "Clinton", "40 Magic Road, MAG 1CS", "Rent", "Paid",
				"invoice.png", "IN", 1250, "GBP",
				LocalDateTime.now().minusDays(21).minusHours(5).minusMinutes(15).toEpochSecond(ZoneOffset.UTC));

		Payment nine = new Payment("Quynh", "Nhim", "12 Frontside, E12 3FA", "Rent", "Paid", "invoice.png", "IN",
				425, "GBP",
				LocalDateTime.now().minusDays(2).minusHours(7).minusMinutes(50).toEpochSecond(ZoneOffset.UTC));
		Payment ten = new Payment("Saci", "Sebo", "12 Frontside, E12 3FA", "Rent", "Paid", "invoice.png", "IN", 1500,
				"GBP", LocalDateTime.now().minusDays(7).minusHours(3).minusMinutes(11).toEpochSecond(ZoneOffset.UTC));
		
		paymentRepository.save(first);
		paymentRepository.save(second);
		paymentRepository.save(third);
		paymentRepository.save(fourth);
		paymentRepository.save(fifth);
		paymentRepository.save(sixth);
		paymentRepository.save(seven);
		paymentRepository.save(eight);
		paymentRepository.save(nine);
		paymentRepository.save(ten);
	}

}
