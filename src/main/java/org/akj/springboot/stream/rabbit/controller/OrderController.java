package org.akj.springboot.stream.rabbit.controller;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.akj.springboot.stream.rabbit.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	@Qualifier("output")
	MessageChannel output;

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public Order add(@RequestBody Order order) {
		order.setId(UUID.randomUUID().toString());
		order.setCreateDate(Date.from(Instant.now()));

		output.send(MessageBuilder.withPayload(order).build());
		return order;
	}

}
