package com.wsk.feign.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author WuShukai
 * @version V1.0
 * @description 用户类
 * @date 2018/11/25  20:54
 */
@Data
@Builder
public class User {
    private String name;
    private String password;
}
