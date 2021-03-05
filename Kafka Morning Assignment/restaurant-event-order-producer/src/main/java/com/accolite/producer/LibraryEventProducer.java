package com.accolite.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.accolite.domain.OrderEvent;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class LibraryEventProducer {
	@Autowired
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;
	public void sendLibraryEventAsynchronous(OrderEvent orderEvent) throws JsonProcessingException {
		kafkaTemplate.send("restaurant", orderEvent);
	}
}
