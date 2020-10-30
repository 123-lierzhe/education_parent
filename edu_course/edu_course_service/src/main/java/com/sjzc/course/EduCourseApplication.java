package com.sjzc.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther liez
 * @Date 17:13 2020/10/29
 */
@SpringBootApplication(scanBasePackages = "com.sjzc")
@EnableEurekaClient
public class EduCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduCourseApplication.class,args);
    }
}
