package com.wsk.gateway.config;

import lombok.Data;

/**
 * @author WuShukai
 * @version V1.0
 * @description
 * @date 2018/12/12  18:28
 */
@Data
public class Config {
    private boolean withParams;

    public boolean isWithParams() {
        return withParams;
    }

    public void setWithParams(boolean withParams) {
        this.withParams = withParams;
    }
}
