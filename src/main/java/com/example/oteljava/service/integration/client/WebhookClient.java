package com.example.oteljava.service.integration.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "WebhookClient", url = "${webhook.url}", decode404 = true)
public interface WebhookClient {

    @GetMapping("/test")
    Optional<?> test();
    
}
