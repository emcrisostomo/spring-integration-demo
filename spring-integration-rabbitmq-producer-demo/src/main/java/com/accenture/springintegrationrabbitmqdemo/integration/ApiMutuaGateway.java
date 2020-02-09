package com.accenture.springintegrationrabbitmqdemo.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import static com.accenture.springintegrationrabbitmqdemo.integration.Channels.API_MUTUA_GATEWAY;
import static com.accenture.springintegrationrabbitmqdemo.integration.Channels.API_MUTUA_INPUT_CHANNEL;

@MessagingGateway(name = API_MUTUA_GATEWAY, defaultRequestChannel = API_MUTUA_INPUT_CHANNEL)
public interface ApiMutuaGateway
{
    @Gateway
    public void sendMessage(String message);
}
