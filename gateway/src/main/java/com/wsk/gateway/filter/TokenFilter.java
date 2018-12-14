package com.wsk.gateway.filter;

import com.wsk.gateway.config.PropertiesConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author WuShukai
 * @version V1.0
 * @description 全局过滤器，每次的请求都需要带上token
 * @date 2018/12/12  16:55
 */
@Slf4j
@Data
@EnableConfigurationProperties(PropertiesConfig.class)
public class TokenFilter implements GlobalFilter, Ordered {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> all = propertiesConfig.handleUri();
        String uri = exchange.getRequest().getPath().pathWithinApplication().value();
        log.info("访问的url为：{}", uri);
        for (String url : all) {
            //过滤不需要拥有token的连接
            if (uri.startsWith(url)) {
                log.info("不需要拥有token的uri：{}", uri);
                return chain.filter(exchange);
            }
        }
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return -100;
    }
}
