package com.example.springintegrationdemo.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "apiMutuaGateway", defaultRequestChannel = "apiMutuaInputChannel")
public interface ApiMutuaGateway
{
    @Gateway
    public void sendMessage(String message);
}
