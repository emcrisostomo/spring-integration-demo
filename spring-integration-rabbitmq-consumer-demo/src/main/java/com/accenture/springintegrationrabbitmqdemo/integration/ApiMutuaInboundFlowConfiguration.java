package com.accenture.springintegrationrabbitmqdemo.integration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import static com.accenture.springintegrationrabbitmqdemo.integration.Channels.MUTUAS_QUEUE_NAME;

@Configuration
public class ApiMutuaInboundFlowConfiguration
{
    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private ExampleSubscriberService exampleSubscriberService;

    @Bean
    public Queue worksQueue()
    {
        return QueueBuilder
                .durable(MUTUAS_QUEUE_NAME)
                .build();
    }

    @Bean
    public SimpleMessageListenerContainer workListenerContainer()
    {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(worksQueue());
        container.setConcurrentConsumers(2);
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
