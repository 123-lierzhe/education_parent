package com.sjzc.eduEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther liez
 * @Date 12:45 2020/10/29
 */
@EnableEurekaServer
@SpringBootApplication
public class EduEurekaRegister {
    public static void main(String[] args) {
        SpringApplication.run(EduEurekaRegister.class,args);
    }
}
