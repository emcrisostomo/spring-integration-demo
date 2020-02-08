package com.accenture.springintegrationrabbitmqdemo.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ExampleSubscriberService
{
    private static final Logger logger = LoggerFactory.getLogger(ExampleSubscriberService.class);

    public void handleExampleMessage(Message<?> message)
    {
        logger.info(String.format("Message received from RabbitMQ with payload: %s", message.getPayload()));
    }
}
