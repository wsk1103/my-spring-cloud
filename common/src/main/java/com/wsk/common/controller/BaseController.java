package com.wsk.common.controller;

import com.wsk.common.response.BaseResDto;
import com.wsk.common.response.ErrorResDto;

/**
 * @author WuShukai
 * @version V1.0
 * @description 用于被继承，基础的控制类
 * @date 2018/11/30  16:27
 */
public class BaseController {

    public BaseResDto error(String name) {
        return ErrorResDto.ERROR_RES_DTO.getBase();
    }

}
