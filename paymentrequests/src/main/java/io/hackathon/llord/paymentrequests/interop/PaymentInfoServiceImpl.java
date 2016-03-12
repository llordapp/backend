package io.hackathon.llord.paymentrequests.interop;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.hackathon.llord.dao.domain.Payment;


public class PaymentInfoServiceImpl implements PaymentInfoService 
{
	
	private String url = "http://25.105.222.31:8080/";
	
	public Payment GetPaymentById(String id) 
	{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + id);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Payment> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, Payment.class);
		return response.getBody();
	}
}
