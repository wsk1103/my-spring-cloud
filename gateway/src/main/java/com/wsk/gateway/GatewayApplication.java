package com.wsk.gateway;

import com.wsk.gateway.resolver.RemoteAddrKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * 自定义过滤器
     */
/*    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/client/**")
                        .filters(f -> f.stripPrefix(1)
                                .filter(new SkyRateLimitByIpGatewayFilterFactory(10, 1, Duration.ofSeconds(1)))
                                //多个过滤器的时候，可以继续构造下去
                        )
                        .uri("lb://service-client")
                        .order(0)
                        .id("service-client")
                )
                .build();
    }*/


    /**
     * gateway内置限流工具
     *
     * @return RemoteAddrKeyResolver
     */
    @Bean(name = RemoteAddrKeyResolver.BEAN_NAME)
    public RemoteAddrKeyResolver remoteAddrKeyResolver() {
        return new RemoteAddrKeyResolver();
    }

}
