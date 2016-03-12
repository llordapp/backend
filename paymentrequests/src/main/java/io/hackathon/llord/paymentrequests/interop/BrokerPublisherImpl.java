package io.hackathon.llord.paymentrequests.interop;

import io.hackathon.llord.dao.domain.Definitions;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BrokerPublisherImpl implements BrokerPublisher
{		
	@Autowired
	RabbitTemplate rabbitTemplate;

	@Bean
	Queue queue() {
		return new Queue(Definitions.TRANSACTION_PENDING_QUEUE, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(Definitions.BROKER_EXCHANGE);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Definitions.TRANSACTION_PENDING_QUEUE);
	}
	
	@Bean
	   public ConnectionFactory connectionFactory() {
	       CachingConnectionFactory connectionFactory =
	           new CachingConnectionFactory("25.105.222.31");
	       connectionFactory.setUsername("james");
	       connectionFactory.setPassword("james");
	       return connectionFactory;
	   }
	
	public boolean publishTransactionPending(String transactionId)
	{
		rabbitTemplate.convertAndSend(Definitions.TRANSACTION_PENDING_QUEUE, transactionId);
		return true;
	}
}
