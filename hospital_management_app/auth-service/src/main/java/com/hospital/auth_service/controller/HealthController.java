package com.hospital.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.auth_service.dto.HealthResponse;
import com.hospital.auth_service.service.HealthService;

@RestController
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }


    @GetMapping("/api/v1/auth/health")
    public HealthResponse health() {

        return healthService.getHealthStatus();
    }
}