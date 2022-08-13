package com.momen.parking.controller;

import com.momen.parking.dto.request.ParkingRequestDTO;
import com.momen.parking.dto.request.VehicleRequestDTO;
import com.momen.parking.dto.response.ParkingResponseDTO;
import com.momen.parking.dto.response.VehicleResponseDTO;
import com.momen.parking.mapper.ParkingMapper;
import com.momen.parking.mapper.VehicleMapper;
import com.momen.parking.model.Parking;
import com.momen.parking.model.Vehicle;
import com.momen.parking.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/parking")
@AllArgsConstructor
public class ParkingController {

    private ParkingService service;
    private ParkingMapper mapper;
    private VehicleMapper vehicleMapper;


    @PostMapping
    public ParkingResponseDTO addParking(@RequestBody ParkingRequestDTO parkingRequestDTO) {
        Parking parking = mapper.toParking(parkingRequestDTO);
        Parking saved = service.addParking(parking);
        return mapper.toParkingResponseDto(saved);
    }

    @PutMapping
    public ParkingResponseDTO updateParking(@RequestBody ParkingRequestDTO parkingRequestDTO) {
        Parking parking = mapper.toParking(parkingRequestDTO);
        Parking saved = service.updateParking(parking);
        return mapper.toParkingResponseDto(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParking(@PathVariable Long id) {
        service.deleteParking(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ParkingResponseDTO> getAll() {
        List<Parking> saved = service.getAll();
        return mapper.toParkingResponseDTOList(saved);
    }

    @GetMapping("/{id}")
    public ParkingResponseDTO getParking(@PathVariable Long id) {
        Parking saved = service.getParking(id);
        return mapper.toParkingResponseDto(saved);
    }

    @GetMapping("/paging/")
    public List<ParkingResponseDTO> paging(
            @RequestParam(name = "page") Integer page
            , @RequestParam(name = "size", defaultValue = "10")
                    Integer size) {
        Page<Parking> saved = service.paging(page, size);
        return mapper.toParkingResponseDTOList(saved.getContent());
    }

    @PostMapping("/registration/{id}")
    public ParkingResponseDTO vehicleRegistration(@PathVariable Long id) {
        Parking saved = service.vehicleRegistration(id);
        return mapper.toParkingResponseDto(saved);
    }

    @PostMapping("/leave/{id}")
    public ParkingResponseDTO leaveVehicle(@PathVariable Long id) {
        Parking saved = service.leaveVehicle(id);
        return mapper.toParkingResponseDto(saved);
    }

    @PostMapping("/calculate/{id}")
    public ParkingResponseDTO calculatePrice(@PathVariable Long id) {
        Parking saved = service.calculatePrice(id);
        return mapper.toParkingResponseDto(saved);
    }

    @PostMapping("/confirmPayment/{id}")
    public ParkingResponseDTO confirmPayment(@PathVariable Long id) {
        Parking saved = service.confirmPayment(id);
        return mapper.toParkingResponseDto(saved);
    }

    @GetMapping("vehicle/")
    public List<ParkingResponseDTO> vehicleTrafficReport(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleRequestDTO);
        List<Parking> saved = service.vehicleTrafficReport(vehicle);
        return mapper.toParkingResponseDTOList(saved);
    }

    @GetMapping("/vehicle/paging/")
    public List<ParkingResponseDTO> paging(
            @RequestBody VehicleRequestDTO vehicleRequestDTO,
            @RequestParam(name = "page") Integer page
            , @RequestParam(name = "size", defaultValue = "10") Integer size) {

        Vehicle vehicle = vehicleMapper.toVehicle(vehicleRequestDTO);
        Page<Parking> saved = service.pagingVehicleTrafficReport(page, size, vehicle);
        return mapper.toParkingResponseDTOList(saved.getContent());
    }


}
