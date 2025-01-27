package com.challenge.pricerest.application.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.challenge.pricerest.domain.Price;

public interface PriceRepository {

   Optional<Price> findApplicablePrice(Integer productId, Integer brandId, LocalDateTime applicationDate);

}
