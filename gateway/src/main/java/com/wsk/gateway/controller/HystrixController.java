package com.wsk.gateway.controller;

import com.wsk.common.response.BaseResDto;
import com.wsk.common.response.ErrorResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WuShukai
 * @version V1.0
 * @description
 * @date 2018/12/13  11:33
 */
@RestController
@Slf4j
public class HystrixController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/fallback")
    public BaseResDto fallback() {
        return ErrorResDto.ERROR_RES_DTO.getBase();
    }

}
