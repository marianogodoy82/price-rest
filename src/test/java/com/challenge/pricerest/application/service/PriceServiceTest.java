package com.challenge.pricerest.application.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.challenge.pricerest.application.repository.PriceRepository;
import com.challenge.pricerest.domain.Price;

class PriceServiceTest {
   private PriceRepository priceRepository;
   private PriceService tested;

   @BeforeEach
   void setUp() {
      priceRepository = mock(PriceRepository.class);
      tested = new PriceService(priceRepository);
   }
   @Test
   void shouldFindPrice_thenRetrieveIt() {
      final Price price = Price.builder()
            .brandId(1)
            .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 10, 0))
            .endDate(LocalDateTime.of(2020, Month.JUNE, 14, 10, 0))
            .priceList(1)
            .productId(1)
            .priority(1)
            .price(BigDecimal.valueOf(5.5))
            .curr("aCurr")
            .build();

      when(priceRepository.findPriceMatch(anyInt(), anyInt(), any(LocalDateTime.class))).thenReturn(Optional.of(price));

      final Optional<Price> price1 = tested.getPrice(35455, 1, LocalDateTime.of(2020, Month.JUNE, 14, 10, 0));

      verify(priceRepository).findPriceMatch(35455, 1, LocalDateTime.of(2020, Month.JUNE, 14, 10, 0));
      assertNotNull(price1.orElseThrow());
   }
}
