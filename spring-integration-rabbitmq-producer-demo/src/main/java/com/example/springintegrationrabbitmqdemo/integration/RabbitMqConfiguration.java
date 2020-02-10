package com.example.springintegrationrabbitmqdemo.integration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.springintegrationrabbitmqdemo.integration.Channels.MUTUAS_INPUT_QUEUE_NAME;

@Configuration
public class RabbitMqConfiguration
{
    @Autowired
    private ConnectionFactory rabbitConnectionFactory;

    @Bean
    public RabbitTemplate apiMutuaRabbitTemplate()
    {
        RabbitTemplate r = new RabbitTemplate(rabbitConnectionFactory);
        r.setExchange(MUTUAS_INPUT_QUEUE_NAME);
        r.setConnectionFactory(rabbitConnectionFactory);
        return r;
    }
}
