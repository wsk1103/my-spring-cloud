package com.wsk.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WuShukai
 * @version V1.0
 * @description 用户返回实体
 * @date 2018/11/25  20:54
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String password;
}
