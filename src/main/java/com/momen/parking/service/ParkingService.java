package com.momen.parking.service;

import com.momen.parking.model.Parking;
import com.momen.parking.model.Vehicle;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ParkingService {

    Parking addParking(Parking parking);

    Parking leaveParking(Parking parking);

    void deleteParking(Long parkingId);

    Parking getParking(Long parkingId);

    Page<Parking> paging(Integer page, Integer size);

    List<Parking> getAll();

    Parking confirmPayment(Long parkingId);

    List<Parking> vehicleTrafficReport(Vehicle vehicle);

    Page<Parking> pagingVehicleTrafficReport(Integer page, Integer size, Vehicle vehicle);
}
