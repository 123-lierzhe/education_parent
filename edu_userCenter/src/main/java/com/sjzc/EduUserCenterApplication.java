package com.sjzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther liez
 * @Date 17:17 2020/12/22
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EduUserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduUserCenterApplication.class);
    }
}
