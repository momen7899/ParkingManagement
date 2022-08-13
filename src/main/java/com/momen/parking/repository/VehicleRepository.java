package com.momen.parking.repository;

import com.momen.parking.model.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {
}
