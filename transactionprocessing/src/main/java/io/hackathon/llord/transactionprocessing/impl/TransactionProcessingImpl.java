package io.hackathon.llord.transactionprocessing.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.hackathon.llord.dao.domain.Definitions;

@Configuration
public class TransactionProcessingImpl {
	@Bean
	Queue queue() {
		return new Queue(Definitions.TRANSACTION_PENDING_QUEUE, false);
	}

	@Bean
	TransactionReceiver transactionReceiver() {
		return new TransactionReceiver();
	}
	
	@Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
            new CachingConnectionFactory("25.105.222.31");
        connectionFactory.setUsername("jaime");
        connectionFactory.setPassword("jaime");
        return connectionFactory;
    }

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("spring-boot-exchange");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Definitions.TRANSACTION_PENDING_QUEUE);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(Definitions.TRANSACTION_PENDING_QUEUE);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(TransactionReceiver transactionReceiver) {
		return new MessageListenerAdapter(transactionReceiver, "receiveMessage");
	}
	
	public void consumeQueue() throws InterruptedException {
		transactionReceiver().getLatch().await(10000, TimeUnit.MILLISECONDS);
	}
    
}
