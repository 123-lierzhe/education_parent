package com.sjzc.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther liez
 * @Date 17:13 2020/10/29
 */
@SpringBootApplication(scanBasePackages = "com.sjzc")
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class EduCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduCourseApplication.class,args);
    }
}
