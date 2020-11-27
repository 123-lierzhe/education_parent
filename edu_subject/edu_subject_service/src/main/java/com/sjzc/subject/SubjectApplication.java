package com.sjzc.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther liez
 * @Date 10:51 2020/10/19
 */
//@EnableEurekaClient
//@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.sjzc")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class,args);
    }
}
