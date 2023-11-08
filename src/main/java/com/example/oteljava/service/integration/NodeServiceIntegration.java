package com.example.oteljava.service.integration;

import java.util.Optional;

import org.aspectj.apache.bcel.classfile.Module.Open;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.oteljava.service.integration.client.NodeClient;

@Service
public class NodeServiceIntegration extends IntegrationService {

    private final NodeClient nodeClient;

    public NodeServiceIntegration(NodeClient nodeClient) {
        this.nodeClient = nodeClient;
    }

    public Optional<?> rolldice() {
        return request(() -> nodeClient.rolldice(5), Optional::empty);
    }
    
}
