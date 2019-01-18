package com.wsk.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wsk1103
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@RestController
//@EnableHystrix
//@EnableHystrixDashboard
//@EnableCircuitBreaker
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

//    @Autowired
//    private RestTemplate restTemplate;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
//    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(value = "name", defaultValue = "sky") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
