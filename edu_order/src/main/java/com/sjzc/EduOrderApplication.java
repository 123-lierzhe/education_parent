package com.sjzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther liez
 * @Date 16:15 2020/12/24
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EduOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduOrderApplication.class);
    }
}
