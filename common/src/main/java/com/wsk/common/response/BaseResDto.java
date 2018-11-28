package com.wsk.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WuShukai
 * @version V1.0
 * @description 基础响应类
 * @date 2018/11/26  11:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResDto<T> implements Serializable {

    /**
     * 响应玛
     */
    private int code = 0;

    /**
     * 响应信息
     */
    private String msg = "";

    /**
     * 响应实体
     */
    private T data;
}
