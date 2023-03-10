package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

//@Configuration
public class FilterConfig {

    //@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/first-service/**")
                        .filters(filter -> filter
                                .addRequestHeader("first-request", "first-request-header")
                                .addResponseHeader("first-respose", "first-respose-header"))
                        .uri("http://192.168.20.12:8081"))

                .route(route -> route.path("/second-service/**")
                        .filters(filter -> filter
                                .addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-respose", "second-respose-header"))
                        .uri("http://192.168.20.12:8082"))
                .build();
    }
}
