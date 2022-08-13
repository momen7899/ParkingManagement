package com.momen.parking.mapper;

import com.momen.parking.dto.request.PriceRateRequestDTO;
import com.momen.parking.dto.response.PriceRateResponseDTO;
import com.momen.parking.model.PriceRate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PriceRateMapper.class})
public interface PriceRateMapper {

    //////////////////////// request ////////////////////////
    PriceRate toPriceRate(PriceRateRequestDTO priceRateRequestDTO);

    //////////////////////// response ////////////////////////
    PriceRateResponseDTO toPriceRateResponseDto(PriceRate vehicle);

    List<PriceRateResponseDTO> toPriceRateResponseDTOList(List<PriceRate> priceRates);


}
