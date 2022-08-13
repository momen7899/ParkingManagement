package com.momen.parking.service.impl;

import com.momen.parking.common.exception.NotFoundException;
import com.momen.parking.model.PriceRate;
import com.momen.parking.repository.PriceRateRepository;
import com.momen.parking.service.PriceRateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PriceRateServiceImpl implements PriceRateService {

    private PriceRateRepository repository;


    @Override
    public PriceRate addPriceRate(PriceRate priceRate) {
        return repository.save(priceRate);
    }

    @Override
    public PriceRate updatePriceRate(PriceRate priceRate) {
        PriceRate savedBefore = getPriceRate(priceRate.getId());
        savedBefore.setEntry(priceRate.getEntry());
        savedBefore.setHourly(priceRate.getHourly());
        savedBefore.setDaily(priceRate.getDaily());
        savedBefore.setMonthly(priceRate.getMonthly());

        return repository.save(savedBefore);
    }

    @Override
    public void deletePriceRate(Long priceRateId) {
        PriceRate savedBefore = getPriceRate(priceRateId);
        repository.delete(savedBefore);
    }


    @Override
    public PriceRate getPriceRate(Long priceRateId) {
        Optional<PriceRate> optionalPriceRate = repository.findById(priceRateId);
        if (optionalPriceRate.isPresent()) {
            return optionalPriceRate.get();
        }
        throw new NotFoundException("PriceRate not found");
    }

    @Override
    public Page<PriceRate> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
    }

    @Override
    public List<PriceRate> getAll() {
        return (List<PriceRate>) repository.findAll();
    }
}
