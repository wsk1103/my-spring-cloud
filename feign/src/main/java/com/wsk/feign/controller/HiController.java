package com.wsk.feign.controller;

import com.wsk.common.response.BaseResDto;
import com.wsk.feign.dto.User;
import com.wsk.feign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WuShukai
 * @version V1.0
 * @description 控制中心
 * @date 2018/11/23  11:27
 */
@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return hiService.say( name );
    }

    @GetMapping("/user")
    public User user(@RequestParam String name) {
        return hiService.user(name);
    }

    @GetMapping("/go")
    public BaseResDto go(@RequestParam String name) {
        BaseResDto<User> dto = hiService.go(name);
        System.out.println(dto.toString());
        return dto;
    }
}
