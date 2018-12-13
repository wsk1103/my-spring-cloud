package com.wsk.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wsk.client.dto.User;
import com.wsk.common.controller.BaseController;
import com.wsk.common.response.BaseResDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author WuShukai
 * @version V1.0
 * @description
 * @date 2018/11/30  9:41
 */
@RestController
public class OneController extends BaseController {


/*    @GetMapping("/user")
    @HystrixCommand(fallbackMethod = "error")
    public User user(@RequestParam(value = "name", defaultValue = "skw") String name) {
        return User.builder().name(name).password("test").build();
    }*/

    @Value("${server.port}")
    String port;

    @GetMapping("/go")
    @HystrixCommand(fallbackMethod = "error")
    public BaseResDto go(@RequestParam(value = "name", defaultValue = "skw") String name) {
        BaseResDto<User> u = new BaseResDto<>();
        u.setMsg("this is a go:" + port);
        u.setData(new User());
        return u;
    }

    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "error")
    public BaseResDto say(@RequestParam(value = "name", defaultValue = "skw") String name) {
        BaseResDto<User> u = new BaseResDto<>();
        u.setMsg("this is a hi:" + port);
        u.setData(new User());
        return u;
    }

    @GetMapping("/sky/histrix")
    public BaseResDto myHistrix(@RequestParam(value = "name", defaultValue = "true") boolean name) throws InterruptedException {
        if (name) {
            TimeUnit.SECONDS.sleep(10);
        }
        BaseResDto<User> u = new BaseResDto<>();
        u.setMsg("this is a hi:" + port);
        u.setData(new User());
        return u;
    }
}
