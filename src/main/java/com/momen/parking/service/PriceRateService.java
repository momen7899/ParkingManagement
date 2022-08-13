package com.momen.parking.service;

import com.momen.parking.model.PriceRate;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PriceRateService {
    PriceRate addPriceRate(PriceRate priceRate);

    PriceRate updatePriceRate(PriceRate priceRate);

    void deletePriceRate(Long priceRateId);

    PriceRate getPriceRate(Long priceRateId);

    Page<PriceRate> paging(Integer page, Integer size);

    List<PriceRate> getAll();
}
