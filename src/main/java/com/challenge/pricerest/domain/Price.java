package com.challenge.pricerest.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;


@Builder
public record Price(
   Integer productId,
   Integer brandId,
   Integer priceList,
   LocalDateTime endDate,
   LocalDateTime startDate,
   Integer priority,
   BigDecimal price,
   String curr
) {}
