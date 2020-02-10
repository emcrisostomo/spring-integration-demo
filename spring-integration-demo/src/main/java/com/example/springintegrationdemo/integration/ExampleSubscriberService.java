package com.example.springintegrationdemo.integration;

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
        logger.info("Message received with payload: {}", message.getPayload());
    }

    public void handleOutputMessage(Message<?> message)
    {
        logger.info("Message received with payload on output channel: {}", message.getPayload());
    }

    public void handleOutputQueueMessage(Message<?> message)
    {
        logger.info("Message received on output queue: {}", message.getPayload());
    }
}
