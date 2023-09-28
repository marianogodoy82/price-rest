package com.challenge.pricerest.infrastructure.rest.spring.resources;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.pricerest.application.service.PriceService;
import com.challenge.pricerest.infrastructure.rest.spring.dto.PriceDto;
import com.challenge.pricerest.infrastructure.rest.spring.mapper.PriceMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PriceController {

   private final PriceService priceService;
   private final PriceMapper priceMapper;

   @GetMapping("prices/price")
   public ResponseEntity<PriceDto> getPrice(
         @RequestParam Integer productId,
         @RequestParam Integer brandId,
         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
         LocalDateTime applicationDate
         ){
      return priceService.getPrice(productId, brandId, applicationDate)
            .map( price -> new ResponseEntity<>( priceMapper.toDto(price, applicationDate), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }
}
