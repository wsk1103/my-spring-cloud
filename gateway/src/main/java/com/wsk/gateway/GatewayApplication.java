package com.wsk.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

/*    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/client/**")
                        .filters(f -> f.stripPrefix(1)
                                .filter(new RateLimitByIpGatewayFilter(10, 1, Duration.ofSeconds(1)))
                                )
                        .uri("lb://service-client")
                        .order(0)
                        .id("service-client")
                )
                .build();
    }*/

}
