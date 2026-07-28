package com.hospital.auth_service.service.impl;

import com.hospital.auth_service.dto.LoginRequest;
import com.hospital.auth_service.dto.RegisterRequest;
import com.hospital.auth_service.entity.User;
import com.hospital.auth_service.repository.UserRepository;
import com.hospital.auth_service.security.JwtService;
import com.hospital.auth_service.service.AuthService;
import com.hospital.auth_service.dto.AuthResponse;
import com.hospital.auth_service.security.JwtService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @Override
    public String register(RegisterRequest request) {


        if(userRepository.existsByEmail(request.getEmail())) {

            return "Email already exists";

        }


        User user = User.builder()
        .fullName(request.getFullName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role("PATIENT")
        .build();


        userRepository.save(user);


        return "User registered successfully";

    }



    @Override
public AuthResponse login(LoginRequest request) {


    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() ->
                    new RuntimeException("User not found")
            );


    if(!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword())) {

        throw new RuntimeException("Invalid password");

    }


    String token = jwtService.generateToken(user.getEmail());


    return new AuthResponse(
            "Login successful",
            token
    );

}
}