package com.example.oteljava.service.integration;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.oteljava.service.integration.client.WebhookClient;

@Service
public class WebhookService extends IntegrationService {

    private final WebhookClient webhookClient;

    public WebhookService(WebhookClient webhookClient) {
        this.webhookClient = webhookClient;
    }

    public Optional<?> test() {
        return request(() -> webhookClient.test(), Optional::empty);
    }
    
}
