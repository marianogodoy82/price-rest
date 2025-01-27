package com.challenge.pricerest.infrastructure.db.springdata.mapper;


import org.mapstruct.Mapper;

import com.challenge.pricerest.domain.Price;
import com.challenge.pricerest.infrastructure.db.springdata.dbo.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

   Price toDomain(PriceEntity priceEntity);

}
