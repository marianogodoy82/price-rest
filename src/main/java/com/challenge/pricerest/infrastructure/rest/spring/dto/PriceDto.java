package com.challenge.pricerest.infrastructure.rest.spring.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
   private Integer productId;
   private Integer brandId;
   private BigDecimal priceList;
   private LocalDateTime applicationDate;
   private BigDecimal price;
}
