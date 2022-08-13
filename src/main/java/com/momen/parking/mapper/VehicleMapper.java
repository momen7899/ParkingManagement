package com.momen.parking.mapper;

import com.momen.parking.dto.request.VehicleRequestDTO;
import com.momen.parking.dto.response.VehicleResponseDTO;
import com.momen.parking.model.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {VehicleMapper.class})
public interface VehicleMapper {

    //////////////////////// request ////////////////////////
    Vehicle toVehicle(VehicleRequestDTO vehicleRequestDTO);

    //////////////////////// response ////////////////////////
    VehicleResponseDTO toVehicleResponseDto(Vehicle vehicle);

    List<VehicleResponseDTO> toVehicleResponseDTOList(List<Vehicle> vehicleResponseDTOS);

}
