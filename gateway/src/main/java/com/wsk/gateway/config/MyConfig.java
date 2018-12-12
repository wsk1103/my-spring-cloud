package com.wsk.gateway.config;

import com.wsk.gateway.filter.ElapsedGatewayFilterFactory;
import com.wsk.gateway.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
