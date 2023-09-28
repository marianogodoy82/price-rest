package com.challenge.pricerest.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.challenge.pricerest.application.repository.PriceRepository;
import com.challenge.pricerest.domain.Price;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PriceService {

   private final PriceRepository priceRepository;

   public Optional<Price> getPrice(Integer productId, Integer brandId, LocalDateTime applicationDate) {
      return priceRepository.findPriceMatch(productId, brandId, applicationDate);
   }

}
