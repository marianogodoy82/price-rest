package com.challenge.pricerest.infrastructure.db.springdata.dbo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "prices")
public class PriceEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "BRAND_ID", nullable = false)
   private Integer brandId;
   @Column(name = "START_DATE", nullable = false)
   private LocalDateTime startDate;
   @Column(name = "END_DATE", nullable = false)
   private LocalDateTime endDate;
   @Column(name = "PRICE_LIST", nullable = false)
   private Integer priceList;
   @Column(name = "PRODUCT_ID", nullable = false)
   private Integer productId;
   @Column(name = "PRIORITY", nullable = false)
   private Integer priority;
   @Column(name = "PRICE", nullable = false)
   private BigDecimal price;
   @Column(name = "CURR", nullable = false)
   private String currenc;

}

