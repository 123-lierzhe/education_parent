package com.sjzc.video.util;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther liez
 * @Date 9:40 2020/11/26
 */
@Component
@Data
@ConfigurationProperties(prefix = "aliyun.vod.file")
public class ConstantPropertiesUtil {

    private String keyid;

    private String keysecret;


}
