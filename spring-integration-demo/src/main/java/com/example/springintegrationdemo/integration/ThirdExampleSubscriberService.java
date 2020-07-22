package com.example.springintegrationdemo.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ThirdExampleSubscriberService
{
    private static final Logger logger = LoggerFactory.getLogger(ThirdExampleSubscriberService.class);

    public void handleExampleMessage(Message<?> message)
    {
        logger.info("Message received on polled queue: {}", message.getPayload());
    }
}
