package com.sjzc.video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther liez
 * @Date 17:53 2020/11/25
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class EduVideoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduVideoApplication.class);
    }
}
