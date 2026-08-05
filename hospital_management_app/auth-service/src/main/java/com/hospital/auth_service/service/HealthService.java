package com.hospital.auth_service.service;

import org.springframework.stereotype.Service;

import com.hospital.auth_service.dto.HealthResponse;

@Service
public class HealthService {

    public HealthResponse getHealthStatus() {

        return new HealthResponse(
                "UP",
                "auth-service",
                "1.0.0"
        );
    }
}