package com.sjzc.aliyun.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther liez
 * @Date 16:36 2020/10/15
 */
@Component
@Data
@ConfigurationProperties(prefix = "aliyun.oss.file")
public class AliyunProperties {
    private String endpoint;
    private String keyid;
    private String keysecret;
    private String bucketname;

}
