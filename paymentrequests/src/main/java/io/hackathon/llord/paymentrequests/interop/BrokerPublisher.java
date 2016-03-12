package io.hackathon.llord.paymentrequests.interop;

import org.springframework.stereotype.Component;

@Component
public interface BrokerPublisher 
{
	public boolean publishTransactionPending(String transactionId);
}
