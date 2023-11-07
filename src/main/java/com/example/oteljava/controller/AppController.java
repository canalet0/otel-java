package com.example.oteljava.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oteljava.service.integration.NodeServiceIntegration;

@RestController
public class AppController {

    private final NodeServiceIntegration nodeServiceIntegration;

    public AppController(NodeServiceIntegration nodeServiceIntegration) {
        this.nodeServiceIntegration = nodeServiceIntegration;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/dice")
    public ResponseEntity dice() {
        return nodeServiceIntegration.rolldice().orElseGet(ResponseEntity.notFound()::build);
    }
    
}
