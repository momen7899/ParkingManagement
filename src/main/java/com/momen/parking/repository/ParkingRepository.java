package com.momen.parking.repository;

import com.momen.parking.model.Parking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ParkingRepository extends PagingAndSortingRepository<Parking, Long> {
    Page<Parking> findAllByVehicle_Id(Long vehicleId, Pageable pageable);

    List<Parking> findAllByVehicle_Id(Long vehicleId);
}
