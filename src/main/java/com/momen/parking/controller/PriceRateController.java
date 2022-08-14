package com.momen.parking.controller;

import com.momen.parking.common.PagingData;
import com.momen.parking.dto.request.PriceRateRequestDTO;
import com.momen.parking.dto.response.PriceRateResponseDTO;
import com.momen.parking.dto.response.VehicleResponseDTO;
import com.momen.parking.mapper.PriceRateMapper;
import com.momen.parking.model.PriceRate;
import com.momen.parking.service.PriceRateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/priceRate")
@AllArgsConstructor
public class PriceRateController {

    private PriceRateService service;
    private PriceRateMapper mapper;

    @PostMapping
    public PriceRateResponseDTO addPriceRate(@RequestBody PriceRateRequestDTO priceRateRequestDTO) {
        PriceRate priceRate = mapper.toPriceRate(priceRateRequestDTO);
        PriceRate saved = service.addPriceRate(priceRate);
        return mapper.toPriceRateResponseDto(saved);
    }

    @PutMapping
    public PriceRateResponseDTO updatePriceRate(@RequestBody PriceRateRequestDTO priceRateRequestDTO) {
        PriceRate priceRate = mapper.toPriceRate(priceRateRequestDTO);
        PriceRate saved = service.updatePriceRate(priceRate);
        return mapper.toPriceRateResponseDto(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePriceRate(@PathVariable Long id) {
        service.deletePriceRate(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<PriceRateResponseDTO> getAll() {
        List<PriceRate> saved = service.getAll();
        return mapper.toPriceRateResponseDTOList(saved);
    }

    @GetMapping("/{id}")
    public PriceRateResponseDTO getPriceRate(@PathVariable Long id) {
        PriceRate saved = service.getPriceRate(id);
        return mapper.toPriceRateResponseDto(saved);
    }

    @GetMapping("/paging/")
    public ResponseEntity<PagingData<PriceRateResponseDTO>> paging(
            @RequestParam(name = "page") Integer page
            , @RequestParam(name = "size", defaultValue = "10") Integer size) {
        Page<PriceRate> saved = service.paging(page, size);

        PagingData<PriceRateResponseDTO> pagingData = new PagingData<>(saved.getTotalPages(), page, mapper.toPriceRateResponseDTOList(saved.getContent()));

        return ResponseEntity.ok(pagingData);
    }
}
