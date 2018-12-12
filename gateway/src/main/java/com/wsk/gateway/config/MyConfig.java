package com.wsk.gateway.config;

import com.wsk.gateway.filter.ElapsedGatewayFilterFactory;
import com.wsk.gateway.filter.RateLimitByIpGatewayFilter;
import com.wsk.gateway.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @author WuShukai
 * @version V1.0
 * @description
 * @date 2018/12/12  16:56
 */
@Configuration
public class MyConfig {
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
    @Bean
    public ElapsedGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new ElapsedGatewayFilterFactory();
    }
    @Bean
    public RateLimitByIpGatewayFilter rateLimitByIpGatewayFilter() {
        return new RateLimitByIpGatewayFilter(10, 1, Duration.ofSeconds(1));
    }

}
