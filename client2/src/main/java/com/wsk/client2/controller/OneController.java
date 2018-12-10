package com.wsk.client2.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wsk.client2.dto.User;
import com.wsk.common.controller.BaseController;
import com.wsk.common.response.BaseResDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/go")
    @HystrixCommand(fallbackMethod = "error")
    public BaseResDto go(@RequestParam(value = "name", defaultValue = "skw") String name) {
        BaseResDto<User> u = new BaseResDto<>();
        u.setMsg("this is a test");
        u.setData(new User());
        return u;
    }

    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "error")
    public BaseResDto say(@RequestParam(value = "name", defaultValue = "skw") String name) {
        BaseResDto<User> u = new BaseResDto<>();
        u.setMsg("this is a hi");
        u.setData(new User());
        return u;
    }
}
