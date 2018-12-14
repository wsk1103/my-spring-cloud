package com.wsk.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

/**
 * @author WuShukai
 * @version V1.0
 * @description 读取自定义的properties
 * @date 2018/12/14  11:17
 */

@Configuration
@ConfigurationProperties(prefix = "gateway.filter")
@PropertySource("classpath:/gateway-filter-uri.properties")
@Data
public class PropertiesConfig {

    private String uri;

    public List<String> handleUri() {
        return Arrays.asList(uri.split(","));
    }
}
