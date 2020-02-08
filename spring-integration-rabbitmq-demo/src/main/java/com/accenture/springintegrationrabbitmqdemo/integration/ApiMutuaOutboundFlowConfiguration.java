package com.accenture.springintegrationrabbitmqdemo.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;

import static com.accenture.springintegrationrabbitmqdemo.integration.Channels.API_MUTUA_INPUT_CHANNEL;

@Configuration
public class ApiMutuaOutboundFlowConfiguration
{
    @Autowired
    private RabbitMqConfiguration rabbitConfig;

    @Bean
    public IntegrationFlow apiMutuaInputFlow()
    {
        return IntegrationFlows
                .from(API_MUTUA_INPUT_CHANNEL)
                .transform(Transformers.toJson())
                .handle(Amqp.outboundAdapter(rabbitConfig.worksRabbitTemplate()))
                .get();
    }
}
