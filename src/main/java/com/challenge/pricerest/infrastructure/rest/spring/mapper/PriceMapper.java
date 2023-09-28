package com.challenge.pricerest.infrastructure.rest.spring.mapper;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;

import com.challenge.pricerest.domain.Price;
import com.challenge.pricerest.infrastructure.rest.spring.dto.PriceDto;

@Mapper (componentModel = "spring")
public interface PriceMapper {

   PriceDto toDto(Price price, LocalDateTime applicationDate);

   Price toDomain(PriceDto priceDto);
}
