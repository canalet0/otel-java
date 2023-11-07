package com.example.oteljava.service.integration;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.oteljava.service.integration.client.NodeClient;

@Service
public class NodeServiceIntegration extends IntegrationService {

    private final NodeClient nodeClient;

    public NodeServiceIntegration(NodeClient nodeClient) {
        this.nodeClient = nodeClient;
    }

    public Optional<ResponseEntity> rolldice() {
        return request(() -> nodeClient.rolldice(), Optional::empty);
    }
    
}
