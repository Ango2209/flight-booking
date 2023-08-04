package com.nguyenngo.apigateway.filter;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public static final List<String> endpoints = List.of(
            "/api/v1/auth/**",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> endpoints.stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
