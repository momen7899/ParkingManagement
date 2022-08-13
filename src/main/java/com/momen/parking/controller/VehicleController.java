package com.momen.parking.controller;

import com.momen.parking.dto.request.VehicleRequestDTO;
import com.momen.parking.dto.response.VehicleResponseDTO;
import com.momen.parking.mapper.VehicleMapper;
import com.momen.parking.model.Vehicle;
import com.momen.parking.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/vehicle")
@AllArgsConstructor
public class VehicleController {

    private VehicleService service;
    private VehicleMapper mapper;

    @PostMapping
    public VehicleResponseDTO addVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = mapper.toVehicle(vehicleRequestDTO);
        Vehicle saved = service.addVehicle(vehicle);
        return mapper.toVehicleResponseDto(saved);
    }

    @PutMapping
    public VehicleResponseDTO updateVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = mapper.toVehicle(vehicleRequestDTO);
        Vehicle saved = service.updateVehicle(vehicle);
        return mapper.toVehicleResponseDto(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVehicle(@PathVariable Long id) {
        service.deleteVehicle(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<VehicleResponseDTO> getAll() {
        List<Vehicle> saved = service.getAll();
        return mapper.toVehicleResponseDTOList(saved);
    }

    @GetMapping("/{id}")
    public VehicleResponseDTO getVehicle(@PathVariable Long id) {
        Vehicle saved = service.getVehicle(id);
        return mapper.toVehicleResponseDto(saved);
    }

    @GetMapping("/paging/")
    public List<VehicleResponseDTO> paging(
            @RequestParam(name = "page") Integer page
            , @RequestParam(name = "size", defaultValue = "10")
                    Integer size) {
        Page<Vehicle> saved = service.paging(page, size);
        return mapper.toVehicleResponseDTOList(saved.getContent());
    }

}
