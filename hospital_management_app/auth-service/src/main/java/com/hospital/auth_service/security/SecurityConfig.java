package com.hospital.auth_service.security;


import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {


    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {


        http
            // Disable CSRF for REST APIs
            .csrf(csrf -> csrf.disable())


            // API authorization rules
            .authorizeHttpRequests(auth -> auth

                    // Public APIs
                    .requestMatchers("/api/auth/**").permitAll()

                    // Protected APIs
                    .anyRequest().authenticated()
            )


            // Add JWT filter before Spring security authentication filter
            .addFilterBefore(
                    jwtAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class
            );


        return http.build();
    }

}