package com.sjzc.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther liez
 * @Date 14:15 2020/12/23
 */
@Data
@Component
@ConfigurationProperties(prefix = "wx.open")
public class PropertiesUtils {

    private String appid;
    private String appsecret;
    private String redirecturl;

    private String sex;
    private String run;
}
