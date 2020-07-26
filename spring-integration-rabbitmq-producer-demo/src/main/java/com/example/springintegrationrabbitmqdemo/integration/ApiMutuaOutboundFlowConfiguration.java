package com.example.springintegrationrabbitmqdemo.integration;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;

import static com.example.springintegrationrabbitmqdemo.integration.Channels.API_MUTUA_INPUT_CHANNEL;
import static com.example.springintegrationrabbitmqdemo.integration.Channels.MUTUAS_INPUT_QUEUE_NAME;

@Configuration
public class ApiMutuaOutboundFlowConfiguration
{
    @Bean
    public DirectExchange mutuasInputExchange()
    {
        return new DirectExchange(MUTUAS_INPUT_QUEUE_NAME, true, false);
    }

    @Bean
    public IntegrationFlow apiMutuaInputFlow(RabbitMqConfiguration rabbitConfig)
    {
        return IntegrationFlows
                .from(API_MUTUA_INPUT_CHANNEL)
                .transform(Transformers.toJson())
                .handle(Amqp.outboundAdapter(rabbitConfig.apiMutuaRabbitTemplate()))
                .get();
    }
}
