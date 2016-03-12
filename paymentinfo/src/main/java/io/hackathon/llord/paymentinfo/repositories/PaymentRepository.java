package io.hackathon.llord.paymentinfo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.hackathon.llord.dao.domain.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
	public Payment findPaymentById(String id);
	public List<Payment> findAllByStatus(String status);
	public List<Payment> findAll();
	public List<Payment> findAllByDirection(String direction);
}
