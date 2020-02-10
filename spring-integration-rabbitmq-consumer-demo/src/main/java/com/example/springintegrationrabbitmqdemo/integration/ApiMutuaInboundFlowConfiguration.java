package com.example.springintegrationrabbitmqdemo.integration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import static com.example.springintegrationrabbitmqdemo.integration.Channels.MUTUAS_QUEUE_NAME;

@Configuration
public class ApiMutuaInboundFlowConfiguration
{
    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private ExampleSubscriberService exampleSubscriberService;

    @Bean
    public DirectMessageListenerContainer workListenerContainer()
    {
        DirectMessageListenerContainer container = new DirectMessageListenerContainer(connectionFactory);
        container.addQueueNames(MUTUAS_QUEUE_NAME);
        container.setConsumersPerQueue(2);
        return container;
    }

    @Bean
    public IntegrationFlow inboundFlow()
    {
        return IntegrationFlows.from(
                Amqp.inboundAdapter(workListenerContainer()))
                .handle(exampleSubscriberService::handleExampleMessage)
                .get();
    }
}
