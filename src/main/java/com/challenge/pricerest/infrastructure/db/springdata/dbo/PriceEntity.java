package com.challenge.pricerest.infrastructure.db.springdata.dbo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "prices")
public class PriceEntity {
   @Id
   private Integer id;
   private Integer brandId;
   private LocalDateTime startDate;
   private LocalDateTime endDate;
   private Integer priceList;
   private Integer productId;
   private Integer priority;
   private BigDecimal price;
   private String curr;

}
