package com.challenge.pricerest.infrastructure.rest.spring.resources;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.pricerest.application.usecase.GetApplicablePriceUseCase;
import com.challenge.pricerest.infrastructure.rest.spring.dto.PriceDto;
import com.challenge.pricerest.infrastructure.rest.spring.mapper.PriceMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/price")
public class PriceController {
   private final GetApplicablePriceUseCase getApplicablePriceUseCase;
   private final PriceMapper priceMapper;

   @GetMapping
   public PriceDto getPrice(
         @RequestParam Integer productId,
         @RequestParam Integer brandId,
         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate ){
      return priceMapper.toDto( getApplicablePriceUseCase.execute(productId, brandId, applicationDate ));
   }
}
