package com.challenge.pricerest.application.usecase;

import java.time.LocalDateTime;

import com.challenge.pricerest.application.repository.PriceRepository;
import com.challenge.pricerest.domain.Price;
import com.challenge.pricerest.infrastructure.exception.PriceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GetApplicablePriceUseCase {
   private final PriceRepository priceRepository;

   public Price execute(Integer productId, Integer brandId, LocalDateTime applicationDate) {
      return priceRepository.findApplicablePrice(productId, brandId, applicationDate)
            .orElseThrow( () -> {
               log.error("Price not found for productId: {}, brandId: {}, applicationDate: {}", productId, brandId, applicationDate);
               return new PriceNotFoundException("Price not found");
            });
   }

}
