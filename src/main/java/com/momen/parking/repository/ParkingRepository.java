package com.momen.parking.repository;

import com.momen.parking.model.Parking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ParkingRepository extends PagingAndSortingRepository<Parking, Long> {
    Page<Parking> findAllReportForVehicle(Long vehicleId, Pageable pageable);

    List<Parking> findAllReportForVehicle(Long vehicleId);
}
