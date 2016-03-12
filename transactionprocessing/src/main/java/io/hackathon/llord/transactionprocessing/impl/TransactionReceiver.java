package io.hackathon.llord.transactionprocessing.impl;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.realexpayments.remote.sdk.RealexClient;
import com.realexpayments.remote.sdk.domain.Card;
import com.realexpayments.remote.sdk.domain.Card.CardType;
import com.realexpayments.remote.sdk.domain.Cvn.PresenceIndicator;
import com.realexpayments.remote.sdk.domain.payment.AutoSettle;
import com.realexpayments.remote.sdk.domain.payment.AutoSettle.AutoSettleFlag;
import com.realexpayments.remote.sdk.domain.payment.PaymentRequest;
import com.realexpayments.remote.sdk.domain.payment.PaymentRequest.PaymentType;
import com.realexpayments.remote.sdk.domain.payment.PaymentResponse;
import com.realexpayments.remote.sdk.http.HttpConfiguration;

import io.hackathon.llord.dao.domain.Payment;
import io.hackathon.llord.dao.domain.TransactionData;
import io.hackathon.llord.transactionprocessing.repositories.TransactionRepository;

public class TransactionReceiver {
	
	private String url = "http://localhost:8080";
	
	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	TransactionRepository transactionRepository;
	
	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String transactionId) {
		System.out.println("Received <" + transactionId + ">");
		
		TransactionData data = transactionRepository.findTransactionDataByTransactionId(transactionId);

		Card card = new Card()
		        .addExpiryDate(data.getExpiryDate())
		        .addNumber(data.getCardNumber())
		        .addType(CardType.VISA)
		        .addCardHolderName(data.getCardHolderName())
		        .addCvn(data.getCvn())
		        .addCvnPresenceIndicator(PresenceIndicator.CVN_PRESENT);

		PaymentRequest request = new PaymentRequest()
		        .addMerchantId("hackathon1")
		        .addType(PaymentType.AUTH)
		        .addAmount(data.getAmount() / 100)
		        .addCurrency(data.getCurrency())
		        .addCard(card)
		        .addAutoSettle(new AutoSettle().addFlag(AutoSettleFlag.TRUE));

		HttpConfiguration httpConfiguration = new HttpConfiguration();
		httpConfiguration.setEndpoint("https://epage.sandbox.payandshop.com/epage-remote.cgi");
		RealexClient client = new RealexClient("secret", httpConfiguration);
		PaymentResponse response = client.send(request);
		
		String state = response.getResult();
		
		if ("00".equals(state)) {
			// Success
			System.out.println("Success!");
			setPaymentInfoStatus(data.getPaymentInfoId(), data.getTransactionId());
		} else if (state.startsWith("1")) {
			// Failed transaction.
			System.out.println("Failed transaction!");
		} else if (state.startsWith("2")) {
			// Error with bank systems.
			System.out.println("Error with bank systems!");
		} else if (state.startsWith("3")) {
			// Error with RealEx.
			System.out.println("Error with RealEx!");
		} else if (state.startsWith("5")) {
			// Incorrect XML data.
			System.out.println("Incorrect XML data!");
		} else {
			// Error.
			System.out.println("Generic error! " + state);
		}
		
		latch.countDown();
	}
	
	private void setPaymentInfoStatus(String id, String transactionId) 
	{
		String fullUrl = String.format("%s/%s/%s/%s", url, id, transactionId, "Paid");
		
		System.out.println("URL IS : " + fullUrl);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fullUrl);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, Payment.class);
	}

	public CountDownLatch getLatch() {
		return latch;
	}
}
