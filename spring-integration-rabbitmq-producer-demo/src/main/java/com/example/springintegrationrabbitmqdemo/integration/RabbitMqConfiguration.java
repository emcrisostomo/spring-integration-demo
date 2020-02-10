package com.example.springintegrationrabbitmqdemo.integration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration
{
    @Autowired
    private ConnectionFactory rabbitConnectionFactory;

    @Bean
    public RabbitTemplate worksRabbitTemplate()
    {
        RabbitTemplate r = new RabbitTemplate(rabbitConnectionFactory);
        r.setExchange(Channels.MUTUAS_INPUT_QUEUE_NAME);
        r.setConnectionFactory(rabbitConnectionFactory);
        return r;
    }
}
