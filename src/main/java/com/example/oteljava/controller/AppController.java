package com.example.oteljava.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oteljava.service.integration.IntegrationService;
import com.example.oteljava.service.integration.NodeServiceIntegration;
import com.example.oteljava.service.integration.WebhookService;

@RestController
public class AppController {

    protected static final Logger LOGGER = LoggerFactory.getLogger(IntegrationService.class);

    private final NodeServiceIntegration nodeServiceIntegration;
    private final WebhookService webhookService;

    public AppController(NodeServiceIntegration nodeServiceIntegration, WebhookService webhookService) {
        this.nodeServiceIntegration = nodeServiceIntegration;
        this.webhookService = webhookService;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping(name = "GET dice", path = "/dice")
    public ResponseEntity dice() {
        LOGGER.info("GET dice - Received request");
        return nodeServiceIntegration.rolldice()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping(name="test", path = "/test")
    public ResponseEntity test() {
        LOGGER.info("GET test - Received request");
        return webhookService.test()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
    
}
