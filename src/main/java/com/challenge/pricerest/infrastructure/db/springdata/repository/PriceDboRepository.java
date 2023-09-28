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

   private final SpringDataPriceRepository priceRepository;
   private final PriceEntityMapper priceMapper;

   @Override
   public Optional<Price> findPriceMatch(Integer productId, Integer brandId, LocalDateTime applicationDate){
      return priceRepository.findFirstByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                  productId,
                  brandId,
                  applicationDate,
                  applicationDate)
                .map(priceMapper::toDomain);
   }

}
