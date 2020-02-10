package com.example.springintegrationrabbitmqdemo.controllers;

import com.example.springintegrationrabbitmqdemo.integration.ApiMutuaGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiExample
{
    private static final Logger logger = LoggerFactory.getLogger(ApiExample.class.getName());

    @Autowired
    private ApiMutuaGateway gateway;

    @PostMapping("/create-message")
    public ResponseEntity<Void> createMessage(@RequestParam("message") String message)
    {
        gateway.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
