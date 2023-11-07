package com.example.oteljava.service.integration.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "NodeClient", url = "localhost:8080", decode404 = true)
public interface NodeClient {

    @GetMapping("/rolldice")
    Optional<ResponseEntity> rolldice(@RequestParam("rolls") Integer rolls);
    
}
