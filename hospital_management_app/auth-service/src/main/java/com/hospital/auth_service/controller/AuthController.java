package com.hospital.auth_service.controller;

import com.hospital.auth_service.dto.AuthResponse;
import com.hospital.auth_service.dto.LoginRequest;
import com.hospital.auth_service.dto.RegisterRequest;
import com.hospital.auth_service.service.AuthService;
import com.hospital.auth_service.dto.AuthResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request) {


        String response = authService.register(request);

        return ResponseEntity.ok(response);

    }



    @PostMapping("/login")
public ResponseEntity<AuthResponse> login(
        @RequestBody LoginRequest request) {


    AuthResponse response = authService.login(request);

    return ResponseEntity.ok(response);

}

}