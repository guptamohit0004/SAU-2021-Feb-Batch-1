package com.accolite.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.accolite.domain.OrderEvent;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderEventDeserializer implements Deserializer<OrderEvent>{

	@Override
	public OrderEvent deserialize(String topic, byte[] data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

		OrderEvent msg = null;
		try {
			msg = objectMapper.readValue(data, OrderEvent.class);
		} catch (Exception e) {
			System.out.println("Exception while reading value"+e);
		}

		return msg;
	}

}
