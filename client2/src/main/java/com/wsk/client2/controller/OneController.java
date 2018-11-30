package com.wsk.client2.controller;

import com.wsk.client2.dto.User;
import com.wsk.common.response.BaseResDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WuShukai
 * @version V1.0
 * @description
 * @date 2018/11/30  9:41
 */
@EnableCircuitBreaker
@RestController
public class OneController {
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
