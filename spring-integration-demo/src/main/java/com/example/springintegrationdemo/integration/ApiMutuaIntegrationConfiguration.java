package com.example.springintegrationdemo.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.messaging.MessageChannel;

@Configuration
public class ApiMutuaIntegrationConfiguration
{
    @Autowired
    private ExampleSubscriberService exampleSubscriberService;

    @Bean("apiMutuaInputChannel")
    public MessageChannel apiMutuaInputChannel()
    {
        return
                MessageChannels
                        .direct()
                        .get();
    }

    @Bean("exampleSubscriber")
    public MessageChannel exampleSubscriber()
    {
        return
                MessageChannels
                        .publishSubscribe()
                        .get();
    }

    @Bean("outputQueue")
    public MessageChannel outputQueue()
    {
        return
                MessageChannels
                        .queue()
                        .get();
    }

    @Bean
    public IntegrationFlow apiMutuaIntegrationFlow()
    {
        return IntegrationFlows
                .from(apiMutuaInputChannel())
                .channel(exampleSubscriber())
                .channel(outputQueue())
                .get();
    }

    @Bean
    public IntegrationFlow apiMutuaExampleSubflow()
    {
        return IntegrationFlows
                .from(exampleSubscriber())
                .handle(exampleSubscriberService::handleExampleMessage)
                .get();
    }

    @Bean
    public IntegrationFlow apiMutuaOutputSubflow()
    {
        return IntegrationFlows
                .from(exampleSubscriber())
                .handle(exampleSubscriberService::handleOutputMessage)
                .get();
    }

    @Bean
    public IntegrationFlow apiMutuaOutputQueueSubflow()
    {
        return IntegrationFlows
                .from(outputQueue())
                .handle(exampleSubscriberService::handleOutputQueueMessage,
                        c -> c.poller(Pollers.fixedRate(10_000)))
                .get();
    }
}
