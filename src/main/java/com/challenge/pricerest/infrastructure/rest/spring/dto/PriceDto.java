package com.challenge.pricerest.infrastructure.rest.spring.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;


@Builder
public record PriceDto (
   Integer productId,
   Integer brandId,
   BigDecimal priceList,
   LocalDateTime startDate,
   LocalDateTime endDate,
   BigDecimal price
) {}
