package com.jessie.mall.registercenter01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudRegisterCenter01Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudRegisterCenter01Application.class, args);
    }

}
