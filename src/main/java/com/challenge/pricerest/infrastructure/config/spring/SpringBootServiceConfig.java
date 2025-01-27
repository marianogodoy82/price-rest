package com.challenge.pricerest.infrastructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challenge.pricerest.application.repository.PriceRepository;
import com.challenge.pricerest.application.usecase.GetApplicablePriceUseCase;

@Configuration

public class SpringBootServiceConfig {

   @Bean
   public GetApplicablePriceUseCase priceService(PriceRepository priceRepository){
      return new GetApplicablePriceUseCase(priceRepository);
   }
}
