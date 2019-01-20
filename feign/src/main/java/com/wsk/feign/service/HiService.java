package com.wsk.feign.service;

import com.wsk.common.response.BaseResDto;
import com.wsk.feign.dto.User;
import com.wsk.feign.service.impl.HiServiceHystricImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author WuShukai
 * @version V1.0
 * @description 转发
 * @date 2018/11/23  11:26
 */
@FeignClient(value = "service-client",fallback = HiServiceHystricImpl.class)
public interface HiService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String say(@RequestParam(value = "name") String name);

    @GetMapping("user")
    User user(@RequestParam(value = "name") String name);

    @GetMapping("go")
    BaseResDto go(@RequestParam(value = "name") String name);
}
