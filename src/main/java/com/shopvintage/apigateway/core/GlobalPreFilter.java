package com.shopvintage.apigateway.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;

@Component
public class GlobalPreFilter implements GlobalFilter {

    private final Logger LOGGER= LoggerFactory.getLogger(GlobalPreFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.info("Global Pre-Filter executed");

        String requestPath = exchange.getRequest().getPath().toString();
        LOGGER.info("Request path = " + requestPath);

        HttpHeaders headers = exchange.getRequest().getHeaders();
        Set<String> headerNames = headers.keySet();

        headerNames.forEach((header) -> {
            LOGGER.info(header + " " + headers.get(header));
        });

        return chain.filter(exchange);
    }
}
