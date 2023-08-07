package com.faith.gateway.fiter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @author:faith
 * @time:2023/5/1610:04
 */
@Component
@Order(-1)
public class AuthorizeFliter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求参数
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        //获取authorization参数
        String authorization = queryParams.getFirst("authorization");
        //校验
        if (authorization.equals("admin")){
            //放行
            return chain.filter(exchange);
        }
        //拦截禁止访问
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        return exchange.getResponse().setComplete();
    }
}
