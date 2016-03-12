package io.hackathon.llord.paymentrequests;

import io.hackathon.llord.paymentrequests.interop.BrokerPublisher;
import io.hackathon.llord.paymentrequests.interop.BrokerPublisherImpl;
import io.hackathon.llord.paymentrequests.interop.PaymentInfoService;
import io.hackathon.llord.paymentrequests.interop.PaymentInfoServiceImpl;
import io.hackathon.llord.paymentrequests.services.PaymentRequestService;
import io.hackathon.llord.paymentrequests.services.PaymentRequestServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main 
{
	@Bean
	PaymentRequestService paymentRequestService()
	{
		return new PaymentRequestServiceImpl();
	}
	
	@Bean
	PaymentInfoService paymentInfoService()
	{
		return new PaymentInfoServiceImpl();
	}
		
	@Bean
	BrokerPublisher brokerPublisher()
	{
		return new BrokerPublisherImpl();
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Main.class, args);
	}

}
