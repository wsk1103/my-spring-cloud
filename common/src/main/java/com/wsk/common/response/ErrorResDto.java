package com.wsk.common.response;

import java.io.Serializable;

/**
 * @author WuShukai
 * @version V1.0
 * @description
 * @date 2018/11/26  11:32
 */
public enum  ErrorResDto implements Serializable {

    /**
     * 错误信息
     */
    ERROR_RES_DTO(BaseResDto.builder().code(1001).msg("error").build());

    private BaseResDto base;

    ErrorResDto(BaseResDto base) {
        this.base = base;
    }

    public BaseResDto getBase() {
        return this.base;
    }

}
