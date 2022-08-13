package com.momen.parking.mapper;


import com.momen.parking.dto.request.ParkingRequestDTO;
import com.momen.parking.dto.response.ParkingResponseDTO;
import com.momen.parking.model.Parking;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ParkingMapper.class})
public interface ParkingMapper {


    //////////////////////// request ////////////////////////
    Parking toParking(ParkingRequestDTO parkingRequestDTO);

    //////////////////////// response ////////////////////////
    ParkingResponseDTO toParkingResponseDto(Parking parking);

    List<ParkingResponseDTO> toParkingResponseDTOList(List<Parking> parkings);

}
