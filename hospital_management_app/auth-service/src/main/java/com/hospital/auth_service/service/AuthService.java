package com.hospital.auth_service.service;

import com.hospital.auth_service.dto.AuthResponse;
import com.hospital.auth_service.dto.LoginRequest;
import com.hospital.auth_service.dto.RegisterRequest;


public interface AuthService {

    String register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}