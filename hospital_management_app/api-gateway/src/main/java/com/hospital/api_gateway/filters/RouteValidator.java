package com.hospital.api_gateway.filters;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(

            "/api/auth/login",
            "/api/auth/register"

    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri ->
                            request.getURI().getPath().contains(uri));

}