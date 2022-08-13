package com.momen.parking.service;

import com.momen.parking.model.Vehicle;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);

    void deleteVehicle(Long vehicleId);

    Vehicle getVehicle(Long vehicleId);

    Page<Vehicle> paging(Integer page, Integer size);

    List<Vehicle> getAll();
}
