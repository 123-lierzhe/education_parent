package com.sjzc.aliyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Auther liez
 * @Date 15:40 2020/10/15
 */

@SpringBootApplication(scanBasePackages = "com.sjzc",exclude = DataSourceAutoConfiguration.class)
public class AliyunUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(AliyunUploadApplication.class,args);
    }
}
