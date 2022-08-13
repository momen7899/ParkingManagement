package com.momen.parking.repository;

import com.momen.parking.model.PriceRate;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PriceRateRepository extends PagingAndSortingRepository<PriceRate, Long> {
}
