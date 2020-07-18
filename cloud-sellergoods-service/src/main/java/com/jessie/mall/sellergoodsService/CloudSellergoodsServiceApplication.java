package com.jessie.mall.sellergoodsService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.jessie.mall.sellergoodsService.mapper")
@EnableFeignClients
@EnableEurekaClient
public class CloudSellergoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSellergoodsServiceApplication.class, args);
    }

}
