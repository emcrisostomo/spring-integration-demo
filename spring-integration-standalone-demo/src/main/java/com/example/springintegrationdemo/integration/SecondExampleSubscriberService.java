package com.example.springintegrationdemo.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class SecondExampleSubscriberService
{
    private static final Logger logger = LoggerFactory.getLogger(SecondExampleSubscriberService.class);

    public void handleExampleMessage(Message<?> message)
    {
        logger.info("Message received by subscriber 2 with payload: {}", message.getPayload());
    }
}
