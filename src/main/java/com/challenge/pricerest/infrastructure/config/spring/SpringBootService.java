package com.challenge.pricerest.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.challenge.pricerest.infrastructure")
@EntityScan(basePackages = "com.challenge.pricerest.domain")
public class SpringBootService {

   public static void main(String[] args) {
      SpringApplication.run(SpringBootService.class, args);
   }
}
