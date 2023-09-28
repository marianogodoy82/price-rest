package com.challenge.pricerest.infrastructure.db.springdata.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.pricerest.infrastructure.db.springdata.dbo.PriceEntity;

@Repository
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Integer> {

   Optional<PriceEntity> findFirstByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
         Integer productId,
         Integer brandId,
         LocalDateTime applicationDate,
         LocalDateTime date);
}
