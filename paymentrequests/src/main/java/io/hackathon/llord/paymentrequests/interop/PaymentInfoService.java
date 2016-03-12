package io.hackathon.llord.paymentrequests.interop;

import org.springframework.stereotype.Component;

import io.hackathon.llord.dao.domain.Payment;

@Component
public interface PaymentInfoService {

	public Payment GetPaymentById(String id);
}
