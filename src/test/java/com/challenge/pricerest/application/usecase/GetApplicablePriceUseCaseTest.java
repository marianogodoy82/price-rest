package com.challenge.pricerest.application.usecase;

import static java.time.Month.JUNE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.challenge.pricerest.application.repository.PriceRepository;
import com.challenge.pricerest.domain.Price;
import com.challenge.pricerest.infrastructure.exception.PriceNotFoundException;

class GetApplicablePriceUseCaseTest {
   private PriceRepository priceRepository;
   private GetApplicablePriceUseCase tested;

   @BeforeEach
   void setUp() {
      priceRepository = mock(PriceRepository.class);
      tested = new GetApplicablePriceUseCase(priceRepository);
   }

   @Test
   void shouldFindPrice_thenRetrieveIt() {
      final Price price = Price.builder()
            .brandId(1)
            .startDate(LocalDateTime.of(2020, JUNE, 14, 10, 0))
            .endDate(LocalDateTime.of(2020, JUNE, 14, 10, 0))
            .priceList(1)
            .productId(1)
            .priority(1)
            .price(BigDecimal.valueOf(5.5))
            .curr("aCurr")
            .build();

      when(priceRepository.findApplicablePrice(anyInt(), anyInt(), any(LocalDateTime.class))).thenReturn(Optional.of(price));

      final Price priceResult = tested.execute(35455, 1, LocalDateTime.of(2020, JUNE, 14, 10, 0));

      verify(priceRepository, times(1)).findApplicablePrice(35455, 1, LocalDateTime.of(2020, JUNE, 14, 10, 0));
      assertNotNull(priceResult);
      assertEquals(BigDecimal.valueOf(5.5), priceResult.price());
   }

   @Test
   void shouldFindPrice_thenThrowPriceNotFoundException() {

      when(priceRepository.findApplicablePrice(anyInt(), anyInt(), any(LocalDateTime.class))).thenReturn(Optional.empty());

      final PriceNotFoundException exception = assertThrows(PriceNotFoundException.class,
            () -> tested.execute(35455, 1, LocalDateTime.of(2020, JUNE, 14, 10, 0)));

      assertEquals("Price not found", exception.getMessage());
      verify(priceRepository, times(1)). findApplicablePrice(anyInt(), anyInt(), any(LocalDateTime.class));
   }
}
