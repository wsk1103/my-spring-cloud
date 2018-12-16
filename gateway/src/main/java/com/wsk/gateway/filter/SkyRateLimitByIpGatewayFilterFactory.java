package com.wsk.gateway.filter;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author WuShukai
 * @version V1.0
 * @description 基于令牌桶的限流过滤器，必须继承AbstractGatewayFilterFactory或者实现GatewayFilterFactory
 * @date 2018/12/12  17:12
 */
@Builder
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class SkyRateLimitByIpGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory implements GatewayFilter, Ordered {

    /**
     * 桶的最大容量，即能装载 Token 的最大数量
     */
    private int capacity;

    /**
     * 每次 Token 补充量
     */
    private int refillTokens;

    /**
     * 补充 Token 的时间间隔
     */
    private Duration refillDuration;

    private static final Map<String, Bucket> CACHE = new ConcurrentHashMap<>();

    private Bucket createNewBucket() {
        Refill refill = Refill.greedy(refillTokens, refillDuration);
        Bandwidth limit = Bandwidth.classic(capacity, refill);
        return Bucket4j.builder().addLimit(limit).build();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String ip = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        Bucket bucket = CACHE.computeIfAbsent(ip, k -> createNewBucket());

        log.info("IP: " + ip + ", TokenBucket Available Tokens: " + bucket.getAvailableTokens());
        if (bucket.tryConsume(1)) {
            return chain.filter(exchange);
        } else {
            //请求太多，服务器之间返回 TOO_MANY_REQUESTS 429
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return -1000;
    }

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        //开启限流
        if ("open".equals(config.getName())) {
            return this;
        }
        return (exchange, chain) -> chain.filter(exchange);
    }
}
