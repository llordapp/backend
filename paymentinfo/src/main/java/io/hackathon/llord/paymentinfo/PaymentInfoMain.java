package io.hackathon.llord.paymentinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.hackathon.llord.paymentinfo.impl.PaymentInfoImpl;

@SpringBootApplication
public class PaymentInfoMain 
{
	@Bean
	PaymentInfoImpl paymentInfoImpl() {
		return new PaymentInfoImpl();
	}
	
    public static void main( String[] args )
    {
		SpringApplication.run(PaymentInfoMain.class, args);
    }
}
