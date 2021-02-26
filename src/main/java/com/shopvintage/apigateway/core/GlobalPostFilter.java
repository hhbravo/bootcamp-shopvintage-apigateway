package com.shopvintage.apigateway.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpHeaders;
import java.util.Optional;

@Component
public class GlobalPostFilter implements GlobalFilter {
    private final Logger LOGGER = LoggerFactory.getLogger(GlobalPostFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return chain
                .filter(exchange)
                .then(Mono.fromRunnable(() -> {

                    LOGGER.info("Global Post-filter executed...");

                    ServerHttpResponse response = exchange.getResponse();

                    response.getHeaders()
                            .add("custom-header-gateway-key", "12345");

                    response.getHeaders()
                            .add("x-auth-token","12334asdads");


                }));
    }
}
