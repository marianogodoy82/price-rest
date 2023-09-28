package com.challenge.pricerest.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {

   private Integer brandId;
   private LocalDateTime startDate;
   private LocalDateTime endDate;
   private Integer priceList;
   private Integer productId;
   private Integer priority;
   private BigDecimal price;
   private String curr;
}
