package com.challenge.pricerest.infrastructure.db.springdata.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.challenge.pricerest.application.repository.PriceRepository;
import com.challenge.pricerest.domain.Price;
import com.challenge.pricerest.infrastructure.db.springdata.mapper.PriceEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PriceDboRepository implements PriceRepository {

   private final SpringDataPriceRepository springDataPriceRepository;
   private final PriceEntityMapper priceEntityMapper;

   @Override
   public Optional<Price> findApplicablePrice(Integer productId, Integer brandId, LocalDateTime applicationDate){
      return springDataPriceRepository
            .findFirstByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                  productId,
                  brandId,
                  applicationDate,
                  applicationDate)
            .map(priceEntityMapper::toDomain);
   }

}
