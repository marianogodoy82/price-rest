package com.challenge.pricerest.infrastructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challenge.pricerest.application.repository.PriceRepository;
import com.challenge.pricerest.application.service.PriceService;

@Configuration

public class SpringBootServiceConfig {

   @Bean
   public PriceService priceService(PriceRepository priceRepository){
      return new PriceService(priceRepository);
   }
}
