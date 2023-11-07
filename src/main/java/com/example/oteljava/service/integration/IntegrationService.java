package com.example.oteljava.service.integration;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import feign.FeignException;

public class IntegrationService {

    protected static final Logger LOGGER = LoggerFactory.getLogger(IntegrationService.class);

    <R> R request(Supplier<R> requestHandler, Supplier<R> fallbackSupplier) {
        try {
            return requestHandler.get();
        }
        catch (final FeignException e) {
            LOGGER.error("Failed request with status:" + e.status() +". Message: " + e.getLocalizedMessage());
        }
        catch (final Exception e) {
            LOGGER.error(e.getMessage());
        }
        return fallbackSupplier.get();
    }

    void request(Runnable request) {
        try {
            request.run();
        }
        catch (final FeignException e) {
            LOGGER.error("Failed request with status:" + e.status() +". Message: " + e.getLocalizedMessage());
        }
        catch (final Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
    
}
