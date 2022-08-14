package com.momen.parking.service.impl;

import com.momen.parking.common.exception.NotFoundException;
import com.momen.parking.model.Vehicle;
import com.momen.parking.repository.VehicleRepository;
import com.momen.parking.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    VehicleRepository repository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        Vehicle savedVehicle = getVehicle(vehicle.getId());
        savedVehicle.setVehicleType(vehicle.getVehicleType());
        savedVehicle.setPlaque(vehicle.getPlaque());
        return repository.save(savedVehicle);
    }

    @Override
    public void deleteVehicle(Long vehicleId) {
        Vehicle vehicle = getVehicle(vehicleId);
        repository.delete(vehicle);
    }

    @Override
    public Vehicle getVehicle(Long vehicleId) {
        Optional<Vehicle> optionalVehicle = repository.findById(vehicleId);
        if (optionalVehicle.isPresent()) {
            return optionalVehicle.get();
        }
        throw new NotFoundException("vehicle not found");
    }

    @Override
    public Page<Vehicle> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
    }

    @Override
    public List<Vehicle> getAll() {
        return (List<Vehicle>) repository.findAll();
    }


}
