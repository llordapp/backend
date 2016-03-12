package io.hackathon.llord.transactionprocessing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.hackathon.llord.transactionprocessing.impl.TransactionProcessingImpl;

@SpringBootApplication
public class TransactionProcessingMain implements CommandLineRunner
{ 
	@Bean
	TransactionProcessingImpl transactionProcessingImpl() {
		return new TransactionProcessingImpl();
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(TransactionProcessingMain.class, args);
	}

	public void run(String... args) throws Exception {
		transactionProcessingImpl().consumeQueue();
	}
}
