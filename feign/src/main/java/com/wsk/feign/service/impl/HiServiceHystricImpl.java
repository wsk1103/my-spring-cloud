package com.wsk.feign.service.impl;

import com.wsk.common.response.BaseResDto;
import com.wsk.common.response.ErrorResDto;
import com.wsk.feign.dto.User;
import com.wsk.feign.service.HiService;
import org.springframework.stereotype.Component;

/**
 * @author WuShukai
 * @version V1.0
 * @description 熔断器，快速失败
 * @date 2018/11/23  14:29
 */
@Component
public class HiServiceHystricImpl implements HiService {

    /**
     * 当访问失败的时候，会快速调用该方法直接返回。
     *
     * @param name 名称
     * @return String
     */
    @Override
    public String say(String name) {
        return "sorry,error:" + name;
    }

    @Override
    public User user(String name) {
        return null;
    }

    @Override
    public BaseResDto go(String name) {
        return ErrorResDto.ERROR_RES_DTO.getBase();
    }
}
