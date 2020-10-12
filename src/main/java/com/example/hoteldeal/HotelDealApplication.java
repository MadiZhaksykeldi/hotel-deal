package com.example.hoteldeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelDealApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelDealApplication.class, args);
    }
}