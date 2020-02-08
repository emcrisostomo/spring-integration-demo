package com.accenture.springintegrationdemo.integration;

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
        logger.info(String.format("Message received with payload: %s", message.getPayload()));
    }

    public void handleOutputMessage(Message<?> message)
    {
        logger.info(String.format("Message received with payload on output channel: %s", message.getPayload()));
    }

    public void handleOutputQueueMessage(Message<?> message)
    {
        logger.info(String.format("Message received on output queue: %s", message.getPayload()));
    }
}
