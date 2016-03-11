package io.hackathon.llord.paymentinfo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.hackathon.llord.paymentinfo.domain.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {
	
	public Payment findPaymentById(String id);
	public List<Payment> findAll();
}
