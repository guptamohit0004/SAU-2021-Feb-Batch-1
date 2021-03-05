package com.accolite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.domain.OrderEvent;
import com.accolite.producer.LibraryEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
public class OrderEventController {
	@Autowired
	private LibraryEventProducer libraryEventProducer;
	@PostMapping("/v1/orderEvent")
	public ResponseEntity<OrderEvent> postLibraryEvent(@RequestBody OrderEvent orderEvent)
			throws JsonProcessingException {
		libraryEventProducer.sendLibraryEventAsynchronous(orderEvent);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderEvent);
	}
}
