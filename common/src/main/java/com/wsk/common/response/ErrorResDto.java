package com.wsk.common.response;

import java.io.Serializable;


/**
 * @author WuShukai
 * @version V1.0
 * @description
 * @date 2018/11/30  16:32
 */
public enum  ErrorResDto implements Serializable {

    /**
     * 错误信息
     */
    ERROR_RES_DTO(BaseResDto.builder().code(1001).msg("ERROR").build()),

    /**
     * 熔断
     */
    ERROR_FAIL_BACK(BaseResDto.builder().code(1009).msg("FAIL_BACK").build());

    private BaseResDto base;

    ErrorResDto(BaseResDto base) {
        this.base = base;
    }

    public BaseResDto getBase() {
        return this.base;
    }

}