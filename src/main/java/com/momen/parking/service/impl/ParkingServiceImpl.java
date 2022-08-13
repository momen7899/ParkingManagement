package com.momen.parking.service.impl;

import com.momen.parking.common.exception.NotFoundException;
import com.momen.parking.model.Parking;
import com.momen.parking.model.PriceRate;
import com.momen.parking.model.Vehicle;
import com.momen.parking.repository.ParkingRepository;
import com.momen.parking.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private ParkingRepository repository;

    @Override
    public Parking addParking(Parking parking) {
        return repository.save(parking);
    }

    @Override
    public Parking updateParking(Parking parking) {
        Parking savedBefore = getParking(parking.getId());
        savedBefore.setEntryTime(parking.getEntryTime());
        savedBefore.setExitTime(parking.getExitTime());
        savedBefore.setPriceRate(parking.getPriceRate());
        savedBefore.setVehicle(parking.getVehicle());
        savedBefore.setTotalPrice(parking.getTotalPrice());
        savedBefore.setIsPaid(parking.getIsPaid());
        return repository.save(savedBefore);
    }

    @Override
    public void deleteParking(Long parkingId) {
        Parking savedBefore = getParking(parkingId);
        repository.delete(savedBefore);
    }

    @Override
    public Parking getParking(Long parkingId) {
        Optional<Parking> optionalParking = repository.findById(parkingId);

        if (optionalParking.isPresent())
            return optionalParking.get();

        throw new NotFoundException("Parking not found");
    }

    @Override
    public Page<Parking> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
    }

    @Override
    public List<Parking> getAll() {
        return (List<Parking>) repository.findAll();
    }

    @Override
    public Parking vehicleRegistration(Long parkingId) {
        Date date = new Date();
        Parking savedBefore = getParking(parkingId);
        savedBefore.setEntryTime(date);
        return repository.save(savedBefore);
    }

    @Override
    public Parking leaveVehicle(Long parkingId) {
        Date date = new Date();
        Parking savedBefore = getParking(parkingId);
        savedBefore.setExitTime(date);
        return repository.save(savedBefore);
    }

    @Override
    public Parking calculatePrice(Long parkingId) {
        Parking savedBefore = getParking(parkingId);
        savedBefore.setTotalPrice(calculatePrice(savedBefore.getPriceRate()));
        return repository.save(savedBefore);
    }

    private Long calculatePrice(PriceRate priceRate) {
        return priceRate.getEntry();
    }

    @Override
    public Parking confirmPayment(Long parkingId) {
        Parking savedBefore = getParking(parkingId);
        savedBefore.setIsPaid(true);
        return repository.save(savedBefore);
    }

    @Override
    public List<Parking> vehicleTrafficReport(Vehicle vehicle) {
        return repository.findAllReportForVehicle(vehicle.getId());
    }

    @Override
    public Page<Parking> pagingVehicleTrafficReport(Integer page, Integer size, Vehicle vehicle) {
        return repository.findAllReportForVehicle(vehicle.getId(), PageRequest.of(page, size, Sort.by("id").ascending()));
    }

}
