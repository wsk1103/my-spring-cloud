package com.wsk.client;

import com.wsk.client.dto.User;
import com.wsk.common.response.BaseResDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "skw") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @GetMapping("/user")
    public User user(@RequestParam(value = "name", defaultValue = "skw") String name) {
        return User.builder().name(name).password("test").build();
    }

    @GetMapping("/go")
    public BaseResDto go(@RequestParam(value = "name", defaultValue = "skw") String name) {
        BaseResDto<User> u = new BaseResDto<>();
        u.setMsg("this is a test");
        u.setData(user(name));
        return u;
    }

}
