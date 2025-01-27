package com.challenge.pricerest.infrastructure.rest.spring.mapper;

import org.mapstruct.Mapper;

import com.challenge.pricerest.domain.Price;
import com.challenge.pricerest.infrastructure.rest.spring.dto.PriceDto;

@Mapper (componentModel = "spring")
public interface PriceMapper {

   PriceDto toDto(Price price);

}
