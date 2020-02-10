package com.example.springintegrationrabbitmqdemo.integration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;

@Configuration
public class ApiMutuaOutboundFlowConfiguration
{
    @Autowired
    private RabbitMqConfiguration rabbitConfig;

    @Bean
    public DirectExchange mutuasInputExchange()
    {
        return new DirectExchange(Channels.MUTUAS_INPUT_QUEUE_NAME, true, false);
    }

    @Bean
    public Queue mutuasQueue()
    {
        return new Queue(Channels.MUTUAS_QUEUE_NAME, true);
    }

    @Bean
    public Binding mutuasInputExchangeBinding(Queue queue, DirectExchange directExchange)
    {
        return BindingBuilder.bind(queue).to(directExchange).with("");
    }

    @Bean
    public IntegrationFlow apiMutuaInputFlow()
    {
        return IntegrationFlows
                .from(Channels.API_MUTUA_INPUT_CHANNEL)
                .transform(Transformers.toJson())
                .handle(Amqp.outboundAdapter(rabbitConfig.worksRabbitTemplate()))
                .get();
    }
}
