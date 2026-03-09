package com.vishnu.api_gateway.config;

import org.springframework.cloud.gateway.route.*;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.*;


import org.springframework.cloud.gateway.route.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r
                        .path("/api/auth/**")
                        .uri("lb://auth-service"))
                .route("order-service", r -> r
                        .path("/api/orders/**")
                        .uri("lb://order-service"))
                .route("analytics-service", r -> r
                        .path("/api/analytics/**")
                        .uri("lb://analytics-service"))
                .build();
    }
}


