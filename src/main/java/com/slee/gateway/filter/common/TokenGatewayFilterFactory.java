package com.slee.gateway.filter.common;

import com.slee.gateway.handler.JwtTokenHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    private final JwtTokenHandler tokenHandler;

    public TokenGatewayFilterFactory(JwtTokenHandler tokenHandler) {
        super(TokenGatewayFilterFactory.Config.class);
        this.tokenHandler = tokenHandler;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest serverHttpRequest = exchange.getRequest();
            ServerHttpResponse serverHttpResponse = exchange.getResponse();

            serverHttpRequest.mutate().header(
                    TokenConstants.HEADER_AUTH_TOKEN_KEY,
                    TokenConstants.HEADER_BEARER_VALUE + tokenHandler.getTokenByKey(config.getKey()))
                    .build();

            if (config.isPreLogger()) {
                log.info("TokenGatewayFilterFactory, " + config.getBaseMessage() + " Start!!!");
                log.info("TokenGatewayFilterFactory, " + serverHttpRequest.getPath());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    log.info("TokenGatewayFilterFactory, " + config.getBaseMessage() + ", " + serverHttpResponse.getStatusCode() +" End!!!");
                }
            }));
        };
    }

    @Data
    public static class Config {
        private String key;
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
