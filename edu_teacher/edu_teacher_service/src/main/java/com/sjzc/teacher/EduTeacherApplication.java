package com.sjzc.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther liez
 * @Date 10:03 2020/10/9
 */
//scanBasePackages的作用是为了加载启动类是扫描com.sjzc下的下的所有文件并进行加载
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.sjzc")
public class EduTeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduTeacherApplication.class,args);
    }
}
