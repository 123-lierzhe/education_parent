package com.sjzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Auther liez
 * @Date 15:51 2020/12/21
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EduSendMsgApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduSendMsgApplication.class);
    }
}
